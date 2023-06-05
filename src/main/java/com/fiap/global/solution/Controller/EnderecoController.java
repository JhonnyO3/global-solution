package com.fiap.global.solution.Controller;


import com.fiap.global.solution.FeignModels.EnderecoRequestModel;
import com.fiap.global.solution.Service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class EnderecoController {

    @Autowired
    private final EnderecoService enderecoService;

    @GetMapping("/consultaCEP/{enderecoRequest}")
    public ResponseEntity consultaCep(@PathVariable String enderecoRequest) {
        try {

            return ResponseEntity.ok(enderecoService.executa(enderecoRequest));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
