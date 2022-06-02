package com.fpoly.beans;

import com.fpoly.entities.Categories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {

	private String name;
	private double price;
	private String image;
	private int available;
	private String size;
	private String brand;
	private String descriptions;
	private Categories categories;
//	private Set<SaleOff> saleOff;
//	private Set<OrderDetail> orderDetail;
}
