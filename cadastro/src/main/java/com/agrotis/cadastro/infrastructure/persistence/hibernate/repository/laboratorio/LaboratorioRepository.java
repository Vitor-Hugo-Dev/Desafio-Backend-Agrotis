package com.agrotis.cadastro.infrastructure.persistence.hibernate.repository.laboratorio;

import com.agrotis.cadastro.domain.laboratorio.model.Laboratorio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratorioRepository extends JpaRepository<Laboratorio, Long> {

}
