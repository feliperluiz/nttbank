package com.nttdata.nttbank.domain.entities;

import com.nttdata.nttbank.infra.persistence.enums.TipoDespesa;
import com.nttdata.nttbank.infra.persistence.enums.TipoOperacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Transacao {

    private Long contaId;

    private BigDecimal valor;

    private String descricao;

    private TipoOperacao tipoOperacao;

    private TipoDespesa tipoDespesa;
}
