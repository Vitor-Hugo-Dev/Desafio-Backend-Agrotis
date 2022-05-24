package com.agrotis.agrotis.entities;

public class Propriedade {

  private String propNome;

  private Long propId;

  private String cnpj;

  public Propriedade(String propNome, Long propId, String cnpj) {
    super();
    this.propNome = propNome;
    this.propId = propId;
    this.cnpj = cnpj;
  }

  public String getPropNome() {
    return this.propNome;
  }

  public void setPropNome(String propNome) {
    this.propNome = propNome;
  }

  public Long getPropId() {
    return this.propId;
  }

  public void setPropId(Long propId) {
    this.propId = propId;
  }

  public String getCnpj() {
    return this.cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }
}
