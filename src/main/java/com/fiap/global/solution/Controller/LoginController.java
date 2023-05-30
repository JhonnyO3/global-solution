//package com.fiap.global.solution.Controller;
//
//
//import com.fiap.global.solution.Model.LoginModel;
//import com.fiap.global.solution.Service.LoginService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RequestMapping("/api")
//public class LoginController {
//
//    final LoginService loginService;
//
//
//    public LoginController(LoginService loginService) {
//        this.loginService = loginService;
//    }
//
//    @GetMapping(path = "/buscarLogins")
//    public List<LoginModel> buscarLogin() {
//        return loginService.buscarLogins();
//
//    }
//
//    @PostMapping(path = "/fazerLogin")
//    public ResponseEntity<Object> saveCadastro(@RequestBody LoginModel loginModels) {
//        try {
//            return ResponseEntity.status(HttpStatus.OK).body(loginService.save(loginModels));
//        } catch (Exception excecao) {
//
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(excecao);
//        }
//    }
//
//    @PutMapping("/atualizarSenha")
//    public ResponseEntity<LoginModel> Put(@RequestBody LoginModel loginModel) {
//        Optional<LoginModel> user = loginService.AtualizarSenha(loginModel);
//        try {
//            return ResponseEntity.ok(user.get());
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().build();
//        }
//    }
//}
