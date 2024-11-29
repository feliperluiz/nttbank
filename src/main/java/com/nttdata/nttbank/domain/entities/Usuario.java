package com.nttdata.nttbank.domain.entities;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Usuario {

    private Long id;
    private String cpf;
    private String nome;
    private String login;
    private String senha;
    private LocalDate nascimento;
    private String email;

}
