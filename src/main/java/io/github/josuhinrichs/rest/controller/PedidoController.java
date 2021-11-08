package io.github.josuhinrichs.rest.controller;

import io.github.josuhinrichs.domain.entity.Pedido;
import io.github.josuhinrichs.rest.dto.PedidoDTO;
import io.github.josuhinrichs.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController { //não é entidade simples como as outras

    private PedidoService service;

    public void setService(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save( @RequestBody PedidoDTO dto ){
        Pedido pedido = service.salvar(dto);
        return pedido.getId();
    }
}
