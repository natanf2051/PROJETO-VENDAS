package com.painel.domain.cliente;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, String> {

   //@Query("SELECT * FROM clientes WHERE cpf = :cpf")
   Clientes findByCpf(String cpf);
    
}