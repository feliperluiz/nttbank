package com.nttdata.nttbank.infra.controller;

import com.nttdata.nttbank.application.usecases.conta.CriarConta;
import com.nttdata.nttbank.infra.controller.dto.ContaDto;
import com.nttdata.nttbank.infra.controller.dto.UsuarioDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class ContaControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CriarConta criarConta;

    @Autowired
    private JacksonTester<ContaDto> contaDtoJson;

    @Test
    @DisplayName("Deve criar uma Conta e retornar HTTP Status 201")
    @WithMockUser
    public void criarConta() throws Exception {
    }
}