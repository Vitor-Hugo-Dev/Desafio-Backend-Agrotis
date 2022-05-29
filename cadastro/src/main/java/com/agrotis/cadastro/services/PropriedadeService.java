package com.agrotis.cadastro.services;

import java.util.Optional;

import com.agrotis.cadastro.entities.Propriedade;
import com.agrotis.cadastro.exceptions.PropriedadeNaoEncontradaException;
import com.agrotis.cadastro.repositories.PropriedadeRepository;

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
