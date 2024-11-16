package com.nttdata.nttbank.infra.controller;

import com.nttdata.nttbank.application.usecases.*;
import com.nttdata.nttbank.domain.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @PostMapping
    public UsuarioDto criarUsuario(@RequestBody UsuarioDto dto) {
        Usuario salvo = criarUsuario.criarUsuario(new Usuario(dto.cpf(), dto.nome(), dto.login(), dto.nascimento(), dto.email()));
        return new UsuarioDto(salvo.getCpf(), salvo.getNome(), salvo.getLogin(), salvo.getNascimento(), salvo.getEmail());

    }

}
