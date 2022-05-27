package com.agrotis.cadastro.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_servico")
public class Servico {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime initialDate;

  private LocalDateTime finalDate;

  private String description;

  @ManyToOne
  @JoinColumn(name = "propriedade_id")
  private Propriedade propriedade;

  @ManyToOne
  @JoinColumn(name = "laboratorio_id")
  private Laboratorio laboratorio;

  @ManyToOne
  @JoinColumn(name = "pessoa_id")
  private Pessoa pessoa;

  public Pessoa getPessoa() {
    return this.pessoa;
  }

  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
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

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getInitialDate() {
    return this.initialDate;
  }

  public void setInitialDate(LocalDateTime initialDate) {
    this.initialDate = initialDate;
  }

  public LocalDateTime getFinalDate() {
    return this.finalDate;
  }

  public void setFinalDate(LocalDateTime finalDate) {
    this.finalDate = finalDate;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}