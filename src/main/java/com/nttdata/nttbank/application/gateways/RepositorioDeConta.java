package com.nttdata.nttbank.application.gateways;

import com.nttdata.nttbank.domain.entities.Conta;

import java.util.List;

public interface RepositorioDeConta {

    Conta criarConta(Conta conta);

    List<Conta> listarContas();

    Conta alterarConta(Conta conta);

    void removerConta(Long id);
}
