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
import br.com.fiap.vocatalk.models.ItensFatura;
import br.com.fiap.vocatalk.repository.ItensFaturaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/itensFatura")
public class ItensFaturaController {
    
    @Autowired
    ItensFaturaRepository itensFaturaRepository;

    @GetMapping
    public List<ItensFatura> todosItensFatura() {
        return itensFaturaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<ItensFatura> cadastraItensFatura(@RequestBody @Valid ItensFatura itensFatura) {
        itensFaturaRepository.save(itensFatura);
        return ResponseEntity.status(HttpStatus.CREATED).body(itensFatura);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItensFatura> encontraItensFaturaPorId(@PathVariable  Long id) {
        return ResponseEntity.ok(getItensFatura(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItensFatura> removeItensFatura(@PathVariable Long id) {

        itensFaturaRepository.delete(getItensFatura(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItensFatura> atualizaItensFatura(@PathVariable Long id, @RequestBody @Valid ItensFatura itensFatura) {
        getItensFatura(id);
        itensFatura.setId(id);
        itensFaturaRepository.save(itensFatura);
        return ResponseEntity.ok(itensFatura);
    }

    private ItensFatura getItensFatura(Long id) {
        return itensFaturaRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Itens da fatura não encontrado"));
    }
}
