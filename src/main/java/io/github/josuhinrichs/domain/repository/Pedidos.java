package io.github.josuhinrichs.domain.repository;

import io.github.josuhinrichs.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
}
