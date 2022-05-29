package com.agrotis.cadastro.controllers;

import java.util.List;

import com.agrotis.cadastro.entities.Propriedade;
import com.agrotis.cadastro.repositories.PropriedadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/propriedades")
public class PropriedadeController {

  @Autowired
  private PropriedadeRepository propriedadeRepository;

  @GetMapping
  public List<Propriedade> findAll() {
    List<Propriedade> propriedades = propriedadeRepository.findAll();
    return propriedades;
  }

  @GetMapping(value = "/{id}")
  public Propriedade findById(@PathVariable Long id) {
    Propriedade propriedade = propriedadeRepository.findById(id).get();
    return propriedade;
  }

}
