package br.com.fiap.vocatalk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.vocatalk.dto.ContratarPlanoDTO;
import br.com.fiap.vocatalk.dto.FaturaDTO;
import br.com.fiap.vocatalk.exceptions.CustomerHasPlanException;
import br.com.fiap.vocatalk.models.ErrorResponse;
import br.com.fiap.vocatalk.services.ContratarPlanoService;

@RestController
public class ContratarPlanoController {

    private final ContratarPlanoService contratarPlanoService;

    @Autowired
    public ContratarPlanoController(ContratarPlanoService contratarPlanoService) {
        this.contratarPlanoService = contratarPlanoService;
    }

    @PostMapping("/contratar-plano")
    public ResponseEntity<Object> contratarPlano(@RequestBody ContratarPlanoDTO contratarPlanoDTO) {
        try {
            FaturaDTO fatura = contratarPlanoService.contratarPlano(contratarPlanoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(fatura);
        } catch (CustomerHasPlanException e) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage(e.getMessage());
            errorResponse.setErrorCode(400);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

    }
}
