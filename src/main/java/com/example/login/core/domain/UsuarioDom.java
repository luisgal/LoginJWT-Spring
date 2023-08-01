package com.example.login.core.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDom {
	private Long idUsuario;
	private String nombre;
	private String email;
	private String password;
	private Long cp;
	
	public UsuarioDom(Long id) {
		this.idUsuario = id;
	}
}
