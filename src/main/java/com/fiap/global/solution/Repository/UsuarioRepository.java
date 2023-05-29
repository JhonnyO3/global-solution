package com.fiap.global.solution.Repository;

import com.fiap.global.solution.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    Optional<UsuarioModel> findByCpf(String cpf);

    Optional<UsuarioModel> findByEmail(String email);

    Optional<UsuarioModel> findByNomeOrEmail(String nome, String email);
}
