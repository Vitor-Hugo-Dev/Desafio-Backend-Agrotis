package com.agrotis.cadastro.domain.propriedade.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.agrotis.cadastro.domain.servico.model.Servico;

@Entity
@Table(name = "tb_propriedade")
public class Propriedade {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String cnpj;

  @OneToMany(mappedBy = "propriedade", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Servico> servicos = new ArrayList<Servico>();

  public void addServico(Servico servico) {
    servicos.add(servico);
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCnpj() {
    return this.cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

}