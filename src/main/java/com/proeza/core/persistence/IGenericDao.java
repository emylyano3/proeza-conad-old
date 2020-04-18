package com.proeza.core.persistence;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

public interface IGenericDao {

	<Entity> Entity find (Class<Entity> entityClass, Object id);

	<Entity> List<Entity> findAll (Class<Entity> entityClass);

	Long getNextId (Class<?> entityClass);

	<Entity> Entity persist (Entity entity);

	<Entity> Collection<Entity> persist (Collection<Entity> entities);

	EntityManager getEntityManager ();

	void delete (Object entity);

}