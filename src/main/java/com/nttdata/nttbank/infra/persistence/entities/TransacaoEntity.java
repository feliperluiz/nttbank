package com.nttdata.nttbank.infra.persistence.entities;

import com.nttdata.nttbank.infra.persistence.enums.TipoDespesa;
import com.nttdata.nttbank.infra.persistence.enums.TipoOperacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transacoes")
public class TransacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "contaId", referencedColumnName = "id", nullable = false)
    private ContaEntity conta;

    private BigDecimal valor;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private TipoOperacao tipoOperacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contaIdTransferencia", referencedColumnName = "id")
    private ContaEntity contaTransferencia;

    @Enumerated(EnumType.STRING)
    private TipoDespesa tipoDespesa;

}
