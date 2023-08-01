package com.example.login.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UsuarioResponse {
	private String message;
	private Long idUsuario;
	private String nombre;
	private String email;
	private Long cp;
}
