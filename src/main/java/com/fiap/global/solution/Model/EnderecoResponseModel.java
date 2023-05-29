package com.fiap.global.solution.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EnderecoResponseModel {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
