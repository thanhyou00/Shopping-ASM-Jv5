package com.fpoly.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.fpoly.beans.OrderModel;

@Controller
public class PaymentController {

	@GetMapping("/user/payment")
	public String index(@ModelAttribute("order") OrderModel order) {

		return "/user/payment";
	}
}
