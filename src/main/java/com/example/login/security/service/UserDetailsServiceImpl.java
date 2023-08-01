package com.example.login.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.login.core.business.UsuarioService;
import com.example.login.core.domain.UsuarioDom;
import com.example.login.core.exceptions.UsuarioNotFound;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioService userService;
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        UsuarioDom userEntity;
		try {
			userEntity = userService.findByEmail(username);
		} catch (UsuarioNotFound e) {
			throw new UsernameNotFoundException("No se encotro el usurio: " + username);
		}

        return User
                .withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .roles("USER")
                .build();
    }
}
