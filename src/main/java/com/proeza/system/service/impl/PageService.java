package com.proeza.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proeza.system.dao.IPageDao;
import com.proeza.system.service.IPageService;
import com.proeza.system.service.dto.PageDTO;

@Service
@Transactional
public class PageService implements IPageService {

    @Autowired
    private IPageDao pageDao;

    @Override
    public PageDTO findByGroupAndName (String group, String name) {
        return new PageDTO(this.pageDao.findByGroupAndName(group, name));
    }
}