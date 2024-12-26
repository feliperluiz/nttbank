package com.nttdata.nttbank.infra.controller.dto;
import jakarta.validation.constraints.NotBlank;

public record AutenticacaoDto (

    @NotBlank
    String login,

    @NotBlank
    String senha
){}