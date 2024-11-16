package com.nttdata.nttbank.infra.controller;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record UsuarioDto(String cpf,
         String nome, String login,
                         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                         LocalDate nascimento,
         String email){}
