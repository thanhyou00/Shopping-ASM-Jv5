package com.fpoly.controllers.admin;

import java.util.List;

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

import com.fpoly.beans.ProductModel;
import com.fpoly.entities.Categories;
import com.fpoly.entities.Product;
import com.fpoly.repositories.CategoryRepository;
import com.fpoly.repositories.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private CategoryRepository cateRepo;

	// create
	@PostMapping("admin/products/store")
	public String store(ProductModel model) {
		Product pro = new Product();
		pro.setAvailable(model.getAvailable());
		pro.setBrand(model.getBrand());
		pro.setImage(model.getImage());
		pro.setDescriptions(model.getDescriptions());
		pro.setName(model.getName());
		pro.setPrice(model.getPrice());
		pro.setSize(model.getSize());
		pro.setCategories(model.getCategories());
		this.productRepo.save(pro);
		return "redirect:/admin/products/index";
	}

	// read
	@GetMapping("admin/products/index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "6") int size,
			@ModelAttribute("product") ProductModel product) {
		model.addAttribute("page", page);
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> p = this.productRepo.findAll(pageable);
		List<Categories> listCate = this.cateRepo.findAll();
		model.addAttribute("listCate", listCate);
		model.addAttribute("data", p);
		return "admin/products/product";
	}

	// update
	@PostMapping("admin/products/update/{id}")
	public String update(@PathVariable("id") Product pro, @ModelAttribute("product") ProductModel product) {
		pro.setAvailable(product.getAvailable());
		pro.setBrand(product.getBrand());
		pro.setImage(product.getImage());
		pro.setDescriptions(product.getDescriptions());
		pro.setName(product.getName());
		pro.setPrice(product.getPrice());
		pro.setSize(product.getSize());
		pro.setCategories(product.getCategories());
		this.productRepo.save(pro);
		return "redirect:/admin/products/index";
	}

	// delete
	@GetMapping("admin/products/delete/{id}")
	public String delete(@PathVariable("id") Product product) {
		this.productRepo.delete(product);
		return "redirect:/admin/products/index";
	}
}
