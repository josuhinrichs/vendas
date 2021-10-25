package io.github.josuhinrichs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration //annotation de configuration - classe apenas de configuração-> springboot escaneia todas as classes de configuração
@Profile("development") //só vai rodar no ambiente "development"
public class MinhaConfiguration {

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("CONFIGURAÇÃO DE DESENVOLVIMENTO");
        };
    }
}
