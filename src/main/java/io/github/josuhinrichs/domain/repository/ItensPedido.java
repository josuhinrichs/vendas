package io.github.josuhinrichs.domain.repository;

import io.github.josuhinrichs.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedido extends JpaRepository<ItemPedido, Integer> {
}
