package com.nttdata.nttbank.infra.persistence.repository;

import com.nttdata.nttbank.infra.persistence.entities.ContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<ContaEntity, Long> {
}
