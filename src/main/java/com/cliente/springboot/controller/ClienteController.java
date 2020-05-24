package com.cliente.springboot.controller;

import java.util.Optional;

import com.cliente.springboot.model.Cliente;
import com.cliente.springboot.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping()
public class ClienteController {

    @Autowired
	ClienteRepository clienteRepository;

    @GetMapping(value="/Clientes")
    public @ResponseBody Iterable<Cliente> getClientes(){
        return clienteRepository.findAll();
    }
    @GetMapping("/Cliente/{id}")
    public @ResponseBody Optional<Cliente> getCliente(@PathVariable Integer id){
        return Optional.ofNullable(clienteRepository.findById(id));
    }

    @PostMapping(value="/Cliente")
    public String postCliente(@RequestBody @Valid Cliente cliente){
        clienteRepository.save(cliente);
        return String.format("Dados salvos: %s", cliente);
    }
    @DeleteMapping(value="/Cliente")
    public String deleteCliente(@PathVariable Integer id){
        clienteRepository.deleteById(id);
        return "Deleted " + id;
    }
    @PutMapping(value="/Cliente")
    public String putCliente(@RequestBody @Valid Cliente cliente){
        clienteRepository.alter(cliente);
        return String.format("alterado: %s", cliente);
    }
}
