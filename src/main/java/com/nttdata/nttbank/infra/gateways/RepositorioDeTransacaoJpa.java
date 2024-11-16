package com.nttdata.nttbank.infra.gateways;

import com.nttdata.nttbank.application.gateways.RepositorioDeTransacao;
import com.nttdata.nttbank.domain.entities.Transacao;

import java.util.List;

public class RepositorioDeTransacaoJpa implements RepositorioDeTransacao {
    @Override
    public Transacao criarTransacao(Transacao transacao) {
        return null;
    }

    @Override
    public List<Transacao> listarTransacoes() {
        return null;
    }

    @Override
    public Transacao alterarTransacao(Transacao transacao) {
        return null;
    }

    @Override
    public void removerTransacao(Long id) {

    }
}
