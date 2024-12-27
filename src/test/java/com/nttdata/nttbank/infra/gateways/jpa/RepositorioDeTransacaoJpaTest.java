package com.nttdata.nttbank.infra.gateways.jpa;

import com.nttdata.nttbank.domain.entities.Transacao;
import com.nttdata.nttbank.infra.gateways.external.CurrencyConverterService;
import com.nttdata.nttbank.infra.gateways.mapper.TransacaoEntityMapper;
import com.nttdata.nttbank.infra.persistence.entities.ContaEntity;
import com.nttdata.nttbank.infra.persistence.entities.TransacaoEntity;
import com.nttdata.nttbank.infra.persistence.entities.UsuarioEntity;
import com.nttdata.nttbank.infra.persistence.enums.TipoConta;
import com.nttdata.nttbank.infra.persistence.enums.TipoDespesa;
import com.nttdata.nttbank.infra.persistence.enums.TipoOperacao;
import com.nttdata.nttbank.infra.persistence.repository.ContaRepository;
import com.nttdata.nttbank.infra.persistence.repository.TransacaoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class RepositorioDeTransacaoJpaTest {

    @InjectMocks
    private RepositorioDeTransacaoJpa repositorioDeTransacaoJpa;

    @Mock
    private TransacaoRepository repositorio;

    @Mock
    private ContaRepository contaRepository;

    @Mock
    private TransacaoEntityMapper mapper;

    @Mock
    private CurrencyConverterService currencyConverterService;


    @Test
    public void criarTransacaoOk() {

        Optional<ContaEntity> contaEntity = this.getContaEntity();
        TransacaoEntity transacaoEntity = this.getTransacaoEntity();
        TransacaoEntity transacaoEntityWithId = this.getTransacaoEntity();
        transacaoEntityWithId.setId(1L);

        Transacao transacaoWithId = this.getTransacao();
        transacaoWithId.setId(transacaoEntityWithId.getId());

        given(contaRepository.findById(any())).willReturn(contaEntity);
        given(mapper.toEntity(any())).willReturn(transacaoEntity);
        given(repositorio.save(any())).willReturn(transacaoEntityWithId);
        given(mapper.toDomain(transacaoEntityWithId)).willReturn(transacaoWithId);
        Transacao transacaoReturned = repositorioDeTransacaoJpa.criarTransacao(this.getTransacao());
        Assertions.assertNotNull(transacaoReturned.getId());

    }



    @Test
    public void alterarTransacaoOk() {

    }

    public Transacao getTransacao() {
        return new Transacao(null, 1L, new BigDecimal("200.00"), "Camiseta", TipoOperacao.DEBITO, null, TipoDespesa.VESTUARIO);
    }

    private TransacaoEntity getTransacaoEntity() {
        return new TransacaoEntity(null, this.getContaEntity().get(), new BigDecimal("200.00"), "Camiseta", TipoOperacao.DEBITO, null, TipoDespesa.VESTUARIO);
    }

    public Optional<ContaEntity> getContaEntity() {
        return Optional.of(new ContaEntity(1L, this.getUsuarioEntity(), "1234", "123456", "1", new BigDecimal("500.00"), TipoConta.CORRENTE, false));
    }

    private UsuarioEntity getUsuarioEntity() {
        return new UsuarioEntity(1L, "00863434545", "Felisberto Antunes", "felis", "123456", LocalDate.of(1940, 06, 10), "felis@gmail.com", List.of("USER", "ADMIN") );
    }

}