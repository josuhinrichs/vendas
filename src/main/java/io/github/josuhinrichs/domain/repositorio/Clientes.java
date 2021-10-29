package io.github.josuhinrichs.domain.repositorio;

import io.github.josuhinrichs.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class Clientes {

    @Autowired
    private EntityManager entityManager;

    @Transactional  //necessário para identificar o método no JPA
    public Cliente salvar(Cliente cliente){
        entityManager.persist(cliente);
        return cliente;
    }

    @Transactional
    public Cliente atualizar(Cliente cliente){
        entityManager.merge(cliente);
        return cliente;
    }

    @Transactional
    public void deletar(Cliente cliente){
        if(!entityManager.contains(cliente)){
            cliente = entityManager.merge(cliente);
        }
        entityManager.remove(cliente);
    }

    @Transactional
    public void deletar(Integer id){
        Cliente cliente = entityManager.find(Cliente.class, id);
        deletar(cliente);
    }

    @Transactional(readOnly = true) //transação é apenas de leitura - otimizações
    public List<Cliente> buscarPorNome(String nome){
        String jpql = " select c from Cliente c where c.nome like :nome  ";
        TypedQuery<Cliente> query =  entityManager.createQuery(jpql, Cliente.class);    //query tipado com classe desejada
        query.setParameter("nome","%" + nome + "%");    //buscar qualquer parte do nome
        return query.getResultList();
    }

    @Transactional
    public List<Cliente> obterTodos(){
        return entityManager
                .createQuery("from Cliente", Cliente.class)
                .getResultList();
    }

}
