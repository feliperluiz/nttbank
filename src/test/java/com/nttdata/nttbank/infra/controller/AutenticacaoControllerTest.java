package com.nttdata.nttbank.infra.controller;

import com.nttdata.nttbank.config.TokenService;
import com.nttdata.nttbank.infra.controller.dto.AutenticacaoDto;
import com.nttdata.nttbank.infra.persistence.entities.UsuarioEntity;
import com.nttdata.nttbank.infra.persistence.security.DadosTokenJWT;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class AutenticacaoControllerTest {

    @MockBean
    private TokenService tokenService;  // Usar @MockBean para o TokenService

    @MockBean
    private AuthenticationManager authenticationManager;

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Deve efetuar o login, retornando o JWT e Status 200")
    public void deveEfetuarLogin() throws Exception {
        var autenticacaoDto = new AutenticacaoDto("fepluiz", "nttdata");

        when(tokenService.gerarToken(any(UsuarioEntity.class))).thenReturn("tokenJWT");

        when(authenticationManager.authenticate(any())).thenReturn(getAuth(autenticacaoDto));

        var response = mvc.perform(
                post("/login")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content("{\"login\":\"fepluiz\",\"senha\":\"nttdata\"}")
        ).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.getContentAsString()).isEqualTo("{\"tokenJWT\":\"tokenJWT\"}");
    }

    public Authentication getAuth(AutenticacaoDto autenticacaoDto) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setLogin(autenticacaoDto.login());
        return new UsernamePasswordAuthenticationToken(usuarioEntity, autenticacaoDto.senha(), usuarioEntity.getAuthorities());
    }
}
