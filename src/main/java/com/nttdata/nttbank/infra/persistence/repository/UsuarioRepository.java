package com.nttdata.nttbank.infra.persistence.repository;

import com.nttdata.nttbank.infra.persistence.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    UsuarioEntity findByCpf(String cpf);



}
