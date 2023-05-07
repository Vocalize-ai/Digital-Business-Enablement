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
import br.com.fiap.vocatalk.models.Plano;
import br.com.fiap.vocatalk.repository.PlanoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/plano")
public class PlanoController {
 
    @Autowired
    PlanoRepository planoRepository;

    @GetMapping
    public List<Plano> todosPlanos() {
        return planoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Plano> cadastraPlano(@RequestBody @Valid Plano plano) {
        planoRepository.save(plano);
        return ResponseEntity.status(HttpStatus.CREATED).body(plano);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plano> encontraPlanoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(getPlano(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Plano> removePlano(@PathVariable Long id) {

        planoRepository.delete(getPlano(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plano> atualizaPlano(@PathVariable Long id, @RequestBody @Valid Plano plano) {
        getPlano(id);
        plano.setId(id);
        planoRepository.save(plano);
        return ResponseEntity.ok(plano);
    }

    private Plano getPlano(Long id) {
        return planoRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Plano não encontrado"));
    }
}
