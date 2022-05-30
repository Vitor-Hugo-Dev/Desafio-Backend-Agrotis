package com.agrotis.cadastro.aplication.propriedade.service;

import java.util.Optional;

import com.agrotis.cadastro.domain.propriedade.exception.PropriedadeNaoEncontradaException;
import com.agrotis.cadastro.domain.propriedade.model.Propriedade;
import com.agrotis.cadastro.infrastructure.persistence.hibernate.repository.propriedade.PropriedadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropriedadeService {

  @Autowired
  PropriedadeRepository propriedadeRepository;

  public void verificaPropriedade(Long id) throws PropriedadeNaoEncontradaException, NullPointerException {
    if (id == null) {
      throw new NullPointerException("O id da propriedade não pode ser null!");
    }

    Optional<Propriedade> optionalPropriedade = propriedadeRepository.findById(id);

    if (!optionalPropriedade.isPresent()) {
      throw new PropriedadeNaoEncontradaException("Propriedade não encontrada. Insira uma propriedade válida");
    }
  }
}
