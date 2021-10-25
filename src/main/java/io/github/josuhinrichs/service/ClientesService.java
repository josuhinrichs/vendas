package io.github.josuhinrichs.service;

import io.github.josuhinrichs.model.Cliente;
import io.github.josuhinrichs.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    private ClientesRepository repository;

    @Autowired  //vai buscar instância desse repository e irá injetar -> INJEÇÃO DE DEPENDÊNCIAS - DELEGAR AO CONTAINER (OUTRO RESPONSÁVEL)
    public ClientesService(ClientesRepository repository){
        this.repository = repository;
    }

    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        this.repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente){
        //aplica validações
    }
}
