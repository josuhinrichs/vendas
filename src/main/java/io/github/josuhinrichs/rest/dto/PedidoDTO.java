package io.github.josuhinrichs.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {    //padrão data transfer object - maper objeto com propriedades simples

    private Integer cliente;
    private BigDecimal total;
    private List<ItemPedidoDTO> itens;
}
