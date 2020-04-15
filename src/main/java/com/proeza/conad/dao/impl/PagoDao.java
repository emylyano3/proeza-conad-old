package com.proeza.conad.dao.impl;

import org.springframework.stereotype.Repository;

import com.proeza.conad.dao.IPagoDao;
import com.proeza.conad.entity.Pago;
import com.proeza.core.persistence.BaseDao;

@Repository
public class PagoDao extends BaseDao<Pago> implements IPagoDao {

}
