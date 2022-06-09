package com.fpoly.beans;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("deprecation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginModel {

	@NotBlank(message = "Không được để trống email")
	@Email(message = "Không đúng định dạng email")
	private String email;
	@NotBlank(message = "Không được để trống password")
	private String password;
}