package com.nttdata.nttbank.infra.controller;

import com.nttdata.nttbank.application.usecases.usuario.*;
import com.nttdata.nttbank.domain.entities.Usuario;
import com.nttdata.nttbank.infra.controller.dto.UsuarioDto;
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
    public UsuarioDto criarUsuario(@RequestBody UsuarioDto dto) {
        Usuario salvo = criarUsuario.criarUsuario(new Usuario(null, dto.cpf(), dto.nome(), dto.login(), dto.nascimento(), dto.email()));
        return new UsuarioDto(salvo.getCpf(), salvo.getNome(), salvo.getLogin(), salvo.getNascimento(), salvo.getEmail());
    }

    @GetMapping("/listar")
    public List<UsuarioDto> listarUsuarios() {
        return listarUsuarios.listarUsuarios().stream()
                .map(u -> new UsuarioDto(u.getCpf(), u.getNome(), u.getLogin(), u.getNascimento(), u.getEmail()))
                .collect(Collectors.toList());
    }

    @PutMapping("/alterar")
    public UsuarioDto alterarUsuario(@RequestBody UsuarioDto dto) {
        Usuario salvo = alterarUsuario.alterarUsuario(new Usuario(null, dto.cpf(), dto.nome(), dto.login(), dto.nascimento(), dto.email()));
        return new UsuarioDto(salvo.getCpf(), salvo.getNome(), salvo.getLogin(), salvo.getNascimento(), salvo.getEmail());
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Void> removerUsuario(@PathVariable("id") Long id) {
        removerUsuario.removerUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/upload")
    public List<UsuarioDto> uploadExcel(@RequestParam("file") MultipartFile file) {
        try {
            List<Usuario> usuarios = importarUsuariosExcel.importarUsuariosExcel(file);
            return usuarios.stream()
                    .map(u -> new UsuarioDto(u.getCpf(), u.getNome(), u.getLogin(), u.getNascimento(), u.getEmail()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(500), "Erro ao importar arquivo");
        }
    }
}
