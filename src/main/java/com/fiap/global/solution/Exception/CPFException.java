package com.fiap.global.solution.Exception;

public class CPFException extends Exception{

    private static final long serialVersionUID = 1L;

    public CPFException(){
        super("Erro CPF já cadastrado!");
    }
}
