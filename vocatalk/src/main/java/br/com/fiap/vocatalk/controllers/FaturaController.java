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

import br.com.fiap.vocatalk.exception.RestNotFoundException;
import br.com.fiap.vocatalk.models.Fatura;
import br.com.fiap.vocatalk.repository.FaturaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/fatura")
public class FaturaController {
    
    @Autowired
    FaturaRepository faturaRepository;

    @GetMapping
    public List<Fatura> todasFaturas() {
        return faturaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Fatura> cadastraFatura(@RequestBody @Valid Fatura fatura) {
        faturaRepository.save(fatura);
        return ResponseEntity.status(HttpStatus.CREATED).body(fatura);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fatura> encontraFaturaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(getFatura(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Fatura> removeFatura(@PathVariable Long id) {

        faturaRepository.delete(getFatura(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fatura> atualizaFatura(@PathVariable Long id, @RequestBody @Valid Fatura fatura) {
        getFatura(id);
        fatura.setId(id);
        faturaRepository.save(fatura);
        return ResponseEntity.ok(fatura);
    }

    private Fatura getFatura(Long id) {
        return faturaRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Fatura não encontrada"));
    }
}
