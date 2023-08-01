package com.example.login.controller.request;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateRequest {
	private String email;
	private String nombre;
	private String password;
	
	public void encryptPassword() {
		this.password = new BCryptPasswordEncoder().encode(this.password);
	}
}
