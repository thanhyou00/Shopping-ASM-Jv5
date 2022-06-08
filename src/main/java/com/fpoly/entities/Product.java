
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
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final String PK = "id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@Column(nullable = false, length = 255)
	private String name;
	@Column(nullable = false, precision = 22)
	private double price;
	@Column(nullable = false, length = 255)
	private String image;
	@Column(nullable = false, precision = 10)
	private int available;
	@Column(nullable = false, length = 10)
	private String size;
	@Column(nullable = false, length = 255)
	private String brand;
	@Column(nullable = false, length = 255)
	private String descriptions;
	@ManyToOne(optional = false)
	@JoinColumn(name = "category_id", nullable = false)
	private Categories categories;
	@OneToMany(mappedBy = "product")
	private Set<SaleOff> saleOff;
	@OneToMany(mappedBy = "product")
	private Set<OrderDetail> orderDetail;

}
