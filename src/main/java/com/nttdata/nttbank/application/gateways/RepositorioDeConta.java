package com.nttdata.nttbank.application.gateways;

import com.nttdata.nttbank.domain.entities.Conta;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RepositorioDeConta {

    Conta criarConta(Conta conta);

    List<Conta> listarContas();

    Conta alterarConta(Conta conta);

    void removerConta(Long id);
}
