package com.fpoly.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpoly.beans.AccountModel;
import com.fpoly.entities.Account;
import com.fpoly.repositories.AccountRepository;

@Controller
public class AccountController {

	@Autowired
	private AccountRepository accountRepo;

	@GetMapping("admin/accounts/index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "8") int size,
			@ModelAttribute("account") AccountModel account) {
		model.addAttribute("page", page);
		Pageable pageable = PageRequest.of(page, size);
		Page<Account> p = this.accountRepo.findAll(pageable);
		model.addAttribute("data", p);
		return "admin/accounts/account";
	}

	@PostMapping("admin/accounts/store")
	public String store(AccountModel model) {
		Account acc = new Account();
		acc.setFullname(model.getFullname());
		acc.setEmail(model.getEmail());
		acc.setPassword(model.getPassword());
		acc.setUsername(model.getUsername());
		acc.setAvatar(model.getAvatar());
		acc.setAdmin(model.getAdmin());
		this.accountRepo.save(acc);
		return "redirect:/admin/accounts/index";
	}

	@GetMapping("admin/accounts/delete/{id}")
	public String delete(@PathVariable("id") Account account) {
		this.accountRepo.delete(account);
		return "redirect:/admin/accounts/index";
	}
}