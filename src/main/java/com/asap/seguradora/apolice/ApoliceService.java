package com.asap.seguradora.apolice;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ApoliceService {

    List<Apolice> findAll();

    Optional<Apolice> findById(String id);

    Apolice save(Apolice apolice);

    void deleteAll();

    void deleteById(String id);

}
