package io.github.tenmenezes.produtosapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController
public class ProdutosApiApplication {

//	// GetMapping => Mapeando o retorno do metodo para uma chamada Get
//	@GetMapping("/hello-world")
//	public String helloWorld(){
//		return "Hello World from Spring Boot!";
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProdutosApiApplication.class, args);
	}

}
