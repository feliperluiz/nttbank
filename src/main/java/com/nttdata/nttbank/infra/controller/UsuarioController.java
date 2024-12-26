package com.nttdata.nttbank.infra.controller;

import com.nttdata.nttbank.application.usecases.usuario.*;
import com.nttdata.nttbank.domain.entities.Usuario;
import com.nttdata.nttbank.infra.controller.dto.UsuarioDto;
import com.nttdata.nttbank.infra.controller.dto.UsuarioRespDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@SecurityRequirement(name = "bearer-key")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private CriarUsuario criarUsuario;

    @Autowired
    private ListarUsuarios listarUsuarios;

    @Autowired
    private AlterarUsuario alterarUsuario;

    @Autowired
    private RemoverUsuario removerUsuario;

    @Autowired
    private ImportarUsuariosExcel importarUsuariosExcel;

    @PostMapping("/criar")
    public ResponseEntity<UsuarioRespDto> criarUsuario(@RequestBody @Valid UsuarioDto dto) {
        Usuario salvo = criarUsuario.criarUsuario(new Usuario(null, dto.cpf(), dto.nome(), dto.login(), dto.senha(), dto.nascimento(), dto.email(), dto.roles()));
        return ResponseEntity.status(HttpStatusCode.valueOf(201))
                .body(new UsuarioRespDto(salvo.getCpf(), salvo.getNome(), salvo.getLogin(), salvo.getNascimento(), salvo.getEmail(), salvo.getRoles()));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioRespDto>> listarUsuarios() {
        return ResponseEntity.ok(listarUsuarios.listarUsuarios().stream()
                .map(u -> new UsuarioRespDto(u.getCpf(), u.getNome(), u.getLogin(), u.getNascimento(), u.getEmail(), u.getRoles()))
                .collect(Collectors.toList()));
    }

    @PutMapping("/alterar")
    public ResponseEntity<UsuarioRespDto> alterarUsuario(@RequestBody @Valid UsuarioDto dto) {
        Usuario salvo = alterarUsuario.alterarUsuario(new Usuario(null, dto.cpf(), dto.nome(), dto.login(), dto.senha(), dto.nascimento(), dto.email(), dto.roles()));
        return ResponseEntity.ok(new UsuarioRespDto(salvo.getCpf(), salvo.getNome(), salvo.getLogin(), salvo.getNascimento(), salvo.getEmail(), salvo.getRoles()));
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Void> removerUsuario(@PathVariable("id") Long id) {
        removerUsuario.removerUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/upload")
    public ResponseEntity<List<UsuarioRespDto>> uploadExcel(@RequestParam("file") MultipartFile file) {
        try {
            List<Usuario> usuarios = importarUsuariosExcel.importarUsuariosExcel(file);
            return ResponseEntity.ok(usuarios.stream()
                    .map(u -> new UsuarioRespDto(u.getCpf(), u.getNome(), u.getLogin(), u.getNascimento(), u.getEmail(), u.getRoles()))
                    .collect(Collectors.toList()));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(500), "Erro ao importar arquivo");
        }
    }
}
