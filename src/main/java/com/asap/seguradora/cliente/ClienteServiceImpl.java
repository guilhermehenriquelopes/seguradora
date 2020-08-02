package com.asap.seguradora.cliente;

import com.asap.seguradora.exception.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = repository.findAll();

        if (clientes.stream().count() <= 0)
            throw new NoContentException();

        return clientes;
    }

    @Override
    public Optional<Cliente> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

}
