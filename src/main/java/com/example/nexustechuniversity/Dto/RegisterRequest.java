package com.example.nexustechuniversity.Dto;

import com.example.nexustechuniversity.utilities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

	private String email;
	private String password;
	private Role role;
	
	private String name;
	private String lastName;
	private String phone;
	
}
