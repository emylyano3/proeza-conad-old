package com.proeza.conad.dao.impl;

import org.springframework.stereotype.Repository;

import com.proeza.conad.dao.IExpensaDao;
import com.proeza.conad.entity.Expensa;
import com.proeza.core.persistence.BaseDao;

@Repository
public class ExpensaDao extends BaseDao<Expensa> implements IExpensaDao {

}
