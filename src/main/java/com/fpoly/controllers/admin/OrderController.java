package com.fpoly.controllers.admin;

import java.time.LocalDate;
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

import com.fpoly.beans.OrderModel;
import com.fpoly.entities.Account;
import com.fpoly.entities.Order;
import com.fpoly.repositories.AccountRepository;
import com.fpoly.repositories.OrderRepository;

@Controller
public class OrderController {

	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private AccountRepository accRepo;

	// create
	@PostMapping("admin/orders/store")
	public String store(OrderModel model) {
		LocalDate now = LocalDate.now();
		Order od = new Order();
		od.setAccount(model.getAccount());
		od.setOrderDate(now.toString());
		od.setOrderStatus(model.getOrderStatus());
		od.setShippingAddress(model.getShippingAddress());
		this.orderRepo.save(od);
		return "redirect:/admin/orders/index";
	}

	// read
	@GetMapping("admin/orders/index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "6") int size, @ModelAttribute("order") OrderModel order) {
		model.addAttribute("page", page);
		Pageable pageable = PageRequest.of(page, size);
		Page<Order> o = this.orderRepo.findAll(pageable);
		List<Account> listAcc = this.accRepo.findAll();
		model.addAttribute("listAcc", listAcc);
		model.addAttribute("data", o);
		return "admin/orders/order";
	}

	// update
	@PostMapping("admin/orders/update/{id}")
	public String update(@PathVariable("id") Order od, @ModelAttribute("order") OrderModel order) {
		od.setAccount(order.getAccount());
		od.setOrderStatus(order.getOrderStatus());
		od.setShippingAddress(order.getShippingAddress());
		this.orderRepo.save(od);
		return "redirect:/admin/orders/index";
	}

	// delete
	@GetMapping("admin/orders/delete/{id}")
	public String delete(@PathVariable("id") Order od) {
		this.orderRepo.delete(od);
		return "redirect:/admin/orders/index";
	}
}
