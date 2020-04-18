package com.proeza.core.persistence;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.SingularAttribute;

public interface Dao<Entity> {

	Entity find (Object id);

	@SuppressWarnings({"rawtypes"})
	Entity findByAttribute (SingularAttribute att, Object value);

	List<Entity> findAll ();

	Entity persist (Entity entity);

	Collection<Entity> persist (Collection<Entity> entities);

	void delete (Entity entity);

	EntityManager getEntityManager ();

	Long getNextId ();
}