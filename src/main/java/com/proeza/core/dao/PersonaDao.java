package com.proeza.core.dao;

import org.springframework.stereotype.Repository;

import com.proeza.core.dao.impl.IPersonaDao;
import com.proeza.core.entity.Persona;
import com.proeza.core.persistence.BaseDao;

@Repository
public class PersonaDao extends BaseDao<Persona> implements IPersonaDao {

}