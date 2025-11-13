package com.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.UserRequestDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")

public class UserController {
	@PostMapping("/register")
    public ResponseEntity<String> registerUser(
    		@Valid @RequestBody UserRequestDTO userRequestDTO,
    		BindingResult result
    		){
		
				if(result.hasErrors()) {
					return new ResponseEntity<>(result.getFieldErrors().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
				}
				return new ResponseEntity<>("User Registered!",HttpStatus.CREATED);
	}
}