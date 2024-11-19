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

    @ManyToOne(optional = false)
    @JoinColumn(name = "conta_id", referencedColumnName = "id", nullable = false)
    private ContaEntity conta;

    private BigDecimal valor;

    private String descricao;

    @Enumerated
    private TipoOperacao tipoOperacao;

    @ManyToOne
    @JoinColumn(name = "conta_id_transferencia", referencedColumnName = "id")
    private ContaEntity contaTransferencia;

    @Enumerated
    private TipoDespesa tipoDespesa;

}
