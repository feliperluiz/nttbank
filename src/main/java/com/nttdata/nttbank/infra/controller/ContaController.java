package com.nttdata.nttbank.infra.controller;

import com.nttdata.nttbank.application.usecases.AlterarConta;
import com.nttdata.nttbank.application.usecases.CriarConta;
import com.nttdata.nttbank.application.usecases.ListarContas;
import com.nttdata.nttbank.application.usecases.RemoverConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private CriarConta criarConta;

    @Autowired
    private ListarContas listarContas;

    @Autowired
    private RemoverConta removerConta;

    @Autowired
    private AlterarConta alterarConta;

}
