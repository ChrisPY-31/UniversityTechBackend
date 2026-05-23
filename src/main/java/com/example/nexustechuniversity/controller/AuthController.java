package com.example.nexustechuniversity.controller;

import com.example.nexustechuniversity.Dto.AuthResponse;
import com.example.nexustechuniversity.Dto.PersonDto;
import com.example.nexustechuniversity.service.PersonService;
import com.example.nexustechuniversity.service.Impl.IMailSender;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nexustechuniversity.Dto.AuthRequest;
import com.example.nexustechuniversity.Dto.RegisterRequest;
import com.example.nexustechuniversity.Model.Person;
import com.example.nexustechuniversity.Model.User;
import com.example.nexustechuniversity.repository.PersonRepository;
import com.example.nexustechuniversity.repository.UserRepository;
import com.example.nexustechuniversity.service.JwtService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthenticationManager authManager;
	private final UserRepository userRepository;
	private final JwtService jwtService;
	private final PasswordEncoder passwordEncoder;
	private final PersonRepository personRepository;
	private final IMailSender mailSender;

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request, HttpServletResponse response) {
		authManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
		User user = userRepository.findByUsername(request.username()).orElseThrow();
		String token = jwtService.generateToken(user);

		setJwtCookie(response, token);
		return ResponseEntity.ok().body(new AuthResponse( user.getIdUser(),user.getRole(),"Inicio se Sesion Exitoso" , true , false));
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request, HttpServletResponse response) {
		Person person = new Person();
		person.setName(request.getName());
		person.setLastName(request.getLastName());

		personRepository.save(person);

		User user = User.builder()
				.username(request.getUsername())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.role(request.getRole())
				.person(person).build();

		userRepository.save(user);

		//mailSender.sendWelcomeEmail(request);

		String token = jwtService.generateToken(user);

		setJwtCookie(response, token);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/logout")
	public ResponseEntity<?> logout(HttpServletResponse response) {
		Cookie cookie = new Cookie("jwt", "");
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return ResponseEntity.ok().body(new AuthResponse(0 , null, "Sesion cerrada correctamente" , false , false));
	}

	private void setJwtCookie(HttpServletResponse response, String token) {
		Cookie cookie = new Cookie("jwt", token);
		cookie.setHttpOnly(true);
		cookie.setSecure(true); // cambiar a true en producción (HTTPS)
		cookie.setPath("/");
		cookie.setMaxAge(7 * 24 * 60 * 60);
		response.addCookie(cookie);
	}

}
