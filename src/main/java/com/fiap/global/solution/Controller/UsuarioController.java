package com.fiap.global.solution.Controller;

import com.fiap.global.solution.Model.UsuarioModel;
import com.fiap.global.solution.Dto.UsuarioUpdateDto;
import com.fiap.global.solution.Repository.UsuarioRepository;
import com.fiap.global.solution.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/{pagina}/{tamanho}")
    public Page<UsuarioModel> buscarTodosUsuarios(@PathVariable int pagina, @PathVariable int tamanho) {
        return usuarioService.getUsersWithPagination(pagina, tamanho);
    }

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
