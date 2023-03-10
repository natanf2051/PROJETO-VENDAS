package com.painel.domain.cliente;

import com.painel.domain.vendas.Vendas;

public record Cliente(
    
    String nome, 
    
    String telefone,
    String cpf,
    Vendas VendaService

){}
