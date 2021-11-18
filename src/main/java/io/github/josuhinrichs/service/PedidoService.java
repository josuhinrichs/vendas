package io.github.josuhinrichs.service;

import io.github.josuhinrichs.domain.entity.Pedido;
import io.github.josuhinrichs.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto );

    Optional<Pedido> obterPedidoCompleto(Integer id);
}
