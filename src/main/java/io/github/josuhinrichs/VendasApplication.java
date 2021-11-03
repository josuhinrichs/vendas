package io.github.josuhinrichs;

import io.github.josuhinrichs.domain.entity.Cliente;
import io.github.josuhinrichs.domain.entity.Pedido;
import io.github.josuhinrichs.domain.repository.Clientes;
import io.github.josuhinrichs.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(
            @Autowired Clientes clientes,
            @Autowired Pedidos pedidos
            ){
        return args -> {
            System.out.println("Salvando Clientes");
            clientes.save(new Cliente("Josue"));
            Cliente nicole = new Cliente("Nicole");
            clientes.save(nicole);

            Pedido p = new Pedido();
            p.setCliente(nicole);
            p.setDataPedido( LocalDate.now() );
            p.setTotal(BigDecimal.valueOf(100));

            pedidos.save(p);

            Cliente cliente = clientes.findClienteFetchPedidos(nicole.getId());
            System.out.println(cliente);
            System.out.println(cliente.getPedidos());

            pedidos.findByCliente(nicole).forEach(System.out::println);

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
