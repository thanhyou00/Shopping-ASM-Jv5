package com.fpoly.beans;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("deprecation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentModel {

	@NotBlank(message = "Không được để trống địa chỉ")
	private String shippingAddress;
}
