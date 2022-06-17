package com.fpoly.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpoly.beans.HistoryModel;
import com.fpoly.beans.ProductModel;
import com.fpoly.entities.Account;
import com.fpoly.entities.Categories;
import com.fpoly.entities.Product;
import com.fpoly.repositories.AccountRepository;
import com.fpoly.repositories.CategoryRepository;
import com.fpoly.repositories.OrderDetailRepository;
import com.fpoly.repositories.ProductRepository;

@Controller
public class HomeController {
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private CategoryRepository cateRepo;
	@Autowired
	private OrderDetailRepository odetailRepo;
	@Autowired
	private HttpSession session;
	@Autowired
	private AccountRepository accRepo;
	@Autowired
	private HttpServletRequest request;

	@GetMapping("home")
	public String home(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "12") int size,
			@ModelAttribute("product") ProductModel product) {
		Principal principal = request.getUserPrincipal();
		Account account = this.accRepo.findByEmailEquals(principal.getName());
		if (account != null) {
			List<HistoryModel> listDetail = this.odetailRepo.getHistory(account.getId());
			session.setAttribute("countCart", listDetail.size());
		}
		model.addAttribute("page", page);
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> p = this.productRepo.findAll(pageable);
		List<Categories> listCate = this.cateRepo.findAll();

		model.addAttribute("listCate", listCate);
		model.addAttribute("data", p);
		return "commons/home";
	}
}
