package com.fpoly.beans;

import com.fpoly.entities.Order;
import com.fpoly.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailModel {

	private double price;
	private int quantity;
	private Order order;
	private Product product;
}
