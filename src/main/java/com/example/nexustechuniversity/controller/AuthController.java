package com.example.nexustechuniversity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nexustechuniversity.Dto.AuthRequest;
import com.example.nexustechuniversity.Dto.AuthResponse;
import com.example.nexustechuniversity.Model.User;
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
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthRequest request){
		authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
		String token = jwtService.generateToken(user);
		
		return ResponseEntity.ok(new AuthResponse(token));
	}
	
}
