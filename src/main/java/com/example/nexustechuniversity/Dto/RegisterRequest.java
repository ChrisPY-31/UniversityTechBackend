package com.example.nexustechuniversity.Dto;

import com.example.nexustechuniversity.utilities.Role;

import jakarta.validation.constraints.*;
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
	@NotNull(message ="El Usuario No encontrado")
	private String username;

	@Email(message = "Email no valido")
	private String email;


	@NotBlank(message = "Contraseña vacia")
	private String password;
	private Role role;
	
	@NotBlank(message = "El nombre no debe estar vacío")
	private String name;

	@NotBlank(message = "El apellido no debe estar vacío")
	private String lastName;

}
