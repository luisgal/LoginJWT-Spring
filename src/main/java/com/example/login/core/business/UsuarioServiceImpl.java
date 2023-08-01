package com.example.login.core.business;

import org.springframework.stereotype.Service;

import com.example.login.core.domain.UsuarioDom;
import com.example.login.core.exceptions.UsuarioNotFound;
import com.example.login.core.mappers.UsuarioMapper;
import com.example.login.service.UsuarioPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{
	private final UsuarioPort usuarioPort;
	private final UsuarioMapper mapper;

	@Override
	public UsuarioDom findByEmail(String email) throws UsuarioNotFound {
		return mapper.usuarioEntityToDom(usuarioPort.findByEmail(email)
				.orElseThrow(() -> new UsuarioNotFound("No se encontro el usuario. Email: " + email)));
	}

	@Override
	public UsuarioDom findById(Long id) throws UsuarioNotFound {
		return mapper.usuarioEntityToDom(usuarioPort.findById(id)
				.orElseThrow(() -> new UsuarioNotFound("No se encontro el usuario. Id: " + id)));
	}

	@Override
	public UsuarioDom createUsuario(UsuarioDom UsuarioDom) {
		return mapper.usuarioEntityToDom(usuarioPort.createUsuario(mapper.usuarioDomToEntity(UsuarioDom)));
	}

	@Override
	public UsuarioDom editUsuario(UsuarioDom UsuarioDom) {
		return mapper.usuarioEntityToDom(usuarioPort.editUsuario(mapper.usuarioDomToEntity(UsuarioDom)));
	}

	@Override
	public UsuarioDom setAdressInfo(UsuarioDom UsuarioDom) {
		System.out.println(UsuarioDom.getCp());
		return mapper.usuarioEntityToDom(usuarioPort.setAdressInfo(mapper.usuarioDomToEntity(UsuarioDom)));
	}
}
