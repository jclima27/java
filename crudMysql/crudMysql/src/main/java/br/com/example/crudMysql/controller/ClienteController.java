package br.com.example.crudMysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.crudMysql.entity.Cliente;
import br.com.example.crudMysql.service.IClienteService;

@RestController
@RequestMapping({"/clientes"})
public class ClienteController {

	@Autowired
	private IClienteService service;
	
	@GetMapping
	public List<Cliente> findAll() {
		return  service.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Cliente> findById(@PathVariable long id) {
		return service.findById(id)
		           .map(cliente -> ResponseEntity.ok().body(cliente))
		           .orElse(ResponseEntity.notFound().build()); 
	}
	
	@PostMapping
	public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
		Cliente cli = service.save(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(cli);
	}
	
	@PutMapping
	public ResponseEntity<Cliente> update(@RequestBody Cliente cliente){
		
		return service.findById(cliente.getId())
		           .map(cli -> {
		               cli.setNome(cliente.getNome());
		               cli.setCpf(cliente.getCpf());
		               cli.setEmail(cliente.getEmail());
		               cli.setTelefone(cliente.getTelefone());
		               Cliente updated = service.save(cli);
		               return ResponseEntity.ok().body(updated);
		           }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity <?> delete(@PathVariable long id) {
		return service.findById(id)
		           .map(record -> {
		               service.delete(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
	}
	
}
