package com.fpoly.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
	@Autowired
	private HttpSession session;

	@GetMapping("logout")
	public String index() {
		session.removeAttribute("userLogin");
		return "redirect:/home";
	}
}
