package com.nttdata.nttbank.infra.gateways;

import com.nttdata.nttbank.application.gateways.RepositorioDeConta;
import com.nttdata.nttbank.domain.entities.Conta;

import java.util.List;

public class RepositorioDeContaJpa implements RepositorioDeConta {
    @Override
    public Conta criarConta(Conta conta) {
        return null;
    }

    @Override
    public List<Conta> listarContas() {
        return null;
    }

    @Override
    public Conta alterarConta(Conta conta) {
        return null;
    }

    @Override
    public void removerConta(Long id) {

    }
}
