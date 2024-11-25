package com.nttdata.nttbank.infra.gateways.jpa;

import com.nttdata.nttbank.application.gateways.RepositorioDeTransacao;
import com.nttdata.nttbank.domain.entities.RelatorioTransacao;
import com.nttdata.nttbank.domain.entities.Transacao;
import com.nttdata.nttbank.infra.gateways.mapper.TransacaoEntityMapper;
import com.nttdata.nttbank.infra.persistence.entities.ContaEntity;
import com.nttdata.nttbank.infra.persistence.entities.TransacaoEntity;
import com.nttdata.nttbank.infra.persistence.enums.TipoDespesa;
import com.nttdata.nttbank.infra.persistence.enums.TipoOperacao;
import com.nttdata.nttbank.infra.persistence.repository.ContaRepository;
import com.nttdata.nttbank.infra.persistence.repository.TransacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RepositorioDeTransacaoJpa implements RepositorioDeTransacao {

    private final TransacaoRepository repositorio;

    private final ContaRepository contaRepository;

    private final TransacaoEntityMapper mapper;

    @Override
    public Transacao criarTransacao(Transacao transacao) {
        ContaEntity contaEntity = contaRepository.findById(transacao.getContaId())
                .orElseThrow(() -> new EntityNotFoundException("Conta não encontrada"));

        TransacaoEntity entity = mapper.toEntity(transacao);
        entity.setConta(contaEntity);

        if (transacao.getContaIdTransferencia() != null) {
            Optional<ContaEntity> contaTransf = contaRepository.findById(transacao.getContaIdTransferencia());
            entity.setContaTransferencia(contaTransf.get());
        }

        entity = repositorio.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Transacao> listarTransacoes() {
        return repositorio.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Transacao alterarTransacao(Transacao transacao) {
        TransacaoEntity entity = repositorio.findById(transacao.getId())
                .orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));

        TransacaoEntity entityUpdated = mapper.toEntity(transacao);
        entityUpdated.setId(entity.getId());
        entityUpdated.setContaTransferencia(entity.getContaTransferencia());
        entityUpdated.setConta(entity.getConta());
        entityUpdated = repositorio.save(entityUpdated);
        return mapper.toDomain(entityUpdated);
    }

    @Override
    public void removerTransacao(Long id) {
        TransacaoEntity entity = repositorio.findById(id).orElseThrow(() -> new EntityNotFoundException("Transação não encontrada."));
        repositorio.delete(entity);
    }

    @Override
    public List<RelatorioTransacao> resumoDespesas(String cpf) {

        return mapToRelatorioTransacao(repositorio.findTransacoesPorCpf(cpf));
    }

    @Override
    public void graficoDespesas(String cpf) {
        List<RelatorioTransacao> relatorioTransacaoList = this.resumoDespesas(cpf);

        Map<String, Double> somaPorTipoDespesa = relatorioTransacaoList.stream()
                .collect(Collectors.groupingBy(
                        t -> t.getTipoDespesa().getTipo(),
                        Collectors.summingDouble(t -> Double.parseDouble(t.getValorTransacao().toString()))
                ));

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        somaPorTipoDespesa.forEach((tipoDespesa, valorTotal) ->
                dataset.addValue(valorTotal, "Valor Total", tipoDespesa)
        );

        JFreeChart barChart = ChartFactory.createBarChart(
                "Despesas por Tipo",
                "Tipo de Despesa",
                "Valor Total",
                dataset
        );

        File barChartFile = new File("grafico_despesas.png");
        try {
            ChartUtils.saveChartAsPNG(barChartFile, barChart, 800, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Gráfico gerado: " + barChartFile.getAbsolutePath());
    }

    List<RelatorioTransacao> mapToRelatorioTransacao(List<Object[]> results) {
        return results.stream()
                .map(r -> new RelatorioTransacao(
                        (String) r[0],
                        (Long) r[1],
                        (BigDecimal) r[2],
                        (String) r[3],
                        (TipoDespesa) r[4],
                        (TipoOperacao) r[5]
                ))
                .collect(Collectors.toList());
    }


}