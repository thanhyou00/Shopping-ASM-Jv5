
package com.fpoly.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final String PK = "id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@Column(name = "shipping_address", nullable = false, length = 255)
	private String shippingAddress;
	@Column(name = "order_date", nullable = false)
	private String orderDate;
	@Column(name = "order_status", nullable = false, precision = 10)
	private int orderStatus;
	@ManyToOne(optional = false)
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	@OneToMany(mappedBy = "order")
	private Set<OrderDetail> orderDetail;

}
