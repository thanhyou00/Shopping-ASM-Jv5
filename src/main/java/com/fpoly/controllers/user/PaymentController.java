package com.fpoly.controllers.user;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fpoly.beans.HistoryModel;
import com.fpoly.beans.PaymentModel;
import com.fpoly.entities.Account;
import com.fpoly.entities.Order;
import com.fpoly.repositories.AccountRepository;
import com.fpoly.repositories.OrderDetailRepository;
import com.fpoly.repositories.OrderRepository;

@Controller
public class PaymentController {
	@Autowired
	private OrderDetailRepository odetailRepo;
	@Autowired
	private OrderRepository oderRepo;
	@Autowired
	private HttpSession session;
	private Order ord = null;
	@Autowired
	private AccountRepository accRepo;
	@Autowired
	private HttpServletRequest request;

	@GetMapping("/user/payment")
	public String index(@ModelAttribute("payment") PaymentModel payment) {
		Principal principal = request.getUserPrincipal();
		Account account = this.accRepo.findByEmailEquals(principal.getName());
		List<HistoryModel> listDetail = this.odetailRepo.getHistory(account.getId());
		session.setAttribute("countCart", listDetail.size());
		return "/user/payment";
	}

	@SuppressWarnings("deprecation")
	@PostMapping("/user/payment-verify")
	public String verify(@Valid @ModelAttribute("payment") PaymentModel payment, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Errorsss");
			return "/user/payment";
		} else {
			Principal principal = request.getUserPrincipal();
			Account account = this.accRepo.findByEmailEquals(principal.getName());
			List<HistoryModel> listDetail = this.odetailRepo.getHistory(account.getId());
			for (HistoryModel historyModel : listDetail) {
				ord = this.oderRepo.getById(historyModel.getOrder().getId());
				ord.setShippingAddress(payment.getShippingAddress());
				ord.setOrderStatus(1);
				this.oderRepo.save(ord);
				System.out.println("Doneeee");
			}

			return "redirect:/home";
		}
	}
	
	@GetMapping("/admin/payment-verify/{id}")
	public String AdminVerify(@PathVariable("id") Order order) {
		order.setOrderStatus(1);
		this.oderRepo.save(order);
		return "redirect:/admin/order-details/index";
	}
}








