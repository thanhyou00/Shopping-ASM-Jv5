package com.fpoly.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fpoly.entities.Product;

@Controller
public class BuyProductController {

	@GetMapping("/user/buy-product/{id}")
	public String index(@PathVariable("id") Product product, Model model) {
		model.addAttribute("product", product);
		return "/user/buy-product";
	}
}
