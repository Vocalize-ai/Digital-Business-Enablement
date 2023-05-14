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
import br.com.fiap.vocatalk.models.ItemFatura;
import br.com.fiap.vocatalk.repository.ItemFaturaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/itemFatura")
public class ItemFaturaController {
    
    @Autowired
    ItemFaturaRepository itensFaturaRepository;

    @GetMapping
    public List<ItemFatura> todosItensFatura() {
        return itensFaturaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<ItemFatura> cadastraItensFatura(@RequestBody @Valid ItemFatura itensFatura) {
        itensFaturaRepository.save(itensFatura);
        return ResponseEntity.status(HttpStatus.CREATED).body(itensFatura);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemFatura> encontraItensFaturaPorId(@PathVariable  Long id) {
        return ResponseEntity.ok(getItensFatura(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemFatura> removeItensFatura(@PathVariable Long id) {

        itensFaturaRepository.delete(getItensFatura(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemFatura> atualizaItensFatura(@PathVariable Long id, @RequestBody @Valid ItemFatura itensFatura) {
        getItensFatura(id);
        itensFatura.setId(id);
        itensFaturaRepository.save(itensFatura);
        return ResponseEntity.ok(itensFatura);
    }

    private ItemFatura getItensFatura(Long id) {
        return itensFaturaRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Itens da fatura não encontrado"));
    }
}
