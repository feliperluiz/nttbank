package com.nttdata.nttbank.config;

import com.nttdata.nttbank.application.gateways.RepositorioDeTransacao;
import com.nttdata.nttbank.application.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransacaoConfig {

    @Bean
    CriarTransacao criarTransacao(RepositorioDeTransacao repositorioDeTransacao){
        return new CriarTransacao(repositorioDeTransacao);
    }

    @Bean
    ListarTransacoes listarTransacoes(RepositorioDeTransacao repositorioDeTransacao){
        return new ListarTransacoes(repositorioDeTransacao);
    }

    @Bean
    AlterarTransacao alterarTransacao(RepositorioDeTransacao repositorioDeTransacao){
        return new AlterarTransacao(repositorioDeTransacao);
    }

    @Bean
    RemoverTransacao removerTransacao(RepositorioDeTransacao repositorioDeTransacao){
        return new RemoverTransacao(repositorioDeTransacao);
    }
}
