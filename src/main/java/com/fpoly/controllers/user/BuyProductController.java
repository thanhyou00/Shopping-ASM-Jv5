package com.fpoly.controllers.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fpoly.entities.OrderDetail;
import com.fpoly.entities.Product;
import com.fpoly.repositories.OrderDetailRepository;

@Controller
public class BuyProductController {

	@Autowired
	private OrderDetailRepository odetailRepo;
	@Autowired
	private HttpSession session;

	@GetMapping("/user/buy-product/{id}")
	public String index(@PathVariable("id") Product product, Model model) {
		List<OrderDetail> listDetail = odetailRepo.findAll();
		session.setAttribute("countCart", listDetail.size());
		model.addAttribute("product", product);
		return "/user/buy-product";
	}
}
