package com.fpoly.controllers.admin;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpoly.beans.AccountModel;
import com.fpoly.entities.Account;
import com.fpoly.repositories.AccountRepository;
import com.fpoly.services.ExchangeValidator;
import com.fpoly.services.JsonValidatorResponse;
import com.fpoly.utils.EncryptUtil;

@Controller
public class AccountController {

	@Autowired
	private AccountRepository accountRepo;

	// create
	@PostMapping("admin/accounts/store")
	public String store(@Validated @ModelAttribute("account") AccountModel model, BindingResult result, Model models,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "6") int size) {
		models.addAttribute("page", page);
		Pageable pageable = PageRequest.of(page, size);
		Page<Account> p = this.accountRepo.findAll(pageable);
		models.addAttribute("data", p);
		ExchangeValidator exchangeValidate = new ExchangeValidator();
		JsonValidatorResponse jsonValidatorResponse = new JsonValidatorResponse();
		exchangeValidate.validate(model, result);
		if (result.hasErrors()) {
			Map<String, String> errors = result.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
			jsonValidatorResponse.setValidated(false);
			jsonValidatorResponse.setErrorMessages(errors);
			return "admin/accounts/account";
		} else {
			Account acc = new Account();
			acc.setFullname(model.getFullname());
			acc.setEmail(model.getEmail());
			acc.setPassword(EncryptUtil.encrypt(model.getPassword()));
			acc.setUsername(model.getUsername());
			acc.setAvatar(model.getAvatar());
			acc.setAdmin(model.getAdmin());
			jsonValidatorResponse.setValidated(true);
			jsonValidatorResponse.setValidatioObject(model);
			this.accountRepo.save(acc);
			return "redirect:/admin/accounts/index";
		}
	}

	// read
	@GetMapping("admin/accounts/index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "6") int size,
			@ModelAttribute("account") AccountModel account) {
		model.addAttribute("page", page);
		Pageable pageable = PageRequest.of(page, size);
		Page<Account> p = this.accountRepo.findAll(pageable);
		model.addAttribute("data", p);
		return "admin/accounts/account";
	}

	// update
	@PostMapping("admin/accounts/update/{id}")
	public String update(@PathVariable("id") Account acc, @ModelAttribute("account") AccountModel model) {
		acc.setFullname(model.getFullname());
		acc.setEmail(model.getEmail());
		acc.setUsername(model.getUsername());
		acc.setAvatar(model.getAvatar());
		acc.setAdmin(model.getAdmin());
		this.accountRepo.save(acc);
		return "redirect:/admin/accounts/index";
	}

	// delete
	@GetMapping("admin/accounts/delete/{id}")
	public String delete(@PathVariable("id") Account account) {
		this.accountRepo.delete(account);
		return "redirect:/admin/accounts/index";
	}
}
