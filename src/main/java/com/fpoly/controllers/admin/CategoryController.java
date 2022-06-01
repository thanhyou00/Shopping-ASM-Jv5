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

import com.fpoly.beans.CategoryModel;
import com.fpoly.entities.Categories;
import com.fpoly.repositories.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository cateRepo;

	// create
	@PostMapping("admin/categories/store")
	public String store(CategoryModel model) {
		Categories cate = new Categories();
		cate.setDescriptions(model.getDescriptions());
		cate.setName(model.getName());
		this.cateRepo.save(cate);
		return "redirect:/admin/categories/index";
	}

	// read
	@GetMapping("admin/categories/index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "6") int size,
			@ModelAttribute("category") CategoryModel categories) {
		model.addAttribute("page", page);
		Pageable pageable = PageRequest.of(page, size);
		Page<Categories> p = this.cateRepo.findAll(pageable);
		model.addAttribute("data", p);
		return "admin/categories/category";
	}

	// update
	@PostMapping("admin/categories/update/{id}")
	public String update(@PathVariable("id") Categories cate, @ModelAttribute("category") CategoryModel model) {
		cate.setDescriptions(model.getDescriptions());
		cate.setName(model.getName());
		this.cateRepo.save(cate);
		return "redirect:/admin/categories/index";
	}

	// delete
	@GetMapping("admin/categories/delete/{id}")
	public String delete(@PathVariable("id") Categories categories) {
		this.cateRepo.delete(categories);
		return "redirect:/admin/categories/index";
	}
}
