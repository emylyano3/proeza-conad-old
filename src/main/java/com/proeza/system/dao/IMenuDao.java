package com.proeza.system.dao;

import com.proeza.core.persistence.Dao;
import com.proeza.system.entity.Menu;

public interface IMenuDao extends Dao<Menu> {

    Menu findByCode(String code);
}