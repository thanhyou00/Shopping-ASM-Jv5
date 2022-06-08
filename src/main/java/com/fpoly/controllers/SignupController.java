package com.fpoly.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fpoly.beans.AccountModel;
import com.fpoly.entities.Account;
import com.fpoly.repositories.AccountRepository;
import com.fpoly.utils.EncryptUtil;

@Controller
public class SignupController {
	@Autowired
	private AccountRepository accountRepo;

	@GetMapping("signup")
	public String index(@ModelAttribute("account") AccountModel model) {
		return "commons/signup";
	}

	@PostMapping("signup")
	public String signup(@Valid @ModelAttribute("account") AccountModel model, BindingResult result) {
		if (result.hasErrors()) {
			return "commons/signup";
		} else {
			Account acc = new Account();
			acc.setFullname(model.getFullname().trim());
			acc.setEmail(model.getEmail().trim());
			acc.setPassword(EncryptUtil.encrypt(model.getPassword().trim()));
			acc.setUsername(model.getUsername().trim());
			acc.setAvatar("placeholder.png");
			acc.setAdmin(0);
			this.accountRepo.save(acc);
			return "commons/signup";
		}
	}
}
