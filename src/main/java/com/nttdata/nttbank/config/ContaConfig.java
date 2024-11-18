package com.nttdata.nttbank.config;

import com.nttdata.nttbank.application.gateways.RepositorioDeConta;
import com.nttdata.nttbank.application.usecases.conta.AlterarConta;
import com.nttdata.nttbank.application.usecases.conta.CriarConta;
import com.nttdata.nttbank.application.usecases.conta.ListarContas;
import com.nttdata.nttbank.application.usecases.conta.RemoverConta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContaConfig {

    @Bean
    CriarConta criarConta(RepositorioDeConta repositorioDeConta){
        return new CriarConta(repositorioDeConta);
    }

    @Bean
    ListarContas listarContas(RepositorioDeConta repositorioDeConta){
        return new ListarContas(repositorioDeConta);
    }

    @Bean
    AlterarConta alterarConta(RepositorioDeConta repositorioDeConta){
        return new AlterarConta(repositorioDeConta);
    }

    @Bean
    RemoverConta removerConta(RepositorioDeConta repositorioDeConta){
        return new RemoverConta(repositorioDeConta);
    }
}
