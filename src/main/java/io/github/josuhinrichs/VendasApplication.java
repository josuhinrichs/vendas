package io.github.josuhinrichs;

import io.github.josuhinrichs.domain.entity.Cliente;
import io.github.josuhinrichs.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            System.out.println("Salvando Clientes");
            clientes.save(new Cliente("Josue"));
            clientes.save(new Cliente("Nicole"));

            List<Cliente> result = clientes.buscaPorNome("Josue");
            result.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
