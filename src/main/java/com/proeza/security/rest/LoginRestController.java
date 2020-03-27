package com.proeza.security.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proeza.security.dto.UsuarioDTO;
import com.proeza.security.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class LoginRestController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "user/authenticate", method = RequestMethod.POST)
	public UsuarioDTO authenticate (@RequestParam(name = "username", required = true) String username, @RequestParam(name = "password", required = false) String password) {
		UsuarioDTO user = this.userService.findByAlias(username);
		System.out.println(user.getPassword());
		return user;
	}
}
