package br.com.fiap.vocatalk.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.vocatalk.dto.FaturaDTO;
import br.com.fiap.vocatalk.exceptions.RestNotFoundException;
import br.com.fiap.vocatalk.services.FaturaService;

@RestController
@RequestMapping("/faturas")
public class FaturaController {

    private final FaturaService faturaService;

    @Autowired
    public FaturaController(FaturaService faturaService) {
        this.faturaService = faturaService;
    }

    @GetMapping
    public ResponseEntity<List<FaturaDTO>> getAllFaturas() {
        List<FaturaDTO> faturas = faturaService.getAll();
        return ResponseEntity.ok(faturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FaturaDTO> getFaturaById(@PathVariable Long id) {
        try {
            FaturaDTO fatura = faturaService.getById(id);
            return ResponseEntity.ok(fatura);
        } catch (RestNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<FaturaDTO> createFatura(@RequestBody FaturaDTO faturaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(faturaService.create(faturaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FaturaDTO> updateFatura(@PathVariable Long id, @RequestBody FaturaDTO faturaDTO) {
        try {
            FaturaDTO faturaAtualizada = faturaService.update(id, faturaDTO);
            return ResponseEntity.ok(faturaAtualizada);
        } catch (RestNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFatura(@PathVariable Long id) {
        try {
            faturaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RestNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
