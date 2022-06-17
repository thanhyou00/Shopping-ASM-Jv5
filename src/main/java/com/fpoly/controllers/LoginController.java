package com.fpoly.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpoly.beans.LoginModel;
import com.fpoly.entities.Account;
import com.fpoly.repositories.AccountRepository;
import com.fpoly.services.UserDetailImp;
import com.fpoly.utils.EncryptUtil;

@Controller
public class LoginController {

	@Autowired
	HttpSession session;
	@Autowired
	private AccountRepository accRepo;

	@GetMapping("login")
	public String index(@ModelAttribute("login") LoginModel model) {
		return "commons/login";
	}

	@PostMapping("login")
	public String isLogin(@RequestParam(name = "email", defaultValue = "user") String email,
			@RequestParam(name = "password", defaultValue = "user") String password,
			@Validated @ModelAttribute("login") LoginModel model, BindingResult result,
			@AuthenticationPrincipal UserDetailImp user
			) {
		if (result.hasErrors()) {
			return "commons/login";
		} else {
			Account userLogin = this.accRepo.findByEmailEquals(user.getUsername());
			boolean checkPass = EncryptUtil.check(password, userLogin.getPassword());
			System.out.println("check : "+ userLogin);
			if (userLogin != null && checkPass) {
				session.setAttribute("userLogin", userLogin);
				return "redirect:/home";
			} else {
				return "commons/login";
			}
		}
	}

}
