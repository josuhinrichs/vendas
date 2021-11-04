package io.github.josuhinrichs.rest.controller;

import io.github.josuhinrichs.domain.entity.Cliente;
import io.github.josuhinrichs.domain.repository.Clientes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.Optional;

@Controller //gerenciado pelo container de injeção de dependências do spring
public class ClienteController {

    private Clientes clientes;

    public ClienteController(Clientes clientes) {
        this.clientes = clientes;
    }

    @GetMapping("/api/clientes/{id}") //equivalente ao request com GET
    @ResponseBody
    public ResponseEntity getClienteById( @PathVariable Integer id ){   //vai receber variável no path
        Optional<Cliente> cliente = clientes.findById(id);

        if(cliente.isPresent()){
            return ResponseEntity.ok( cliente.get() );        //retorna cliente com status OK
        }

        return ResponseEntity.notFound().build();
    }

}
