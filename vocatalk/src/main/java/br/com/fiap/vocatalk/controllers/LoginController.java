package br.com.fiap.vocatalk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.vocatalk.dto.LoginDTO;
import br.com.fiap.vocatalk.dto.LoginInjectDTO;
import br.com.fiap.vocatalk.models.Credencial;
import br.com.fiap.vocatalk.services.LoginService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RestController
@Tag(name = "auth")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/registrar")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "despesa cadastrada com sucesso"),
        @ApiResponse(responseCode = "400", description = "dados inválidos, a validação falhou")
    })
    public ResponseEntity<LoginDTO> registrar(@RequestBody @Valid LoginInjectDTO login) {

        try {
            LoginDTO loginDTO = loginService.registrar(login);
            return ResponseEntity.status(HttpStatus.CREATED).body(loginDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid Credencial credencial) {
        try {
            Object token = loginService.login(credencial);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            // Tratar exceção específica ou retornar uma resposta genérica de erro
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
