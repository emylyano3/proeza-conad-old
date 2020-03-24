package com.proeza.system.rest;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proeza.system.service.IMenuService;
import com.proeza.system.service.dto.MenuDTO;

@CrossOrigin
@RestController
@RequestMapping("api")
public class SystemRestController {

	@Autowired
	private IMenuService	menuService;

	@RequestMapping(value = "/menu/{code}/{user}", method = RequestMethod.GET)
	public MenuDTO getMenu (@PathVariable String code, @PathVariable String user, Locale locale) {
		return this.menuService.getMenu(code, user, locale.toString());
	}

}