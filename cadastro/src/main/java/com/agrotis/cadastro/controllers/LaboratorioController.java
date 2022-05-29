package com.agrotis.cadastro.controllers;

import java.util.List;

import com.agrotis.cadastro.entities.Laboratorio;
import com.agrotis.cadastro.repositories.LaboratorioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/laboratorios")
public class LaboratorioController {

  @Autowired
  private LaboratorioRepository laboratorioRepository;

  @GetMapping
  public List<Laboratorio> findAll() {
    List<Laboratorio> laboratorios = laboratorioRepository.findAll();
    return laboratorios;
  }

  @GetMapping(value = "/{id}")
  public Laboratorio findById(@PathVariable Long id) {
    Laboratorio laboratorio = laboratorioRepository.findById(id).get();
    return laboratorio;
  }
}
