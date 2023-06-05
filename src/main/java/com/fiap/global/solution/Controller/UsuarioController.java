package com.fiap.global.solution.Controller;

import com.fiap.global.solution.Model.UsuarioModel;
import com.fiap.global.solution.Dto.UsuarioUpdateDto;
import com.fiap.global.solution.Repository.UsuarioRepository;
import com.fiap.global.solution.Service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@Tag(name = "Usuario serviços", description = "API de gerenciamento de usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioService usuarioService;

    @Operation(summary = "Retorna uma lista com todos os usuarios em paginação", description = "Retorna uma lista com todos os usuarios em paginação")
    @ApiResponse(responseCode = "200", description = "Usuarios encontrados com sucesso!", content = @Content(schema = @Schema(implementation = UsuarioModel.class)))
    @ApiResponse(responseCode = "404", description = "Usuarios não encontrados!")
    @GetMapping("/{pagina}/{tamanho}")
    public Page<UsuarioModel> buscarTodosUsuarios(@PathVariable int pagina, @PathVariable int tamanho) {
        return usuarioService.getUsersWithPagination(pagina, tamanho);
    }

    @Operation(summary = "Deletar usuario com parametro Email", description = "Deleta o usuario com a passagem de parametro de Email")
    @ApiResponse(responseCode = "200", description = "Usuario deletado com sucesso!")
    @ApiResponse(responseCode = "404", description = "Usuario não encontrado!")
    @DeleteMapping("/deletar")
    public ResponseEntity deletarUsuario(@RequestBody String email) {
        try {
            String deletar = usuarioService.deleteUserByEmail(email);

            if (deletar.equals("Usuario não encontrado")) {
                return new ResponseEntity<>(deletar, HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(deletar, HttpStatus.OK);
            }


        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Buscar Usuarios", description = "Buscar listas de usuarios")
    @ApiResponse(responseCode = "200", description = "Usuario deletado com sucesso!", content = @Content(schema = @Schema(implementation = UsuarioModel.class)))
    @ApiResponse(responseCode = "404", description = "Usuario não encontrado!")
    @GetMapping(path = "/buscarUsuarios")
    public ResponseEntity<List<UsuarioModel>> buscarCadastro() {
        try {

            List<UsuarioModel> usuarios = usuarioRepository.findAll();

            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    @Operation(summary = "Atualizar Usuario com parametro Email", description = "Atualizar Usuario")
    @ApiResponse(responseCode = "200", description = "Usuario alterado com sucesso!", content = @Content(schema = @Schema(implementation = UsuarioModel.class)))
    @ApiResponse(responseCode = "404", description = "Usuario não encontrado!")
    @PutMapping("/atualizar/{email}")
    public ResponseEntity atualizarInfoUsuario(@PathVariable String email, @RequestBody UsuarioUpdateDto usuarioUpdate) {
        try {

            usuarioService.updateUserByEmail(email, usuarioUpdate);
            return new ResponseEntity(usuarioUpdate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
