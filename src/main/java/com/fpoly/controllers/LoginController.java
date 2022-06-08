package com.fpoly.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpoly.entities.Account;
import com.fpoly.repositories.AccountRepository;

@Controller
public class LoginController {

	@Autowired
	HttpSession session;
	@Autowired
	private AccountRepository accRepo;

	@GetMapping("login")
	public String index() {
		return "commons/login";
	}

	@PostMapping("login")
	public String isLogin(@RequestParam(name = "email", defaultValue = "user") String email,
			@RequestParam(name = "password", defaultValue = "user") String password) {
		Account userLogin = this.accRepo.findByEmailEquals(email);
		if (userLogin != null) {
			session.setAttribute("userLogin", userLogin);
			return "redirect:/home";
		}
		return "commons/login";
	}

}
