package com.nttdata.nttbank.application.gateways;

import com.nttdata.nttbank.domain.entities.RelatorioTransacao;
import com.nttdata.nttbank.domain.entities.Transacao;

import java.util.List;

public interface RepositorioDeTransacao {

    Transacao criarTransacao(Transacao transacao);

    List<Transacao> listarTransacoes();

    Transacao alterarTransacao(Transacao transacao);

    void removerTransacao(Long id);

    List<RelatorioTransacao> resumoDespesas(String cpf);

    void graficoDespesas(String cpf);

    byte[] resumoPdf();
}
