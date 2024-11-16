package com.nttdata.nttbank.infra.controller;

import com.nttdata.nttbank.application.usecases.AlterarTransacao;
import com.nttdata.nttbank.application.usecases.CriarTransacao;
import com.nttdata.nttbank.application.usecases.ListarTransacoes;
import com.nttdata.nttbank.application.usecases.RemoverTransacao;
import com.nttdata.nttbank.domain.entities.Transacao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

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

    @PostMapping
    public TransacaoDto criarTransacao(@RequestBody TransacaoDto dto) {
        Transacao salvo = criarTransacao.criarTransacao(new Transacao(dto.contaId(), dto.valor(), dto.descricao(), dto.tipoOperacao(), dto.contaIdTransferencia(), dto.tipoDespesa()));
        return new TransacaoDto(salvo.getContaId(), salvo.getValor(), salvo.getDescricao(), salvo.getTipoOperacao(), salvo.getContaIdTransferencia(), salvo.getTipoDespesa());
    }

    @GetMapping
    public List<TransacaoDto> listarTransacoes() {
        return listarTransacoes.listarTransacoes().stream()
                .map(u -> new TransacaoDto(u.getContaId(), u.getValor(), u.getDescricao(), u.getTipoOperacao(), u.getContaIdTransferencia(), u.getTipoDespesa()))
                .collect(Collectors.toList());
    }

    @PutMapping
    public TransacaoDto alterarTransacao(@RequestBody TransacaoDto dto) {
        Transacao salvo = alterarTransacao.alterarTransacao(new Transacao(dto.contaId(), dto.valor(), dto.descricao(), dto.tipoOperacao(), dto.contaIdTransferencia(), dto.tipoDespesa()));
        return new TransacaoDto(salvo.getContaId(), salvo.getValor(), salvo.getDescricao(), salvo.getTipoOperacao(), salvo.getContaIdTransferencia(), salvo.getTipoDespesa());
    }

    @DeleteMapping
    public ResponseEntity<Void> removerTransacao(@PathVariable Long id) {
        removerTransacao.removerTransacao(id);
        return ResponseEntity.noContent().build();
    }

}
