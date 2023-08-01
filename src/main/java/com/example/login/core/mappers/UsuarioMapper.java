package com.example.login.core.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.login.controller.request.CreateRequest;
import com.example.login.core.domain.UsuarioDom;
import com.example.login.service.jpa.entities.UsuarioEntitty;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface UsuarioMapper {
	@Mapping(source = "cp.cp", target = "cp")
	UsuarioDom usuarioEntityToDom(UsuarioEntitty usuarioEntitty);
	@InheritInverseConfiguration
	UsuarioEntitty usuarioDomToEntity(UsuarioDom usuarioDom);
	UsuarioDom createRequestToUsuDom(CreateRequest createRequest);
}
