package com.nttdata.nttbank.config;

import com.nttdata.nttbank.application.gateways.RepositorioDeTransacao;
import com.nttdata.nttbank.application.usecases.transacao.*;
import com.nttdata.nttbank.infra.gateways.external.CurrencyConverterService;
import com.nttdata.nttbank.infra.gateways.jpa.RepositorioDeTransacaoJpa;
import com.nttdata.nttbank.infra.gateways.mapper.TransacaoEntityMapper;
import com.nttdata.nttbank.infra.persistence.repository.ContaRepository;
import com.nttdata.nttbank.infra.persistence.repository.TransacaoRepository;
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

    @Bean
    ResumoDespesas resumoDespesas(RepositorioDeTransacao repositorioDeTransacao){
        return new ResumoDespesas(repositorioDeTransacao);
    }

    @Bean
    ResumoPdf resumoPdf(RepositorioDeTransacao repositorioDeTransacao){
        return new ResumoPdf(repositorioDeTransacao);
    }

    @Bean
    GraficoDespesas graficoDespesas(RepositorioDeTransacao repositorioDeTransacao){
        return new GraficoDespesas(repositorioDeTransacao);
    }

    @Bean
    RepositorioDeTransacaoJpa criarRepositorioTransacao(TransacaoRepository repositorio, ContaRepository contaRepository, TransacaoEntityMapper mapper, CurrencyConverterService currencyConverterService){
        return new RepositorioDeTransacaoJpa(repositorio, contaRepository, mapper, currencyConverterService);
    }

    @Bean
    TransacaoEntityMapper retornaMapperTransacao(){
        return new TransacaoEntityMapper();
    }
}
