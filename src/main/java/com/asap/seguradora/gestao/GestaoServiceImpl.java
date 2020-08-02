package com.asap.seguradora.gestao;

import com.asap.seguradora.apolice.Apolice;
import com.asap.seguradora.apolice.ApoliceRepository;
import com.asap.seguradora.exception.NoContentException;
import com.asap.seguradora.gestao.DTO.ApoliceDTO;
import com.asap.seguradora.gestao.DTO.ApoliceDetalhesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class GestaoServiceImpl implements GestaoService {

    @Autowired
    private ApoliceRepository repository;

    @Override
    public ApoliceDTO findById(String numero) {
        Optional<Apolice> entidade = repository.findById(numero);

        if (entidade == null)
            throw new NoContentException();

        Apolice apolice = entidade.get();

        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime vigencia = LocalDateTime.ofInstant(apolice.getVigencia_fim().toInstant(), ZoneId.systemDefault());

        long expira_em = ChronoUnit.DAYS.between(agora, vigencia);

        ApoliceDTO apoliceDTO = ApoliceDTO.builder()
                .expirada(expira_em <= 0)
                .expira_em(expira_em <= 0 ? 0 : expira_em)
                .expirou_a(expira_em > 0 ? 0 : expira_em * -1)
                .apolice(ApoliceDetalhesDTO.builder()
                        .numero(apolice.getNumero())
                        .veiculo_placa(apolice.getVeiculo_placa())
                        .valor(apolice.getValor())
                        .build())
                .build();

        return apoliceDTO;
    }
}
