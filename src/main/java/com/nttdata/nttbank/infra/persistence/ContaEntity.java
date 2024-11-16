package com.nttdata.nttbank.infra.persistence;

import com.nttdata.nttbank.infra.persistence.enums.TipoConta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "contas")
public class ContaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarioId", referencedColumnName = "id")
    private UsuarioEntity usuario;
    private String agencia;
    private String conta;
    private String dac;
    private String saldo;
    @Enumerated
    private TipoConta tipoConta;
    private Boolean bloqueada;

}