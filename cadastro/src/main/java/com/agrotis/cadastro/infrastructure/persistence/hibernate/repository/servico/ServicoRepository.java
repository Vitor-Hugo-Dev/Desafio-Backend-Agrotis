package com.agrotis.cadastro.infrastructure.persistence.hibernate.repository.servico;

import com.agrotis.cadastro.domain.servico.model.Servico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
