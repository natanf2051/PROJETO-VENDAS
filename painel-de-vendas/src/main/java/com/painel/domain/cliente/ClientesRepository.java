package com.painel.domain.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<ClienteService, Integer> {
}