package com.painel.domain.cliente;

import com.painel.domain.vendas.VendaService;

public record DetalheCliente(int id, String nome, String telefone, String cpf, VendaService vendas) {

    public DetalheCliente(ClienteService cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getTelefone(), cliente.getCpf(), cliente.getVendaService());
    }

    
    
}
