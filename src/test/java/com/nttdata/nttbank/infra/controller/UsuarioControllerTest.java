package com.nttdata.nttbank.infra.controller;

import com.nttdata.nttbank.application.usecases.usuario.CriarUsuario;
import com.nttdata.nttbank.infra.controller.dto.TransacaoDto;
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
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CriarUsuario criarUsuario;

    @Autowired
    private JacksonTester<UsuarioDto> usuarioDtoJson;

    @Test
    @DisplayName("Deve criar um Usuario e retornar HTTP Status 201")
    @WithMockUser
    public void criarUsuario() throws Exception {
    }
}