package com.nttdata.nttbank.infra.controller;

import com.nttdata.nttbank.application.usecases.transacao.CriarTransacao;
import com.nttdata.nttbank.domain.entities.Transacao;
import com.nttdata.nttbank.infra.controller.dto.TransacaoDto;
import com.nttdata.nttbank.infra.persistence.enums.TipoDespesa;
import com.nttdata.nttbank.infra.persistence.enums.TipoOperacao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class TransacaoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CriarTransacao criarTransacao;

    @Autowired
    private JacksonTester<TransacaoDto> transacaoDtoJson;

    @Test
    @DisplayName("Deve criar uma Transacao e retornar HTTP Status 201")
    @WithMockUser
    public void criarTransacao() throws Exception {

        var transacaoDto = new TransacaoDto(null, 1L, new BigDecimal("200.00"), "Camiseta", TipoOperacao.DEBITO, null, TipoDespesa.VESTUARIO);

        Transacao transacao = new Transacao(null, transacaoDto.contaId(), transacaoDto.valor(), transacaoDto.descricao(), transacaoDto.tipoOperacao(), transacaoDto.contaIdTransferencia(), transacaoDto.tipoDespesa());
        Mockito.when(criarTransacao.criarTransacao(any())).thenReturn(transacao);

        var response = mvc.perform(
                post("/transacoes/criar")
                        .content(transacaoDtoJson.write(transacaoDto).getJson())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andReturn().getResponse();

        var responseExpected = transacaoDtoJson.write(transacaoDto).getJson();
        assertThat(response.getStatus()).isEqualTo(201);
        assertThat(response.getContentAsString()).isEqualTo(responseExpected);
    }
}