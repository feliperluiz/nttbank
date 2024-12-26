package com.nttdata.nttbank.infra.gateways.jpa;

import com.nttdata.nttbank.application.gateways.RepositorioDeUsuario;
import com.nttdata.nttbank.domain.entities.Usuario;
import com.nttdata.nttbank.infra.controller.dto.UsuarioDto;
import com.nttdata.nttbank.infra.gateways.mapper.UsuarioEntityMapper;
import com.nttdata.nttbank.infra.persistence.entities.UsuarioEntity;
import com.nttdata.nttbank.infra.persistence.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario, UserDetailsService {

    private final UsuarioRepository repositorio;

    private final UsuarioEntityMapper mapper;

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        entity = repositorio.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return repositorio.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Usuario alterarUsuario(Usuario usuario) {
        UsuarioEntity entity = repositorio.findByCpf(usuario.getCpf());
        if (entity == null) {
            throw new EntityNotFoundException("Entidade com CPF " + usuario.getCpf() + " não encontrada.");
        }

        UsuarioEntity entityUpdated = mapper.toEntity(usuario);
        entityUpdated.setId(entity.getId());
        entityUpdated = repositorio.save(entityUpdated);
        return mapper.toDomain(entityUpdated);
    }

    @Override
    public void removerUsuario(Long id) {
        UsuarioEntity entity = repositorio.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado."));
        repositorio.delete(entity);
    }

    @Override
    public List<Usuario> importarUsuariosExcel(MultipartFile file) throws IOException {
        List<Usuario> usuarios = new ArrayList<>();

        try (InputStream is = file.getInputStream();
             Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Usuario usuario = new Usuario();
                    usuario.setCpf(getCellValueAsString(row.getCell(0)));
                    usuario.setNome(row.getCell(1).getStringCellValue());
                    usuario.setLogin(row.getCell(2).getStringCellValue());
                    usuario.setSenha(row.getCell(3).getStringCellValue());
                    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    Date dataNascimento = row.getCell(4).getDateCellValue();
                    LocalDate localDate = dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    usuario.setNascimento(localDate);
                    usuario.setEmail(row.getCell(5).getStringCellValue());
                    usuario.setRoles(List.of(row.getCell(6).getStringCellValue().split(",")));
                    usuarios.add(usuario);
                }
            }
        }

        List<UsuarioEntity> usuarioEntityList = usuarios.stream().map(mapper::toEntity).collect(Collectors.toList());
        List<UsuarioEntity> usuarioEntityListSaved = repositorio.saveAll(usuarioEntityList);
        return usuarioEntityListSaved.stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return repositorio.findByLogin(login);
    }

    private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue(); // Se for STRING, retorna o valor direto.
            case NUMERIC:
                return String.valueOf((long) cell.getNumericCellValue());
            case BOOLEAN:
                return Boolean.toString(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";
        }
    }


}
