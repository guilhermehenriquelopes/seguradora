package com.asap.seguradora.cliente;

import com.asap.seguradora.exception.HandlerException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController extends HandlerException {

    @Autowired
    private ClienteService service;

    @GetMapping
    @ApiOperation(value = "Retorna uma lista com todos os clientes")
    public List<Cliente> findAll() {
        return service.findAll();
    }

    @GetMapping("{cpf}")
    @ApiOperation(value = "Retorna um cliente com o CPF informado")
    public Optional<Cliente> findByCpf(@RequestParam String cpf) {
        return service.findById(cpf);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cadastra um novo cliente")
    public Cliente save(@RequestBody @Valid Cliente cliente) {
        return service.save(cliente);
    }

    @PutMapping
    @ApiOperation(value = "Atualiza os dados de um cliente")
    public Cliente update(@RequestBody @Valid Cliente cliente) {
        return service.save(cliente);
    }

    @DeleteMapping
    @ApiOperation(value = "Deleta o cliente com o CPF informado")
    public void deleteByCpf(@RequestParam String cpf) {
        service.deleteById(cpf);
    }
}
