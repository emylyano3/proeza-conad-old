package com.proeza.conad.rest.controller;

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
import com.proeza.conad.rest.RestResponseStatusExceptionBuilder;
import com.proeza.conad.rest.dto.ConsorcioDTO;
import com.proeza.conad.rest.dto.DireccionDTO;
import com.proeza.core.entity.Direccion;
import com.proeza.core.persistence.IGenericDao;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MappingException;

/**
 * <strong>Documentacion para diseñar la API Rest</strong>
 * <p>
 * <a href="https://stackoverflow.blog/2020/03/02/best-practices-for-rest-api-design/">Best practices for REST API
 * design</a>
 */
@CrossOrigin
@Transactional
@RestController
@RequestMapping("api/consorcios/**")
public class ConsorcioRestController {

	@Autowired
	private IConsorcioDao						consorcioDao;

	@Autowired
	private IGenericDao							genericDao;

	@Autowired
	private MapperFacade						mapperFacade;

	@Autowired
	private RestResponseStatusExceptionBuilder	exceptionBuilder;

	@GetMapping
	public ConsorcioDTO find (@RequestParam Long id) {
		try {
			Consorcio c = this.consorcioDao.find(id);
			ConsorcioDTO cdto = this.mapperFacade.map(c, ConsorcioDTO.class);
			cdto.setDireccion(this.mapperFacade.map(c.getDireccion(), DireccionDTO.class));
			return cdto;
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
			throw this.exceptionBuilder.build(e);
		}
	}

	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update (@RequestBody ConsorcioDTO dto) {
		try {
			Direccion d;
			if (dto.getDireccion().getId() == null) {
				d = this.genericDao.persist(this.mapperFacade.map(dto.getDireccion(), Direccion.class));
			} else {
				d = this.genericDao.find(Direccion.class, dto.getDireccion().getId());
			}
			Consorcio c = this.consorcioDao.find(dto.getId());
			this.mapperFacade.map(dto, c);
			c.setDireccion(d);
			this.consorcioDao.persist(c);
		} catch (PersistenceException e) {
			throw this.exceptionBuilder.build(e);
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debe indicar el id del consorcio", e);
		} catch (MappingException e) {
			throw this.exceptionBuilder.build(e);
		}
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete (@RequestParam Long id) {
		try {
			this.consorcioDao.delete(this.consorcioDao.find(id));
		} catch (PersistenceException e) {
			throw this.exceptionBuilder.build(e);
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debe indicar el id del consorcio", e);
		}
	}
}
