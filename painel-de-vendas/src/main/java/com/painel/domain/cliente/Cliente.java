package com.painel.domain.cliente;

import org.hibernate.validator.constraints.br.CPF;

import com.painel.domain.vendas.Vendas;

import jakarta.persistence.Column;

public record Cliente(
    
    String nome, 
    
    String telefone,
    String cpf,
    Vendas VendaService

){}
