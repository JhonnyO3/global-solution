package com.fiap.global.solution.Service;


import com.fiap.global.solution.Feign.EnderecoFeign;
import com.fiap.global.solution.FeignModels.EnderecoRequestModel;
import com.fiap.global.solution.FeignModels.EnderecoResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EnderecoService {

    @Autowired
    private final EnderecoFeign enderecoFeign;

    public EnderecoResponseModel executa(EnderecoRequestModel request) {
        return enderecoFeign.buscaEnderecoCep(request.getCep());
    }
}
