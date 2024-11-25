package com.nttdata.nttbank.infra.persistence.repository;

import com.nttdata.nttbank.domain.entities.RelatorioTransacao;
import com.nttdata.nttbank.infra.persistence.entities.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<TransacaoEntity, Long> {

    @Query(value = """
        SELECT u.nome AS usuarioNome,
               c.conta_id AS contaId, 
               t.valor AS valorTransacao, 
               t.descricao AS descricaoTransacao, 
               t.tipo_despesa AS tipoDespesa, 
               t.tipo_operacao AS tipoOperacao
        FROM usuarios u
        JOIN contas c ON c.usuario_id = u.id
        JOIN transacoes t ON t.conta_id = c.id
        WHERE u.cpf = cpf AND t.tipo_operacao = 'CREDITO'
    """, nativeQuery = true)
    List<RelatorioTransacao> findTransacoesPorCpf(@Param("cpf") String cpf);
}
