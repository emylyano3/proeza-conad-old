package com.proeza.core.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.proeza.core.dao.impl.IMedioPagoDao;
import com.proeza.core.entity.MedioPago;
import com.proeza.core.entity.MedioPago_;
import com.proeza.core.persistence.BaseDao;

@Repository
public class MedioPagoDao extends BaseDao<MedioPago> implements IMedioPagoDao {

	@Override
	public MedioPago findByCode (String code) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<MedioPago> criteria = builder.createQuery(MedioPago.class);
		Root<MedioPago> root = criteria.from(MedioPago.class);
		criteria.select(root);
		criteria.where(builder.equal(root.get(MedioPago_.codigo), code));
		return this.entityManager.createQuery(criteria).getSingleResult();
	}
}