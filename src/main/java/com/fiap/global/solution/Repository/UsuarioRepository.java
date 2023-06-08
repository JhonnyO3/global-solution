package com.fiap.global.solution.Repository;

import com.fiap.global.solution.Model.UsuarioModel;
import com.fiap.global.solution.Dto.UsuarioUpdateDto;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    Optional<UsuarioModel> findByCpf(String cpf);

    Optional<UsuarioModel> findByEmail(String email);

    @Query("SELECT u FROM GS_USUARIO u")
    Page<UsuarioModel> findAllUsuarioModel(Pageable pageable);

    @Modifying
    @Transactional
    @Query("DELETE FROM GS_USUARIO u WHERE u.email = :email")
    void deleteByEmail(String email);


    @Modifying
    @Transactional
    @Query("UPDATE GS_USUARIO u SET u.nome = :#{#usuario.nome}, u.telefone = :#{#usuario.telefone}, u.cpf = :#{#usuario.cpf}, u.senha = :#{#usuario.senha} WHERE u.email = :email")
    void updateUsuarioModelByEmail(String email, UsuarioUpdateDto usuario);



    Optional<UsuarioModel> findByNomeOrEmail(String nome, String email);
}
