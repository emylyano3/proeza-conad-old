package com.proeza.web.handler;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proeza.conad.rest.RestResponseStatusExceptionBuilder;

import lombok.Builder;
import lombok.Getter;

/**
 * Handler que maneja las provenientes de los Controllers Rest
 * <p>
 * Por convencion, los controllers REST manejan las excepciones que pueden provenir de la capa de persistencia y las
 * transforman en excepciones del tipo {@link ResponseStatusException} indicando el {@link HttpStatus} y razon
 * correspondiente, de esta manera se logra un mejor mapeo de excepciones a estados HTTP.
 *
 * @see <a href="https://www.baeldung.com/exception-handling-for-rest-with-spring#controlleradvice">Error Handling for
 *      REST with Spring</a>
 *
 * @author Emiliano
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger					log	= Logger.getLogger(RestResponseEntityExceptionHandler.class);

	@Autowired
	private ErrorTracker						errorTracker;

	@Autowired
	private RestResponseStatusExceptionBuilder	exceptionBuilder;

	/**
	 * Captura las {@link ResponseStatusException} lanzadas por los controllers REST, y crea un body con la informacion
	 * del error usando Json.
	 */
	@ExceptionHandler({ResponseStatusException.class})
	public ResponseEntity<Object> responseStatusException (final ResponseStatusException e, final WebRequest r) {
		log.info(String.format("Handling exception %s", e.getClass().getSimpleName()));
		this.errorTracker.trackError(e);
		return handleExceptionInternal(e,
			RestExceptionResponseDTO
				.builder()
				.status(e.getStatus().value())
				.reason(e.getReason())
				.url(((ServletWebRequest) r).getRequest().getRequestURI())
				.build()
				.asJson(),
			new HttpHeaders(),
			e.getStatus(),
			r);
	}

	/**
	 * Maneja las posibles excepciones no manejadas por los controllers REST quizas creadas en el commit de la
	 * transaccion.
	 */
	@ExceptionHandler({PersistenceException.class})
	public ResponseEntity<Object> persistenceException (final PersistenceException e, final WebRequest r) {
		log.info(String.format("Handling exception %s", e.getClass().getSimpleName()));
		this.errorTracker.trackError(e);
		Exception ex =  this.exceptionBuilder.build(e);
		return handleExceptionInternal(ex,
			RestExceptionResponseDTO
				.builder()
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.reason(ex.getMessage())
				.url(((ServletWebRequest) r).getRequest().getRequestURI())
				.build()
				.asJson(),
			new HttpHeaders(),
			HttpStatus.INTERNAL_SERVER_ERROR,
			r);
	}

	@Getter
	@Builder
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	static class RestExceptionResponseDTO {
		int		status;
		String	reason;
		String	url;

		public String asJson () {
			try {
				return new ObjectMapper().writeValueAsString(this);
			} catch (JsonProcessingException e) {
				return toString();
			}
		}
	}
}
