package com.nttdata.nttbank.infra.controller;

import com.nttdata.nttbank.application.usecases.conta.AlterarConta;
import com.nttdata.nttbank.application.usecases.conta.CriarConta;
import com.nttdata.nttbank.application.usecases.conta.ListarContas;
import com.nttdata.nttbank.application.usecases.conta.RemoverConta;
import com.nttdata.nttbank.domain.entities.Conta;
import com.nttdata.nttbank.infra.controller.dto.ContaDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private CriarConta criarConta;

    @Autowired
    private ListarContas listarContas;

    @Autowired
    private RemoverConta removerConta;

    @Autowired
    private AlterarConta alterarConta;

    @PostMapping("/criar")
    public ContaDto criarConta(@RequestBody @Valid ContaDto dto) {
        Conta salvo = criarConta.criarConta(new Conta(null, dto.usuarioId(), dto.agencia(), dto.conta(), dto.dac(), dto.saldo(), dto.tipoConta(), dto.bloqueada()));
        return new ContaDto(salvo.getId(), salvo.getUsuarioId(), salvo.getAgencia(), salvo.getConta(), salvo.getDac(), salvo.getSaldo(), salvo.getTipoConta(), salvo.getBloqueada());
    }

    @GetMapping("/listar")
    public List<ContaDto> listarContas() {
        return listarContas.listarContas().stream()
                .map(u -> new ContaDto(u.getId(), u.getUsuarioId(), u.getAgencia(), u.getConta(), u.getDac(), u.getSaldo(), u.getTipoConta(), u.getBloqueada()))
                .collect(Collectors.toList());
    }

    @PutMapping("/alterar")
    public ContaDto alterarConta(@RequestBody @Valid ContaDto dto) {
        Conta salvo = alterarConta.alterarConta(new Conta(dto.id(), dto.usuarioId(), dto.agencia(), dto.conta(), dto.dac(), dto.saldo(), dto.tipoConta(), dto.bloqueada()));
        return new ContaDto(salvo.getId(), salvo.getUsuarioId(), salvo.getAgencia(), salvo.getConta(), salvo.getDac(), salvo.getSaldo(), salvo.getTipoConta(), salvo.getBloqueada());
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Void> removerConta(@PathVariable("id") Long id) {
        removerConta.removerConta(id);
        return ResponseEntity.noContent().build();
    }

}
