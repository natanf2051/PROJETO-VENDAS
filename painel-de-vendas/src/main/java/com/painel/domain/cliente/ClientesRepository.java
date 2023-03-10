package com.painel.domain.cliente;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface ClientesRepository extends JpaRepository<Clientes, String> {

  @Query(value = "SELECT id, nome, cpf FROM clientes where cpf = ':cpf'")
  Clientes findByCpf(String cpf);
    

   //@Query("SELECT c.nome, c.telefone FROM Clientes c WHERE c.cpf = :cpf")
  // Clientes buscacpf(@Param("cpf") String cpf);
}