package com.nttdata.nttbank.infra.controller;

import com.nttdata.nttbank.application.usecases.AlterarTransacao;
import com.nttdata.nttbank.application.usecases.CriarTransacao;
import com.nttdata.nttbank.application.usecases.ListarTransacoes;
import com.nttdata.nttbank.application.usecases.RemoverTransacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private CriarTransacao criarTransacao;

    @Autowired
    private ListarTransacoes listarTransacoes;

    @Autowired
    private AlterarTransacao alterarTransacao;

    @Autowired
    private RemoverTransacao removerTransacao;

}
