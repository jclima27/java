package br.com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
 * url - endereço do web service
 * name - nome do client
 * */
@FeignClient(url = "https://api.postmon.com.br/v1/", name = "endereco")
public interface EnderecoClient {

	@GetMapping("cep/{cep}")
	Endereco buscaCEP (@PathVariable("cep") String cep);
}
