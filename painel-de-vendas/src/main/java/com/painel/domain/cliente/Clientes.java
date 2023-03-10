package com.painel.domain.cliente;

import org.springframework.transaction.annotation.Transactional;

import com.painel.domain.vendas.Vendas;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "cliente")
@Table(name = "clientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String telefone;
    private String cpf;

    @Embedded
    private Vendas vendaService;


    public Clientes(DadosCliente dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.vendaService = new Vendas(dados.VendaService());

    }

    // public Optional<ClienteService> buscaCpf(int cpf){
    // return clientesRepository.findBycpf(cpf);
    // }
}
