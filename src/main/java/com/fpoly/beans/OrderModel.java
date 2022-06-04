package com.fpoly.beans;

import com.fpoly.entities.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {

	private int id;
	private String shippingAddress;
	private String orderDate;
	private int orderStatus;
	private Account account;
//	private Set<OrderDetail> orderDetail;
}
