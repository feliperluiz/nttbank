package com.nttdata.nttbank.config;

import com.nttdata.nttbank.application.gateways.RepositorioDeTransacao;
import com.nttdata.nttbank.application.usecases.transacao.AlterarTransacao;
import com.nttdata.nttbank.application.usecases.transacao.CriarTransacao;
import com.nttdata.nttbank.application.usecases.transacao.ListarTransacoes;
import com.nttdata.nttbank.application.usecases.transacao.RemoverTransacao;
import com.nttdata.nttbank.infra.gateways.jpa.RepositorioDeTransacaoJpa;
import com.nttdata.nttbank.infra.gateways.mapper.TransacaoEntityMapper;
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
    RepositorioDeTransacaoJpa criarRepositorioTransacao(TransacaoRepository repositorio, TransacaoEntityMapper mapper){
        return new RepositorioDeTransacaoJpa(repositorio, mapper);
    }

    @Bean
    TransacaoEntityMapper retornaMapperTransacao(){
        return new TransacaoEntityMapper();
    }
}
