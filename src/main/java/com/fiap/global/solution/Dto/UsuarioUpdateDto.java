package com.fiap.global.solution.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UsuarioUpdateDto {

    private String nome;

    private String telefone;

    private String cpf;

    private String senha;



}
