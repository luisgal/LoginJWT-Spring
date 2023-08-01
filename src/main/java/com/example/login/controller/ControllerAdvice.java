package com.example.login.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.login.core.exceptions.UsuarioNotFound;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RestControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler(UsuarioNotFound.class)
	public ResponseEntity<Violation> onUsuarioNotFound(UsuarioNotFound usuarioNotFound) {
		Violation violation = new Violation(usuarioNotFound.getMessage(), "Cause of Exception" + usuarioNotFound.getCause());
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(violation);
	}
	
	@Getter
	@RequiredArgsConstructor
	private class Violation {
		private final String message;
		private final String cause;
	}
}
