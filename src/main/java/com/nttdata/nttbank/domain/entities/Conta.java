package com.nttdata.nttbank.domain.entities;

import com.nttdata.nttbank.infra.persistence.enums.TipoConta;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Conta {

    private Long id;
    private Long usuarioId;
    private String agencia;
    private String conta;
    private String dac;
    private BigDecimal saldo;
    private TipoConta tipoConta;
    private Boolean bloqueada;
}
