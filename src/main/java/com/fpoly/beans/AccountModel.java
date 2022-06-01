package com.fpoly.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel {
	private String fullname;
	private String email;
	private String username;
	private String password;
	private String avatar;
	private int admin;
}