package br.com.example.crudMysql.service;

import java.util.List;
import java.util.Optional;

import br.com.example.crudMysql.entity.Cliente;

public interface IClienteService {

	List<Cliente> findAll();

	Optional<Cliente> findById(long id);

	Cliente save(Cliente cliente);

	void delete(long id);

}
