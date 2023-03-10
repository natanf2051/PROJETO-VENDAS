package com.painel.domain.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Integer> {

    Clientes findByCpf(String cpf);
}