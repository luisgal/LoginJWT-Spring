package com.example.login.core.exceptions;

public class UsuarioNotFound extends Exception{
	public UsuarioNotFound(String message) {
		super(message);
	}
	
	public UsuarioNotFound(String message, Throwable cause) {
		super(message, cause);
	}
}
