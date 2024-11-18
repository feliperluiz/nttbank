package com.nttdata.nttbank.infra.persistence.repository;

import com.nttdata.nttbank.infra.persistence.entities.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<TransacaoEntity, Long> {
}
