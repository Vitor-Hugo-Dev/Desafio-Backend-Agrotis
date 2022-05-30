package com.agrotis.cadastro.aplication.laboratorio.service;

import java.util.Optional;

import com.agrotis.cadastro.domain.laboratorio.exception.LaboratorioNaoEncontradoException;
import com.agrotis.cadastro.domain.laboratorio.model.Laboratorio;
import com.agrotis.cadastro.infrastructure.persistence.hibernate.repository.laboratorio.LaboratorioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaboratorioService {

  @Autowired
  LaboratorioRepository laboratorioRepository;

  public void verificaLaboratorio(Long id) throws LaboratorioNaoEncontradoException, NullPointerException {
    if (id == null) {
      throw new NullPointerException("O id do laboratório não pode ser null!");
    }

    Optional<Laboratorio> optionalLaboratorio = laboratorioRepository.findById(id);

    if (!optionalLaboratorio.isPresent()) {
      throw new LaboratorioNaoEncontradoException("Laboratório não encontrado. Insira um laboratório válido");
    }
  }
}
