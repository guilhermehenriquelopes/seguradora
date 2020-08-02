package com.asap.seguradora.gestao.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApoliceDTO {

    private ApoliceDetalhesDTO apolice;
    private boolean expirada;
    private long expira_em;
    private long expirou_a;

}
