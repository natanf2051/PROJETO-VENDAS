package com.painel.domain.cliente;

import com.painel.domain.vendas.Vendas;

public record DetalheCliente(int id, String nome, String telefone, String cpf, Vendas vendas) {

    public DetalheCliente(Clientes cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getTelefone(), cliente.getCpf(), cliente.getVendaService());
    }

    
    
}
