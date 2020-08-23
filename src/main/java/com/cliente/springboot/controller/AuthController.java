package com.cliente.springboot.controller;

import java.io.IOException;

import com.cliente.springboot.repository.CredentialRepository;
import com.dto.UserForLoginDto;
import com.dto.UserForRegisterDto;
import com.cliente.springboot.config.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class AuthController  {

    @Autowired
    CredentialRepository _repository;

    
    @Autowired
    private JwtTokenConfig jwtTokenUtil;

    @PostMapping(value = "/Auth/register")
    public String register(@RequestBody UserForRegisterDto value) {
        if (_repository.userExists(value.getUsername()) == false) {

            _repository.register(value);
            return String.format("Cliente cadastrado com sucesso");
        }
        return String.format("Erro ao tentar cadastrar cliente");
    }

    @PostMapping(value = "/Auth/login")
    public String login(@RequestBody UserForLoginDto value) throws IOException {

        boolean result =  _repository.login(value.getUsername(), value.getPassword());

        if (result == true) {
            
            return jwtTokenUtil.generateToken(value);
        }
        return "Unauthorized";
    }


   
    }
    
