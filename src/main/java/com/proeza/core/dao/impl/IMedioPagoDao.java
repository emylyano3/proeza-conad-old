package com.proeza.core.dao.impl;

import com.proeza.core.entity.MedioPago;
import com.proeza.core.persistence.Dao;

public interface IMedioPagoDao extends Dao<MedioPago> {

	MedioPago findByCode (String code);
}