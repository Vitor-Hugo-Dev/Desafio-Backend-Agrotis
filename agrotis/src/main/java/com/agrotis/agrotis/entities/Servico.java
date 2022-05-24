package com.agrotis.agrotis.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Servico implements Serializable {

  private static final long serialVersionUID = 1L;

  private String nomePessoa;

  private Long idServico;

  private LocalDate dataInicio;

  private LocalDate dataFim;

  private String observacao;

  private Laboratorio laboratorio;

  private Propriedade propriedade;

  public Servico(String nomePessoa, Long idServico, LocalDate dataInicio,
      LocalDate dataFim, String observacao, Propriedade propriedade, Laboratorio laboratorio) {
    super();
    this.nomePessoa = nomePessoa;
    this.idServico = idServico;
    this.dataInicio = dataInicio;
    this.dataFim = dataFim;
    this.observacao = observacao;
    this.propriedade = propriedade;
    this.laboratorio = laboratorio;
  }

  public String getNomePessoa() {
    return this.nomePessoa;
  }

  public void setNomePessoa(String nomePessoa) {
    this.nomePessoa = nomePessoa;
  }

  public Long getIdServico() {
    return this.idServico;
  }

  public void setIdServico(Long idServico) {
    this.idServico = idServico;
  }

  public LocalDate getDataInicio() {
    return this.dataInicio;
  }

  public void setDataInicio(LocalDate dataInicio) {
    this.dataInicio = dataInicio;
  }

  public LocalDate getDataFim() {
    return this.dataFim;
  }

  public void setDataFim(LocalDate dataFim) {
    this.dataFim = dataFim;
  }

  public String getObservacao() {
    return this.observacao;
  }

  public void setObservacao(String observacao) {
    this.observacao = observacao;
  }

  public Laboratorio getLaboratorio() {
    return this.laboratorio;
  }

  public void setLaboratorio(Laboratorio laboratorio) {
    this.laboratorio = laboratorio;
  }

  public Propriedade getPropriedade() {
    return this.propriedade;
  }

  public void setPropriedade(Propriedade propriedade) {
    this.propriedade = propriedade;
  }
}
