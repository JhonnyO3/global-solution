package com.fiap.global.solution.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cep;

    private String logradouro;

    private String bairro;

    private String localidade;

    private String uf;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuarioModel;

}
