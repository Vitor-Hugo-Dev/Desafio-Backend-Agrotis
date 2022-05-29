package com.agrotis.cadastro.services;

import java.util.List;
import java.util.Optional;

import com.agrotis.cadastro.entities.Servico;
import com.agrotis.cadastro.exceptions.LaboratorioNaoEncontradoException;
import com.agrotis.cadastro.exceptions.PropriedadeNaoEncontradaException;
import com.agrotis.cadastro.exceptions.ServicoNaoEncontradoException;
import com.agrotis.cadastro.exceptions.UsuarioInvalidoException;
import com.agrotis.cadastro.exceptions.DatasException;
import com.agrotis.cadastro.repositories.ServicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

  @Autowired
  ServicoRepository servicoRepository;

  @Autowired
  PropriedadeService propriedadeService;

  @Autowired
  LaboratorioService laboratorioService;

  public List<Servico> findAll() {
    List<Servico> list = servicoRepository.findAll();
    return list;
  }

  public Servico findById(Long id) throws ServicoNaoEncontradoException {
    Optional<Servico> optionalServico = servicoRepository.findById(id);

    verificaSeServicoExiste(optionalServico);

    return optionalServico.get();
  }

  public Servico insert(Servico servico)
      throws PropriedadeNaoEncontradaException, LaboratorioNaoEncontradoException, DatasException,
      UsuarioInvalidoException, NullPointerException {

    verificaServico(servico);

    return servicoRepository.save(servico);
  }

  public Servico update(Long id, Servico servico)
      throws ServicoNaoEncontradoException, NullPointerException,
      PropriedadeNaoEncontradaException, LaboratorioNaoEncontradoException, DatasException, UsuarioInvalidoException {

    Optional<Servico> OptionalServicoAtual = servicoRepository.findById(id);

    verificaSeServicoExiste(OptionalServicoAtual);
    verificaServico(servico);

    Servico servicoAtualizado = OptionalServicoAtual.get();

    servicoAtualizado.setInitialDate(servico.getInitialDate());
    servicoAtualizado.setFinalDate(servico.getFinalDate());
    servicoAtualizado.setLaboratorio(servico.getLaboratorio());
    servicoAtualizado.setPropriedade(servico.getPropriedade());
    servicoAtualizado.setUsuario(servico.getUsuario());
    servicoAtualizado.setDescription(servico.getDescription());

    return servicoRepository.save(servicoAtualizado);
  }

  public void delete(Long id) throws ServicoNaoEncontradoException {
    Optional<Servico> optionalServico = servicoRepository.findById(id);

    verificaSeServicoExiste(optionalServico);

    servicoRepository.delete(optionalServico.get());
  }

  private void verificaSeServicoExiste(Optional<Servico> servico) throws ServicoNaoEncontradoException {
    if (!servico.isPresent()) {
      throw new ServicoNaoEncontradoException("Serviço não encontrado");
    }
  }

  private void verificaServico(Servico servico)
      throws PropriedadeNaoEncontradaException, LaboratorioNaoEncontradoException, DatasException,
      UsuarioInvalidoException, NullPointerException {
    if (servico.getInitialDate() == null) {
      throw new DatasException("Insira uma data inicial válida");
    } else if (servico.getFinalDate() == null) {
      throw new DatasException("Insira uma data final válida");
    } else if (servico.getInitialDate().isAfter(servico.getFinalDate())) {
      throw new DatasException("A data inicial deve ser menor que a data final");
    } else if (servico.getUsuario() == null || servico.getUsuario().isEmpty()) {
      throw new UsuarioInvalidoException("Insira um nome de usuário válido");
    } else if (servico.getDescription() == null) {
      throw new NullPointerException("Insira uma descrição válida");
    }
    laboratorioService.verificaLaboratorio(servico.getLaboratorio().getId());
    propriedadeService.verificaPropriedade(servico.getPropriedade().getId());
  }

}
