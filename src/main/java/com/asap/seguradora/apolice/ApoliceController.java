package com.asap.seguradora.apolice;

import com.asap.seguradora.exception.HandlerException;
import com.asap.seguradora.util.Messages;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apolice")
public class ApoliceController extends HandlerException {

    @Autowired
    private ApoliceService service;

    @GetMapping
    @ApiOperation(value = "Retorna uma lista com todas as apólices")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = Messages.OK),
            @ApiResponse(code = 204, message = Messages.NOT_FOUND_RESULT)
    })
    public List<Apolice> findAll() {
        return service.findAll();
    }

    @GetMapping("{numero}")
    @ApiOperation(value = "Retorna a apólice com o número informado")
    public Optional<Apolice> findById(@RequestParam String numero) {
        return service.findById(numero);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cadastra uma nova apólice")
    public Apolice save(@RequestBody @Valid Apolice apolice) {
        return service.save(apolice);
    }

    @PutMapping
    @ApiOperation(value = "Atualiza os dados de uma apólice")
    public Apolice update(@RequestBody @Valid Apolice apolice){
        return service.save(apolice);
    }

    @DeleteMapping
    @ApiOperation(value = "Deleta a apólice com o número informado")
    public void deleteByNumero(@RequestParam String numero){
        service.deleteById(numero);
    }

}
