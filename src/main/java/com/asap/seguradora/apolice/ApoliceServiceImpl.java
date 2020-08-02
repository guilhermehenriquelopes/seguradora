package com.asap.seguradora.apolice;

import com.asap.seguradora.exception.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApoliceServiceImpl implements ApoliceService {

    @Autowired
    private ApoliceRepository repository;

    @Override
    public List<Apolice> findAll() {
        List<Apolice> apolices = repository.findAll();

        if (apolices.stream().count() <= 0)
            throw new NoContentException();

        return apolices;
    }

    @Override
    public Optional<Apolice> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Apolice save(Apolice apolice) {
        return repository.save(apolice);
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
