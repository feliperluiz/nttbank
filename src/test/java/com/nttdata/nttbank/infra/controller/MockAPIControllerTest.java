package com.nttdata.nttbank.infra.controller;

import com.nttdata.nttbank.infra.gateways.external.CurrencyConverterService;
import com.nttdata.nttbank.infra.gateways.external.MockAPIService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class MockAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MockAPIService mockAPIService;

    @MockBean
    private CurrencyConverterService currencyConverterService;

    @Test
    @DisplayName("Deve obter Transacoes Mockadas e retornar HTTP Status 200")
    @WithMockUser
    public void deveObterTransacoesMockadas() throws Exception {

    }
}