package br.com.example.crudMysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.example.crudMysql.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
