package com.example.nexustechuniversity.Dto;

import com.example.nexustechuniversity.utilities.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

	@NotBlank(message = "El usuario no debe estar vacio")
	private String username;

	@Email(message = "Email no valido")
	private String email;

	@Min(4)
	@Max(8)
	@NotBlank(message = "Contraseña vacia")
	private String password;
	private Role role;
	
	private String name;
	private String lastName;

}
