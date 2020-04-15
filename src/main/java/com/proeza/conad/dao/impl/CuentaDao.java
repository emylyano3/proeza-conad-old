package com.proeza.conad.dao.impl;

import org.springframework.stereotype.Repository;

import com.proeza.conad.dao.ICuentaDao;
import com.proeza.conad.entity.Cuenta;
import com.proeza.core.persistence.BaseDao;

@Repository
public class CuentaDao extends BaseDao<Cuenta> implements ICuentaDao {

}
