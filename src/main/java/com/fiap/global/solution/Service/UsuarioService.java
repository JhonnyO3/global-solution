package com.fiap.global.solution.Service;


import com.fiap.global.solution.Model.UsuarioModel;
import com.fiap.global.solution.Dto.UsuarioUpdateDto;
import com.fiap.global.solution.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService  {

    @Autowired(required = false)
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public UsuarioModel save(UsuarioModel usuarioModel) {
        usuarioModel.setSenha(passwordEncoder.encode(usuarioModel.getSenha()));
        return usuarioRepository.save(usuarioModel);
    }

    public List<UsuarioModel> buscarCadastros(){
        List<UsuarioModel> listCadastros = usuarioRepository.findAll();
        return listCadastros;
    }

    public Page<UsuarioModel> getUsersWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return usuarioRepository.findAllUsuarioModel(pageable);
    }

    public String deleteUserByEmail(String email) {
        try {

            if (usuarioRepository.findByEmail(email).isPresent()) {

                usuarioRepository.deleteByEmail(email);
                return "email deletado com sucesso!";
            }
            return "Usuario não encontrado";


        } catch (Exception e) {
            return e.getMessage();

        }
    }

    public void updateUserByEmail(String email, UsuarioUpdateDto usuarioUpdate) {
        usuarioRepository.updateUsuarioModelByEmail(email, usuarioUpdate);
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        UsuarioModel usuario = usuarioRepository.findByNomeOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email: "+ usernameOrEmail));

        Set<GrantedAuthority> authorities = usuario
                .getRoles()
                .stream()
                .map((role) -> new SimpleGrantedAuthority(role.getNome())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(usuario.getEmail(),
                usuario.getSenha(), authorities
                );
    }
}
