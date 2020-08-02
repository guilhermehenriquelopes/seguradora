package com.asap.seguradora.gestao;

import com.asap.seguradora.exception.HandlerException;
import com.asap.seguradora.gestao.DTO.ApoliceDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/gestao")
public class GestaoController extends HandlerException {

    @Autowired
    private GestaoService service;

    @GetMapping("apolice-detail/{numero}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Retorna informações detalhadas sobre a apólice com o número informado")
    public ApoliceDTO apoliceDetail(@RequestParam @ApiParam(required = true) @Valid String numero) {
        return service.findById(numero);
    }
}
