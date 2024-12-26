package com.nttdata.nttbank.infra.persistence.repository;

import com.nttdata.nttbank.domain.entities.RelatorioTransacao;
import com.nttdata.nttbank.infra.persistence.entities.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public interface TransacaoRepository extends JpaRepository<TransacaoEntity, Long> {

    @Query(value = """
        SELECT
               u.nome AS usuarioNome,
               c.id AS contaId,
               t.valor AS valorTransacao,
               t.descricao AS descricaoTransacao,
               t.tipoDespesa AS tipoDespesa,
               t.tipoOperacao AS tipoOperacao
        FROM UsuarioEntity u
        JOIN ContaEntity c ON c.usuario = u
        JOIN TransacaoEntity t ON t.conta = c
        WHERE u.cpf = :cpf AND t.tipoOperacao = 'DEBITO'
    """)
    List<Object[]> findTransacoesPorCpf(@Param("cpf") String cpf);


}
