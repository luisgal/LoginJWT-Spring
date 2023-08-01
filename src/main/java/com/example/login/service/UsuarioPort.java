package com.example.login.service;

import java.util.Optional;

import com.example.login.service.jpa.entities.UsuarioEntitty;

public interface UsuarioPort {
	Optional<UsuarioEntitty> findByEmail(String email);
	Optional<UsuarioEntitty> findById(Long id);
	UsuarioEntitty createUsuario(UsuarioEntitty usuarioEntitty);
	UsuarioEntitty editUsuario(UsuarioEntitty usuarioEntitty);
	UsuarioEntitty setAdressInfo(UsuarioEntitty usuarioEntitty);
}
