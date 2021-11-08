package io.github.josuhinrichs.service.impl;

import io.github.josuhinrichs.domain.repository.Pedidos;
import io.github.josuhinrichs.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private Pedidos repository;

    public void setRepository(Pedidos repository) {
        this.repository = repository;
    }
}
