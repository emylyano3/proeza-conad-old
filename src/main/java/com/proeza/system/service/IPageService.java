package com.proeza.system.service;

import com.proeza.system.service.dto.PageDTO;

public interface IPageService {

    PageDTO findByGroupAndName (String group, String name);
}