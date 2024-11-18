package com.nttdata.nttbank.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Usuario {

    private Long id;
    private String cpf;
    private String nome;
    private String login;
    private LocalDate nascimento;
    private String email;

}
