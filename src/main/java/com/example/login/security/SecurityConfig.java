package com.example.login.security;

import com.example.login.security.filter.JwtAuthenticationFilter;
import com.example.login.security.filter.JwtAuthorizationFilter;
import com.example.login.security.service.JwtUtilService;
import com.example.login.security.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtUtilService jwtUtilService;
    private final UserDetailsServiceImpl userService;
    private final JwtAuthorizationFilter jwtAuthorizationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager) throws Exception {
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(jwtUtilService);
        jwtAuthenticationFilter.setAuthenticationManager(authenticationManager);

        // Por default es login - si se desea cambiar se debe modificar este parametro
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");

        return httpSecurity
	        	.csrf().disable()
	        	.cors(Customizer.withDefaults())
	        	.authorizeRequests().antMatchers("/usuario/create").permitAll().anyRequest().authenticated()
	        	.and()
	        	.sessionManagement(session ->
	                   session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	                )
	        	.addFilter(jwtAuthenticationFilter)
	        	.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
	        	.build();
        }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(bCryptPasswordEncoder());
        return auth;
    }

    @Bean
    public AuthenticationManager configure(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(authenticationProvider())
                .build();
    }
    
    @Bean
    CorsConfigurationSource corsConfigurationSource(){

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
