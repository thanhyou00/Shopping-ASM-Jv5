package com.fpoly.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fpoly.entities.Order;
import com.fpoly.entities.OrderDetail;
import com.fpoly.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HistoryModel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Product product;
	private OrderDetail orderDetail;
	private Order order;
}
