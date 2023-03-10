package com.painel.domain.cliente;


import org.springframework.data.jpa.repository.JpaRepository;



public interface ClientesRepository extends JpaRepository<Clientes, String> {

  
   Clientes findByCpf(String cpf);
    

   //@Query("SELECT c.nome, c.telefone FROM Clientes c WHERE c.cpf = :cpf")
  // Clientes buscacpf(@Param("cpf") String cpf);
}