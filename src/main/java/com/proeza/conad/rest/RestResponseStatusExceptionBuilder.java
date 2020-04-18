package com.proeza.conad.rest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class RestResponseStatusExceptionBuilder {

	public ResponseStatusException build (Throwable t) {
		Throwable aux = t;
		while (aux.getCause() != null && !aux.getCause().equals(aux)) {
			aux = aux.getCause();
		}
		/*
		 * TODO Pongo bad request porque asumo el caso mas simple que es que se omitio algun dato no nuleable o fallo
		 * alguna FK. En ese caso el request estaria mal formado.
		 * Para mejorar esto se podria crear un Map con:
		 * [textos comunes que puedan estar en el mensaje de excepcion : HTTP STATUS]
		 * De esta forma se podria mejorar la asertividad de los mensajes mostrados al usuario y hasta hacer una traduccion.
		 *
		 * Ejemplo:
		 *
		 * Si el mensaje de excepcion tiene el texto "Duplicate entry" se mapearia a BAD_REQUEST con mensaje "Ya existe un registro"
		 */
		return new ResponseStatusException(HttpStatus.BAD_REQUEST, aux.getMessage(), aux);
	}
}
