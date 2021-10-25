package io.github.josuhinrichs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //annotation de configuration - classe apenas de configuração-> springboot escaneia todas as classes de configuração
public class MinhaConfiguration {

    //default - nome é o mesmo do método
    @Bean(name = "applicationName")   //espécie de objeto configurável global - criando um objeto string
    public String applicationName(){
        return "Sistema de Vendas";
    }
}
