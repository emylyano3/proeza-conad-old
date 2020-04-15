package com.proeza.core.persistence;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.springframework.stereotype.Repository;

@Repository
public class GenericDao {

	@PersistenceContext
	protected EntityManager entityManager;

	public <Entity> Entity find (Class<Entity> entityClass, Object id) {
		return this.entityManager.find(entityClass, id);
	}

	public <Entity> List<Entity> findAll (Class<Entity> entityClass) {
		@SuppressWarnings("unchecked")
		final List<Entity> resultList = this.entityManager
			.createQuery(" select x from " + entityClass.getName() + " x")
			.getResultList();
		return resultList;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	protected <Entity> Entity findByAttribute (Class<Entity> entityClass, SingularAttribute att, Object value) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Entity> criteria = builder.createQuery(entityClass);
		Root<Entity> root = criteria.from(entityClass);
		criteria.select(root);
		criteria.where(builder.equal(root.get(att), value));
		return this.entityManager.createQuery(criteria).getSingleResult();
	}

	public Long getNextId (Class<?> entityClass) {
		Long id = (Long) this.entityManager
			.createQuery(" select max(x.id) from " + entityClass.getName() + " x")
			.getSingleResult();
		return id == null ? 1 : ++id;
	}

	public <Entity> Entity persist (Entity entity) {
		this.entityManager.persist(entity);
		return entity;
	}

	public <Entity> Collection<Entity> persist (Collection<Entity> entities) {
		for (Entity entity : entities) {
			persist(entity);
		}
		return entities;
	}

	public EntityManager getEntityManager () {
		return this.entityManager;
	}

	public void delete (Object entity) {
		this.entityManager.remove(entity);
	}
}