package com.asap.seguradora.apolice;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@Document(collection = "apolices")
public class Apolice {

    @Id
    private String numero;

    @NotNull
    private Date vigencia_inicio;

    @NotNull
    private Date vigencia_fim;

    @NotEmpty
    private String veiculo_placa;

    @DecimalMin(value = "0.000001")
    private double valor;

}
