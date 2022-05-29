package com.agrotis.cadastro.controllers;

import java.util.List;

import com.agrotis.cadastro.entities.Servico;
import com.agrotis.cadastro.exceptions.DatasException;
import com.agrotis.cadastro.exceptions.LaboratorioNaoEncontradoException;
import com.agrotis.cadastro.exceptions.PropriedadeNaoEncontradaException;
import com.agrotis.cadastro.exceptions.ServicoNaoEncontradoException;
import com.agrotis.cadastro.exceptions.UsuarioInvalidoException;
import com.agrotis.cadastro.services.ServicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoController {

  @Autowired
  private ServicoService servicoService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Servico> findAll() {
    List<Servico> servicos = servicoService.findAll();
    return servicos;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Servico insert(@RequestBody Servico servico)
      throws PropriedadeNaoEncontradaException,
      LaboratorioNaoEncontradoException,
      DatasException,
      UsuarioInvalidoException,
      NullPointerException {

    Servico novoServico = servicoService.insert(servico);
    return novoServico;
  }

  @GetMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Servico findById(@PathVariable Long id) throws ServicoNaoEncontradoException {
    Servico servico = servicoService.findById(id);
    return servico;
  }

  @PutMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Servico update(@PathVariable Long id, @RequestBody Servico servico)
      throws NullPointerException,
      ServicoNaoEncontradoException,
      PropriedadeNaoEncontradaException,
      LaboratorioNaoEncontradoException,
      DatasException, UsuarioInvalidoException {

    Servico servicoAtualizado = servicoService.update(id, servico);

    return servicoAtualizado;
  }

  @DeleteMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) throws ServicoNaoEncontradoException {
    servicoService.delete(id);
  }

}
