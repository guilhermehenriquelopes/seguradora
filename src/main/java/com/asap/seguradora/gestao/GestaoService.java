package com.asap.seguradora.gestao;

import com.asap.seguradora.gestao.DTO.ApoliceDTO;
import org.springframework.stereotype.Service;

@Service
public interface GestaoService {

    ApoliceDTO findById(String id);

}
