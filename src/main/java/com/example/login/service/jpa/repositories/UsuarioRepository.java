package com.example.login.service.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login.service.jpa.entities.UsuarioEntitty;

public interface UsuarioRepository extends JpaRepository<UsuarioEntitty, Long>{
	Optional<UsuarioEntitty> findByEmail(String email);
}
