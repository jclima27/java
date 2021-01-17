package br.com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients //Habilita o Feign na aplicação
@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	private final EnderecoClient enderecoClient;

	public DemoApplication(EnderecoClient enderecoClient) {
		this.enderecoClient = enderecoClient;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Endereco end = this.enderecoClient.buscaCEP("05185120");
		System.out.println(end);
		
	}

}
