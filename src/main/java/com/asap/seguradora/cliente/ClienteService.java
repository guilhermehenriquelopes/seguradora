package com.asap.seguradora.cliente;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClienteService {

    List<Cliente> findAll();

    Optional<Cliente> findById(String id);

    Cliente save(Cliente cliente);

    void deleteAll();

    void deleteById(String id);
}
