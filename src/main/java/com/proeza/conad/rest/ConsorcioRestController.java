package com.proeza.conad.rest;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.proeza.conad.dao.IConsorcioDao;
import com.proeza.conad.entity.Consorcio;
import com.proeza.conad.rest.dto.ConsorcioDTO;

import ma.glasnost.orika.MapperFacade;

/**
 * <strong>Documentacion para diseñar la API Rest</strong>
 * <p>
 * <a href="https://stackoverflow.blog/2020/03/02/best-practices-for-rest-api-design/">Best practices for REST API design</a>
 */
@CrossOrigin
@Transactional
@RestController
@RequestMapping("api/consorcios/**")
public class ConsorcioRestController {

	@Autowired
	private IConsorcioDao	consorcioDao;

	@Autowired
	private MapperFacade	mapperFacade;

	@GetMapping
	public ConsorcioDTO find (@RequestParam Long id) {
		try {
			return this.mapperFacade.map(this.consorcioDao.find(id), ConsorcioDTO.class);
		} catch (NoResultException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("El consorcio con id %s no existe", id), e);
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debe indicar el id del consorcio", e);
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void save (@RequestBody ConsorcioDTO dto) {
		try {
			this.consorcioDao.persist(this.mapperFacade.map(dto, Consorcio.class));
		} catch (PersistenceException e) {
			//TODO Se puede trabajar un poco el como obtener un mensaje legible para el usuario, en vez de solo mandar el e.getCause().getMessage() como reason
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getCause().getMessage(), e);
		}
	}

	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update (@RequestBody ConsorcioDTO dto) {
		this.consorcioDao.persist(this.mapperFacade.map(dto, Consorcio.class));
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete (@RequestParam Long id) {
		this.consorcioDao.delete(this.consorcioDao.find(id));
	}
}
