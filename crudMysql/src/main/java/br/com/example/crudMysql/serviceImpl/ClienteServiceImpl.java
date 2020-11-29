package br.com.example.crudMysql.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.example.crudMysql.entity.Cliente;
import br.com.example.crudMysql.repository.ClienteRepository;
import br.com.example.crudMysql.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public List<Cliente> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Cliente> findById(long id) {
		return repository.findById(id);
	}

	@Override
	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

}
