package com.fpoly.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fpoly.entities.OrderDetail;
import com.fpoly.repositories.OrderDetailRepository;

@Controller
public class CartController {

	@Autowired
	private OrderDetailRepository odetailRepo;

	@GetMapping("/user/carts")
	public String index(Model model) {
		List<OrderDetail> listDetail = odetailRepo.findAll();
		model.addAttribute("listDetail", listDetail);
		return "/user/cart";
	}
}
