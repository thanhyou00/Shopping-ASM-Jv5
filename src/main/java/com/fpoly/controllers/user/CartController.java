
package com.fpoly.controllers.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpoly.entities.Account;
import com.fpoly.entities.Order;
import com.fpoly.entities.OrderDetail;
import com.fpoly.entities.Product;
import com.fpoly.repositories.OrderDetailRepository;
import com.fpoly.repositories.OrderRepository;
import com.fpoly.repositories.ProductRepository;

@Controller
public class CartController {

	@Autowired
	private OrderDetailRepository odetailRepo;
	@Autowired
	private OrderRepository oderRepo;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private HttpSession session;

	@GetMapping("/user/carts")
	public String index(Model model) {
//		System.out.println("check : " + this.odetailRepo.getHistory());
		List<OrderDetail> listDetail = odetailRepo.findAll();
		model.addAttribute("listDetail", listDetail);
		return "/user/cart";
	}

	@PostMapping("/user/store")
	public String store(@RequestParam(name = "price", defaultValue = "0") double price,
			@RequestParam(name = "product", defaultValue = "product") int product,
			@RequestParam(name = "quantity") String quantity) {
		Order order = new Order();
		Account account = (Account) session.getAttribute("userLogin");
		order.setShippingAddress("HANOI");
		order.setAccount(account);
		order.setOrderDate("0000-00-00");
		order.setOrderStatus(0);
		this.oderRepo.save(order);
		OrderDetail odetail = new OrderDetail();
		Product pro = this.productRepo.findById(product).get();
		odetail.setQuantity(Integer.valueOf(quantity.substring(1)));
		odetail.setProduct(pro);
		odetail.setPrice(price);
		odetail.setOrder(order);

		this.odetailRepo.save(odetail);
		return "redirect:/user/carts";
	}
}
