package io.github.josuhinrichs.service.impl;

import io.github.josuhinrichs.domain.entity.Cliente;
import io.github.josuhinrichs.domain.entity.ItemPedido;
import io.github.josuhinrichs.domain.entity.Pedido;
import io.github.josuhinrichs.domain.entity.Produto;
import io.github.josuhinrichs.domain.repository.Clientes;
import io.github.josuhinrichs.domain.repository.ItensPedido;
import io.github.josuhinrichs.domain.repository.Pedidos;
import io.github.josuhinrichs.domain.repository.Produtos;
import io.github.josuhinrichs.exception.RegraNegocioException;
import io.github.josuhinrichs.rest.dto.ItemPedidoDTO;
import io.github.josuhinrichs.rest.dto.PedidoDTO;
import io.github.josuhinrichs.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PedidoServiceImpl implements PedidoService {

    private final Pedidos repository;
    private final Clientes clientesRepository;
    private final ItensPedido itensPedidoRepository;
    private final Produtos produtosRepository;

    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository
                .findById(idCliente)
                .orElseThrow( () -> new RegraNegocioException("Código de cliente inválido.") );

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente( cliente );

        List<ItemPedido> itensPedido = converterItens(pedido, dto.getItens());
        repository.save(pedido);
        itensPedidoRepository.saveAll(itensPedido);
        pedido.setItens(itensPedido);
        return pedido;
    }

    private List<ItemPedido> converterItens(Pedido pedido, List<ItemPedidoDTO> itens){
        if (itens.isEmpty()){
            throw new RegraNegocioException("Não é possível realizar um pedido sem itens.");
        }

        return itens
                .stream()
                .map( dto -> {
                    Integer idProduto = dto.getProduto();
                    Produto produto = produtosRepository
                            .findById(idProduto)
                            .orElseThrow(() -> new RegraNegocioException("Código de produto inválido: " + idProduto));

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);

                    return itemPedido;

                }).collect(Collectors.toList());
    }
}