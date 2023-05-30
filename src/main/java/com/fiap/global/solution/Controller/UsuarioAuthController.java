package com.fiap.global.solution.Controller;


import com.fiap.global.solution.Dto.LoginDto;
import com.fiap.global.solution.Exception.CPFException;
import com.fiap.global.solution.Model.UsuarioModel;
import com.fiap.global.solution.Repository.RoleRepository;
import com.fiap.global.solution.Repository.UsuarioRepository;
import com.fiap.global.solution.Service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class UsuarioAuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    final UsuarioService usuarioService;

    public UsuarioAuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void validarCPF(UsuarioModel usuarioModel) throws CPFException {
        Optional<UsuarioModel> cadastroCPF = usuarioRepository.findByCpf(usuarioModel.getCpf());

        if (cadastroCPF.isPresent()) {
            throw new CPFException();
        }
    }
    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) {
        try {
            if (usuarioService.loadUserByUsername(loginDto.getLogin())  != null ){

                Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getLogin(), loginDto.getSenha()));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                return new ResponseEntity<>("Usuario Autenticado com sucesso!!.", HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);

    }


    @PostMapping(path = "/signup")
    public ResponseEntity<Object> saveCadastro(@RequestBody UsuarioModel usuarioModel) throws CPFException {
        try {

            this.validarCPF(usuarioModel);

            if (usuarioRepository.findByEmail(usuarioModel.getEmail()).isPresent()) {
                return new ResponseEntity<>("Email ja cadastrado!", HttpStatus.BAD_REQUEST);
            }
            UsuarioModel cadastroSalva = usuarioService.save(usuarioModel);

            return new ResponseEntity<>("Usuario cadastrado com sucesso!", HttpStatus.CREATED);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @ExceptionHandler({CPFException.class})
    public ResponseEntity<String> InvalidaException(CPFException e) {
        String exception = e.getMessage();
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);

    }
}
