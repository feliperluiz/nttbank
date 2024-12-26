package com.nttdata.nttbank.infra.controller;

import com.nttdata.nttbank.application.usecases.conta.AlterarConta;
import com.nttdata.nttbank.application.usecases.conta.CriarConta;
import com.nttdata.nttbank.application.usecases.conta.ListarContas;
import com.nttdata.nttbank.application.usecases.conta.RemoverConta;
import com.nttdata.nttbank.domain.entities.Conta;
import com.nttdata.nttbank.infra.controller.dto.ContaDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contas")
@SecurityRequirement(name = "bearer-key")
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
    public ResponseEntity<ContaDto> criarConta(@RequestBody @Valid ContaDto dto) {
        Conta salvo = criarConta.criarConta(new Conta(null, dto.usuarioId(), dto.agencia(), dto.conta(), dto.dac(), dto.saldo(), dto.tipoConta(), dto.bloqueada()));
        return ResponseEntity.status(201)
                .body(new ContaDto(salvo.getId(), salvo.getUsuarioId(), salvo.getAgencia(), salvo.getConta(), salvo.getDac(), salvo.getSaldo(), salvo.getTipoConta(), salvo.getBloqueada()));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ContaDto>> listarContas() {
        return ResponseEntity.ok(listarContas.listarContas().stream()
                .map(u -> new ContaDto(u.getId(), u.getUsuarioId(), u.getAgencia(), u.getConta(), u.getDac(), u.getSaldo(), u.getTipoConta(), u.getBloqueada()))
                .collect(Collectors.toList()));
    }

    @PutMapping("/alterar")
    public ResponseEntity<ContaDto> alterarConta(@RequestBody @Valid ContaDto dto) {
        Conta salvo = alterarConta.alterarConta(new Conta(dto.id(), dto.usuarioId(), dto.agencia(), dto.conta(), dto.dac(), dto.saldo(), dto.tipoConta(), dto.bloqueada()));
        return ResponseEntity.ok(new ContaDto(salvo.getId(), salvo.getUsuarioId(), salvo.getAgencia(), salvo.getConta(), salvo.getDac(), salvo.getSaldo(), salvo.getTipoConta(), salvo.getBloqueada()));
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Void> removerConta(@PathVariable("id") Long id) {
        removerConta.removerConta(id);
        return ResponseEntity.noContent().build();
    }

}
