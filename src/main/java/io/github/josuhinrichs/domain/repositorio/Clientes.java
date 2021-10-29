package io.github.josuhinrichs.domain.repositorio;


import io.github.josuhinrichs.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> { //jpa é uma interface com todos os métodos que fiz manualmente já implementados

    @Query(value = " select * from Cliente c where c.nome like '%:nome%' ", nativeQuery = true) //consulta sql, e não hql
    List<Cliente> buscaPorNome( @Param("nome") String nome );

    @Query(" delete from Cliente c where c.nome =:nome ")
    @Modifying
    void deleteByNome(String nome);

    boolean existsByNome(String nome);
}
