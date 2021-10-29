package io.github.josuhinrichs.domain.repositorio;


import io.github.josuhinrichs.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> { //jpa é uma interface com todos os métodos que fiz manualmente já implementados
    List<Cliente> findByNomeLike(String nome);

    boolean existsByNome(String nome);
}
