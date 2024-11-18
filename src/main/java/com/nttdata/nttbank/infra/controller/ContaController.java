package com.nttdata.nttbank.infra.controller;

import com.nttdata.nttbank.application.usecases.AlterarConta;
import com.nttdata.nttbank.application.usecases.CriarConta;
import com.nttdata.nttbank.application.usecases.ListarContas;
import com.nttdata.nttbank.application.usecases.RemoverConta;
import com.nttdata.nttbank.domain.entities.Conta;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @PostMapping
    public ContaDto criarConta(@RequestBody ContaDto dto) {
        Conta salvo = criarConta.criarConta(new Conta(null, dto.usuarioId(), dto.agencia(), dto.conta(), dto.dac(), dto.saldo(), dto.tipoConta(), dto.bloqueada()));
        return new ContaDto(salvo.getId(), salvo.getUsuarioId(), salvo.getAgencia(), salvo.getConta(), salvo.getDac(), salvo.getSaldo(), salvo.getTipoConta(), salvo.getBloqueada());
    }

    @GetMapping
    public List<ContaDto> listarContas() {
        return listarContas.listarContas().stream()
                .map(u -> new ContaDto(u.getId(), u.getUsuarioId(), u.getAgencia(), u.getConta(), u.getDac(), u.getSaldo(), u.getTipoConta(), u.getBloqueada()))
                .collect(Collectors.toList());
    }

    @PutMapping
    public ContaDto alterarConta(@RequestBody ContaDto dto) {
        Conta salvo = alterarConta.alterarConta(new Conta(dto.id(), dto.usuarioId(), dto.agencia(), dto.conta(), dto.dac(), dto.saldo(), dto.tipoConta(), dto.bloqueada()));
        return new ContaDto(salvo.getId(), salvo.getUsuarioId(), salvo.getAgencia(), salvo.getConta(), salvo.getDac(), salvo.getSaldo(), salvo.getTipoConta(), salvo.getBloqueada());
    }

    @DeleteMapping
    public ResponseEntity<Void> removerConta(@PathVariable Long id) {
        removerConta.removerConta(id);
        return ResponseEntity.noContent().build();
    }

}
