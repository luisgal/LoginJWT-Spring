package com.example.login.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdressRequest {
	private String email;
	private Long cp;
}
