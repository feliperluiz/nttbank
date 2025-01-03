package com.nttdata.nttbank.infra.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record UsuarioDto(
        
        @NotBlank
        String cpf,

        @NotBlank
        String nome,

        @NotBlank
        String login,

        @NotBlank
        String senha,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        @NotNull
        LocalDate nascimento,

        @NotBlank
        @Email
        String email,

        @NotNull
        @NotEmpty
        List<String> roles

){}
