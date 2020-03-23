package com.proeza.system.dao;

import org.springframework.stereotype.Repository;

import com.proeza.core.persistence.BaseDao;
import com.proeza.system.entity.Item;

@Repository
public class ItemDao extends BaseDao<Item> implements IItemDao {

}