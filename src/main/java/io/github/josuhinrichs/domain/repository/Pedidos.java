package io.github.josuhinrichs.domain.repository;

import io.github.josuhinrichs.domain.entity.Cliente;
import io.github.josuhinrichs.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Pedidos extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);

    @Query("select p from Pedido p left join fetch p.itens where p.id =:id")
    Optional<Pedido> findByIdFetchItens(@Param("id")Integer id);
}
