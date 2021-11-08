package io.github.josuhinrichs.rest.controller;

import io.github.josuhinrichs.service.PedidoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController { //não é entidade simples como as outras

    private PedidoService service;

    public void setService(PedidoService service) {
        this.service = service;
    }
}
