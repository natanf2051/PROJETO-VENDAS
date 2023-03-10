package com.painel.domain.vendas;

import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Vendas {

    private String valor;
    private String descricao;
    // private LocalDateTime data;

    public Vendas(DadosVendas valores) {
        this.valor = valores.valor();
        this.descricao = valores.descricao();
        // this.data = LocalDateTime.now();

    }

}
