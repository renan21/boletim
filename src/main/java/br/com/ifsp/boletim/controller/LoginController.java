package br.com.ifsp.boletim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifsp.boletim.model.LoginModel;
import br.com.ifsp.boletim.service.LoginService;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping
	public String login() {
		return "login";
	}
	
	@PostMapping
	public String login(@Validated LoginModel login) {
		return loginService.efetuarLogin(login);
	}
	

}
