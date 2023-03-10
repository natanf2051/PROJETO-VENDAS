package com.painel.controller;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.painel.domain.cliente.Cliente;
import com.painel.domain.cliente.ClienteService;
import com.painel.domain.cliente.ClientesRepository;
import com.painel.domain.cliente.DetalheCliente;

import jakarta.validation.Valid;


@RestController
@RequestMapping("inicio")
public class inicio {

    @Autowired
    private ClientesRepository Crepor;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid Cliente dadosCliente, UriComponentsBuilder uriBuilder ){
        var cliente = new ClienteService(dadosCliente);
        Crepor.save(cliente);

        var uri = uriBuilder.path("/inicio/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalheCliente(cliente));
    }


    @GetMapping
    public ResponseEntity<List<ClienteService>> listar(){
        var clientes = Crepor.findAll();
        return ResponseEntity.ok(clientes);
    }

  //   @GetMapping
  //   public ResponseEntity<Page<DetalheCliente>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
  //       var page = Crepor.findAll(paginacao).map(DetalheCliente::new);
  //       return ResponseEntity.ok(page);
  //   }
}

