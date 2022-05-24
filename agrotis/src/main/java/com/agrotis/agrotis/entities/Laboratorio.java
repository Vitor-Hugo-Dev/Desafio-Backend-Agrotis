package com.agrotis.agrotis.entities;

public class Laboratorio {

  private String labNome;

  private Long labId;

  public Laboratorio(String labNome, Long labId) {
    super();
    this.labNome = labNome;
    this.labId = labId;
  }

  public String getLabNome() {
    return this.labNome;
  }

  public void setLabNome(String labNome) {
    this.labNome = labNome;
  }

  public Long getLabId() {
    return this.labId;
  }

  public void setLabId(Long labId) {
    this.labId = labId;
  }
}
