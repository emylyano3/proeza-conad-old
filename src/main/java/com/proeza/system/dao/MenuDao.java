package com.proeza.system.dao;

import org.springframework.stereotype.Repository;

import com.proeza.core.persistence.BaseDao;
import com.proeza.system.entity.Menu;
import com.proeza.system.entity.Menu_;

@Repository
public class MenuDao extends BaseDao<Menu> implements IMenuDao {

	@Override
	public Menu findByCode(String name) {
		return findByAttribute(Menu_.code, name);
	}
}