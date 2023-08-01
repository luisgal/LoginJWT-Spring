package com.example.login.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.controller.request.AdressRequest;
import com.example.login.controller.request.CreateRequest;
import com.example.login.controller.response.UsuarioResponse;
import com.example.login.core.business.UsuarioService;
import com.example.login.core.domain.UsuarioDom;
import com.example.login.core.exceptions.UsuarioNotFound;
import com.example.login.core.mappers.UsuarioMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
@RequiredArgsConstructor
public class UsuarioController {
	private final UsuarioService service;
	private final UsuarioMapper mapper;
	
	@PostMapping("/create")
	public ResponseEntity<UsuarioResponse> crearUsuario(@RequestBody CreateRequest createRequest){
		createRequest.encryptPassword();
		UsuarioDom usuario = service.createUsuario(mapper.createRequestToUsuDom(createRequest));
		
		UsuarioResponse response = new UsuarioResponse("Usuario creado", usuario.getIdUsuario(), usuario.getNombre(), usuario.getEmail(), null);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PostMapping("/adress")
	public ResponseEntity<UsuarioResponse> setAdrres(@RequestBody AdressRequest adressRequest) throws UsuarioNotFound{
		UsuarioDom usuario = service.findByEmail(adressRequest.getEmail());
		usuario.setCp(adressRequest.getCp());
		usuario = service.setAdressInfo(usuario);
		
		UsuarioResponse response = new UsuarioResponse("Se ingreso la información del domicilio", usuario.getIdUsuario(), usuario.getNombre(), usuario.getEmail(), usuario.getCp());
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
