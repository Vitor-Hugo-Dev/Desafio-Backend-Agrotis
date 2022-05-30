package com.agrotis.cadastro.infrastructure.persistence.hibernate.repository.propriedade;

import com.agrotis.cadastro.domain.propriedade.model.Propriedade;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PropriedadeRepository extends JpaRepository<Propriedade, Long> {

}
