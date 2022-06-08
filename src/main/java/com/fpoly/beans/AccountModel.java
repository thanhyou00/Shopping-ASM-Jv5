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
public class AccountModel {

	@NotBlank(message = "Không được để trống fullname")
	private String fullname;
	@NotBlank(message = "Không được để trống email")
	@Email(message = "Không đúng định dạng email")
	private String email;
	@NotBlank(message = "Không được để trống username")
	private String username;
	@NotBlank(message = "Không được để trống password")
	private String password;
	private String avatar;
	private int admin;
}