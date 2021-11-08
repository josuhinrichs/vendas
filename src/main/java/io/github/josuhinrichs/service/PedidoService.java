package io.github.josuhinrichs.service;

import io.github.josuhinrichs.domain.entity.Pedido;
import io.github.josuhinrichs.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto );
}
