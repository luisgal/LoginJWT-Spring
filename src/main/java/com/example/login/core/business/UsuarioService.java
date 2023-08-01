package com.example.login.core.business;

import com.example.login.core.domain.UsuarioDom;
import com.example.login.core.exceptions.UsuarioNotFound;

public interface UsuarioService {
	UsuarioDom findByEmail(String email) throws UsuarioNotFound;
	UsuarioDom findById(Long id) throws UsuarioNotFound;
	UsuarioDom createUsuario(UsuarioDom UsuarioDom);
	UsuarioDom editUsuario(UsuarioDom UsuarioDom);
	UsuarioDom setAdressInfo(UsuarioDom UsuarioDom);
}
