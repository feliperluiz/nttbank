package com.nttdata.nttbank.infra.persistence.repository;

import com.nttdata.nttbank.infra.persistence.entities.ContaEntity;
import com.nttdata.nttbank.infra.persistence.entities.TransacaoEntity;
import com.nttdata.nttbank.infra.persistence.entities.UsuarioEntity;
import com.nttdata.nttbank.infra.persistence.enums.TipoConta;
import com.nttdata.nttbank.infra.persistence.enums.TipoDespesa;
import com.nttdata.nttbank.infra.persistence.enums.TipoOperacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@DataJpaTest
public class TransacaoRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private TransacaoRepository repository;

    @Test
    @DisplayName("Deve retornar transações por cpf para os serviços de resumo de transações e gráfico")
    void findTransacoesParaResumoEGraficoPorCpf() {

        List<String> roles = new ArrayList<>();
        roles.add("USER");
        roles.add("ADMIN");

        String cpf = UUID.randomUUID().toString();

        UsuarioEntity usuarioEntity = new UsuarioEntity(null, cpf, "João", "joao", "123456", LocalDate.of(1950, 6, 10), "joao@gmail.com", roles);
        ContaEntity contaEntity1 = new ContaEntity(null, usuarioEntity, "1234", "123456", "1", new BigDecimal("300.00"), TipoConta.INVESTIMENTO, false);
        TransacaoEntity transacaoEntity1 = new TransacaoEntity(null, contaEntity1, new BigDecimal("50.00"), "McDonald's", TipoOperacao.DEBITO, null, TipoDespesa.ALIMENTACAO);
        TransacaoEntity transacaoEntity2 = new TransacaoEntity(null, contaEntity1, new BigDecimal("10.00"), "Dorflex", TipoOperacao.DEBITO, null, TipoDespesa.SAUDE);
        TransacaoEntity transacaoEntity3 = new TransacaoEntity(null, contaEntity1, new BigDecimal("150.00"), "Reembolso Fralda", TipoOperacao.CREDITO, null, TipoDespesa.SAUDE);

        testEntityManager.persist(usuarioEntity);
        testEntityManager.persist(contaEntity1);
        testEntityManager.persist(transacaoEntity1);
        testEntityManager.persist(transacaoEntity2);
        testEntityManager.persist(transacaoEntity3);

        List<Object[]> transacaoList =  repository.findTransacoesPorCpf(cpf);
        Assertions.assertEquals(2, transacaoList.size());

    }

}