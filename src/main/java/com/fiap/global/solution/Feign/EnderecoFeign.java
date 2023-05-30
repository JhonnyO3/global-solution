package com.fiap.global.solution.Feign;


import com.fiap.global.solution.FeignModels.EnderecoResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")
public interface EnderecoFeign {

    @GetMapping("{cep}/json")
    @Autowired
    EnderecoResponseModel buscaEnderecoCep(@PathVariable("cep") String cep);
}
