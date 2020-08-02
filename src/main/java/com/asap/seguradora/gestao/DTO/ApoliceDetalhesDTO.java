package com.asap.seguradora.gestao.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApoliceDetalhesDTO {

    private String numero;
    private double valor;
    private String veiculo_placa;

}
