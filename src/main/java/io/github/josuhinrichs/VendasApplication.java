package io.github.josuhinrichs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication //reconhecer que essa classe é uma aplicação Spring Boot
@RestController     //esta vai ser uma aplicação REST - API web
public class VendasApplication {

    @GetMapping("/hello")   //mapear URL /hello no servidor que rodamos à mensagem
    public String helloWorld(){
        return "hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
