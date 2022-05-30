package com.agrotis.cadastro.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.agrotis.cadastro.aplication.laboratorio.service.LaboratorioService;
import com.agrotis.cadastro.aplication.propriedade.service.PropriedadeService;
import com.agrotis.cadastro.aplication.servico.service.ServicoService;
import com.agrotis.cadastro.domain.laboratorio.exception.LaboratorioNaoEncontradoException;
import com.agrotis.cadastro.domain.laboratorio.model.Laboratorio;
import com.agrotis.cadastro.domain.propriedade.exception.PropriedadeNaoEncontradaException;
import com.agrotis.cadastro.domain.propriedade.model.Propriedade;
import com.agrotis.cadastro.domain.servico.exception.DatasException;
import com.agrotis.cadastro.domain.servico.exception.ServicoNaoEncontradoException;
import com.agrotis.cadastro.domain.servico.exception.UsuarioInvalidoException;
import com.agrotis.cadastro.domain.servico.model.Servico;
import com.agrotis.cadastro.infrastructure.persistence.hibernate.repository.servico.ServicoRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("ServicoServiceTests")
public class ServicoServiceTests {

  @MockBean
  ServicoRepository servicoRepository;

  @MockBean
  PropriedadeService propriedadeService;

  @MockBean
  LaboratorioService laboratorioService;

  @Autowired
  private ServicoService servicoService;

  @Test
  public void testando() {
    System.out.println("testando");
  }

  @Test
  @DisplayName("Deve retornar uma lista de serviços")
  public void testServicoServiceFindAll() {
    List<Servico> list = new ArrayList<Servico>();
    list.add(criaServico(1L));
    list.add(criaServico(2L));

    Mockito.when(servicoRepository.findAll()).thenReturn(list);

    List<Servico> chamada = servicoService.findAll();
    Mockito.verify(servicoRepository, Mockito.times(1)).findAll();
    assertEquals(chamada.size(), 2);
    assertEquals(chamada.get(0).getClass(), Servico.class);
  }

  @Test
  @DisplayName("Deve retornar um serviço")
  public void testServicoServiceFindById() throws ServicoNaoEncontradoException {
    Servico servico = criaServico(1L);

    Mockito.when(servicoRepository.findById(1L)).thenReturn(Optional.of(servico));

    Servico chamada = servicoService.findById(1L);

    Mockito.verify(servicoRepository, Mockito.times(1)).findById(1L);

    assertEquals(Servico.class, chamada.getClass());
    assertEquals(1L, chamada.getId());
    assertEquals("Zezinho das lavouras", chamada.getUsuario());
    assertEquals(LocalDateTime.of(2020, 1, 1, 0, 0), chamada.getInitialDate());
  }

  @Test
  @DisplayName("Deve retornar um erro especifico")
  public void testServicoServiceFindByIdErro() throws ServicoNaoEncontradoException {
    Mockito.when(servicoRepository.findById(1L)).thenReturn(Optional.empty());

    assertThrows(ServicoNaoEncontradoException.class, () -> servicoService.findById(1L));
  }

  @Test
  @DisplayName("verifica se um Serviço é salvo com sucesso")
  public void testServicoServiceInsertValido() throws NullPointerException, PropriedadeNaoEncontradaException,
      LaboratorioNaoEncontradoException, DatasException, UsuarioInvalidoException {
    Servico servico = criaServico(1L);

    Mockito.when(servicoRepository.save(servico)).thenReturn(servico);

    Servico chamada = servicoService.insert(servico);

    Mockito.verify(servicoRepository, Mockito.times(1)).save(servico);

    assertEquals(Servico.class, chamada.getClass());
    assertEquals(1L, chamada.getId());
    assertEquals("Zezinho das lavouras", chamada.getUsuario());
    assertEquals(LocalDateTime.of(2020, 1, 1, 0, 0), chamada.getInitialDate());
  }

  @Test
  @DisplayName("verifica se ao passar um serviço invalido é lançado um erro especifico.")
  public void testServicoServiceInsertInvalido() {
    Servico servico = new Servico();

    Mockito.when(servicoRepository.save(servico)).thenReturn(servico);

    Mockito.verify(servicoRepository, Mockito.times(0)).save(servico);

    assertThrows(DatasException.class, () -> servicoService.insert(servico));
  }

  @Test
  @DisplayName("verifica se um Serviço é atualizado com sucesso")
  public void testServicoServiceUpdate() throws NullPointerException, ServicoNaoEncontradoException,
      PropriedadeNaoEncontradaException, LaboratorioNaoEncontradoException, DatasException, UsuarioInvalidoException {
    Servico servico = criaServico(1L);

    Mockito.when(servicoRepository.findById(1L)).thenReturn(Optional.of(servico));
    servico.setDescription("modificado");

    Mockito.when(servicoRepository.save(servico)).thenReturn(servico);

    Servico chamada = servicoService.update(1L, servico);

    Mockito.verify(servicoRepository, Mockito.times(1)).findById(1L);
    Mockito.verify(servicoRepository, Mockito.times(1)).save(servico);
    assertEquals("modificado", chamada.getDescription());
  }

  @Test
  @DisplayName("verifica se é possivel deletar um usuario com sucesso")
  public void testServicoServiceDelete() throws ServicoNaoEncontradoException {
    Servico servico = criaServico(1L);

    Mockito.when(servicoRepository.findById(1L)).thenReturn(Optional.of(servico));

    servicoService.delete(1L);

    Mockito.verify(servicoRepository, Mockito.times(1)).findById(1L);
    Mockito.verify(servicoRepository, Mockito.times(1)).delete(servico);
  }

  private Servico criaServico(Long id) {
    Servico servico = new Servico();
    servico.setId(id);
    servico.setUsuario("Zezinho das lavouras");
    servico.setInitialDate(LocalDateTime.of(2020, 1, 1, 0, 0));
    servico.setFinalDate(LocalDateTime.of(2020, 1, 1, 0, 0));
    servico.setPropriedade(new Propriedade());
    servico.getPropriedade().setId(id);
    servico.setLaboratorio(new Laboratorio());
    servico.getLaboratorio().setId(id);
    servico.setDescription("teste de serviço");
    return servico;
  }
}
