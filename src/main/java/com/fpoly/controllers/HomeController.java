package com.fpoly.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpoly.beans.ProductModel;
import com.fpoly.entities.Categories;
import com.fpoly.entities.Product;
import com.fpoly.repositories.CategoryRepository;
import com.fpoly.repositories.ProductRepository;

@Controller
public class HomeController {
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private CategoryRepository cateRepo;

	@GetMapping("")
	public String home(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "6") int size,
			@ModelAttribute("product") ProductModel product) {
		model.addAttribute("page", page);
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> p = this.productRepo.findAll(pageable);
		List<Categories> listCate = this.cateRepo.findAll();
		List<Product> listPro = this.productRepo.findAll();
		model.addAttribute("listCate", listCate);
		model.addAttribute("listPro", listPro);
		model.addAttribute("data", p);
		return "commons/home";
	}
}
