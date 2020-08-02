package com.asap.seguradora.cliente;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@Document(collection = "clientes")
public class Cliente {

    @Id
    @CPF
    private String cpf;

    @NotEmpty
    private String nome_completo;

    @NotEmpty
    private String cidade;

    @NotEmpty
    private String uf;

}
