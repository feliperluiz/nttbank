package com.nttdata.nttbank.infra.controller;

import com.nttdata.nttbank.application.usecases.transacao.*;
import com.nttdata.nttbank.domain.entities.RelatorioTransacao;
import com.nttdata.nttbank.domain.entities.Transacao;
import com.nttdata.nttbank.infra.controller.dto.TransacaoDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@SecurityRequirement(name = "bearer-key")
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

    @Autowired
    private ResumoDespesas resumoDespesas;

    @PostMapping("/criar")
    public ResponseEntity<TransacaoDto> criarTransacao(@RequestBody @Valid TransacaoDto dto) {
        Transacao salvo = criarTransacao.criarTransacao(new Transacao(null, dto.contaId(), dto.valor(), dto.descricao(), dto.tipoOperacao(), dto.contaIdTransferencia(), dto.tipoDespesa()));
        return ResponseEntity.status(201)
                .body(new TransacaoDto(salvo.getId(), salvo.getContaId(), salvo.getValor(), salvo.getDescricao(), salvo.getTipoOperacao(), salvo.getContaIdTransferencia(), salvo.getTipoDespesa()));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TransacaoDto>> listarTransacoes() {
        return ResponseEntity.ok(listarTransacoes.listarTransacoes().stream()
                .map(u -> new TransacaoDto(u.getId(), u.getContaId(), u.getValor(), u.getDescricao(), u.getTipoOperacao(), u.getContaIdTransferencia(), u.getTipoDespesa()))
                .collect(Collectors.toList()));
    }

    @PutMapping("/alterar")
    public ResponseEntity<TransacaoDto> alterarTransacao(@RequestBody @Valid TransacaoDto dto) {
        Transacao salvo = alterarTransacao.alterarTransacao(new Transacao(dto.id(), dto.contaId(), dto.valor(), dto.descricao(), dto.tipoOperacao(), dto.contaIdTransferencia(), dto.tipoDespesa()));
        return ResponseEntity.ok(new TransacaoDto(salvo.getId(), salvo.getContaId(), salvo.getValor(), salvo.getDescricao(), salvo.getTipoOperacao(), salvo.getContaIdTransferencia(), salvo.getTipoDespesa()));
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Void> removerTransacao(@PathVariable("id") Long id) {
        removerTransacao.removerTransacao(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/relatorio/{cpf}")
    public ResponseEntity<List<RelatorioTransacao>> resumoDespesas(@PathVariable("cpf") String cpf) {
        return ResponseEntity.ok(resumoDespesas.resumoDespesas(cpf));
    }

    @GetMapping("/resumo")
    public ResponseEntity<byte[]> resumoPdf() {
        byte[] pdf = resumoDespesas.resumoPdf();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=resumo-transacoes.pdf");

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(pdf);
    }

    @GetMapping(value = "/grafico/{cpf}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] graficoDespesas(@PathVariable("cpf") String cpf) throws IOException {
        resumoDespesas.graficoDespesas(cpf);
        File barChartFile = new File("grafico_despesas.png");
        return Files.readAllBytes(barChartFile.toPath());
    }

}
