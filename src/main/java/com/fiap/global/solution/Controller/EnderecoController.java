package com.fiap.global.solution.Controller;


import com.fiap.global.solution.FeignModels.EnderecoRequestModel;
import com.fiap.global.solution.Model.UsuarioModel;
import com.fiap.global.solution.Service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
@Tag(name = "Serviço de CEP", description = "API de buscar CEPs")
public class EnderecoController {

    @Autowired
    private final EnderecoService enderecoService;


    @Operation(summary = "Retorna informações do CEP", description = "Retorna dados do CEP informado")
    @ApiResponse(responseCode = "200", description = "Dados do CEP buscados com sucesso!", content = @Content(schema = @Schema(implementation = UsuarioModel.class)))
    @ApiResponse(responseCode = "500", description = "Dados do CEP não encontrados!")
    @GetMapping("/consultaCEP")
    public ResponseEntity consultaCep(@PathVariable EnderecoRequestModel enderecoRequest) {
        return ResponseEntity.ok(enderecoService.executa(enderecoRequest));
    }
}
