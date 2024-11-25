package com.nttdata.nttbank.domain.entities;

import com.nttdata.nttbank.infra.persistence.enums.TipoDespesa;
import com.nttdata.nttbank.infra.persistence.enums.TipoOperacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class RelatorioTransacao {
    private String usuarioNome;
    private Long contaId;
    private BigDecimal valorTransacao;
    private String descricaoTransacao;
    private TipoDespesa tipoDespesa;
    private TipoOperacao tipoOperacao;

}


