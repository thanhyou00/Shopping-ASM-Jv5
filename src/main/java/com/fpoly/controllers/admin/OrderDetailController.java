
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

import com.fpoly.beans.OrderDetailModel;
import com.fpoly.entities.Order;
import com.fpoly.entities.OrderDetail;
import com.fpoly.entities.Product;
import com.fpoly.repositories.OrderDetailRepository;
import com.fpoly.repositories.OrderRepository;
import com.fpoly.repositories.ProductRepository;

@Controller
public class OrderDetailController {
	@Autowired
	private OrderDetailRepository odetailRepo;
	@Autowired
	private OrderRepository oderRepo;
	@Autowired
	private ProductRepository productRepo;

	// create
	@PostMapping("admin/order-details/store")
	public String store(OrderDetailModel model) {
		OrderDetail odetail = new OrderDetail();
		odetail.setOrder(model.getOrder());
		odetail.setPrice(model.getPrice());
		odetail.setProduct(model.getProduct());
		odetail.setQuantity(model.getQuantity());
		this.odetailRepo.save(odetail);
		return "redirect:/admin/order-details/index";
	}

	// read
	@GetMapping("admin/order-details/index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "6") int size,
			@ModelAttribute("order-detail") OrderDetailModel odetail) {
		model.addAttribute("page", page);
		Pageable pageable = PageRequest.of(page, size);
		Page<OrderDetail> o = this.odetailRepo.findAll(pageable);
		List<Order> listOrder = this.oderRepo.findAll();
		List<Product> listProduct = this.productRepo.findAll();
		model.addAttribute("listOrder", listOrder);
		model.addAttribute("listProduct", listProduct);
		model.addAttribute("data", o);
		return "admin/order-details/order-detail";
	}

	// update
	@PostMapping("admin/order-details/update/{id}")
	public String update(@PathVariable("id") OrderDetail odetail,
			@ModelAttribute("order-detail") OrderDetailModel model) {
		odetail.setOrder(model.getOrder());
		odetail.setPrice(model.getPrice());
		odetail.setProduct(model.getProduct());
		odetail.setQuantity(model.getQuantity());
		this.odetailRepo.save(odetail);
		return "redirect:/admin/orders/index";
	}

	// delete
	@GetMapping("admin/order-details/delete/{id}")
	public String delete(@PathVariable("id") OrderDetail odetail) {
		this.odetailRepo.delete(odetail);
		return "redirect:/admin/order-details/index";
	}
}
