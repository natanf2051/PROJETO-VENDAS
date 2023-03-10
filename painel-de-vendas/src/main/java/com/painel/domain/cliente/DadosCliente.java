package com.painel.domain.cliente;

import com.painel.domain.vendas.DadosVendas;

public record DadosCliente(
    
    String nome, 
    
    String telefone,
    String cpf,
    DadosVendas VendaService

){}
