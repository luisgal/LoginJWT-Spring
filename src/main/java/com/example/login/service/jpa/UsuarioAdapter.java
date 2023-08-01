package com.example.login.service.jpa;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.login.service.UsuarioPort;
import com.example.login.service.jpa.entities.UsuarioEntitty;
import com.example.login.service.jpa.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioAdapter implements UsuarioPort {
	private final UsuarioRepository usuarioRepository;

	@Override
	public Optional<UsuarioEntitty> findByEmail(String email){
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public Optional<UsuarioEntitty> findById(Long id){
		return usuarioRepository.findById(id);
	}

	@Override
	public UsuarioEntitty createUsuario(UsuarioEntitty usuarioEntitty) {
		usuarioEntitty.setCp(null);
		return usuarioRepository.save(usuarioEntitty);
	}

	@Override
	public UsuarioEntitty editUsuario(UsuarioEntitty usuarioEntitty) {
		return usuarioRepository.save(usuarioEntitty);
	}

	@Override
	@Transactional
	public UsuarioEntitty setAdressInfo(UsuarioEntitty usuarioEntitty){
		return usuarioRepository.save(usuarioEntitty);
	}
}
