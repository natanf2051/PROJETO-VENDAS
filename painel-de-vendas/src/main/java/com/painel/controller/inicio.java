package com.painel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.painel.domain.cliente.DadosCliente;
import com.painel.domain.cliente.Clientes;
import com.painel.domain.cliente.ClientesRepository;
import com.painel.domain.cliente.DetalheCliente;

import jakarta.validation.Valid;

@RestController
@RequestMapping("inicio")
public class inicio {

    @Autowired
    private ClientesRepository clientesRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCliente dadosCliente, UriComponentsBuilder uriBuilder) {
        var cliente = new Clientes(dadosCliente);
        clientesRepository.save(cliente);

        var uri = uriBuilder.path("/inicio/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalheCliente(cliente));
    }

    @GetMapping
    public ResponseEntity<List<Clientes>> listar() {
        var clientes = clientesRepository.findAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/inicio/{cpf}")
    public ResponseEntity listaCpf(@PathVariable String cpf){
        var clienteCpf = clientesRepository.findByCpf(cpf);
    return ResponseEntity.ok().body(new DetalheCliente(clienteCpf));
    }
}
