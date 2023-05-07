package br.com.fiap.vocatalk.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.fiap.vocatalk.exception.RestNotFoundException;
import br.com.fiap.vocatalk.models.TelefoneContato;
import br.com.fiap.vocatalk.repository.TelefoneContatoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/telefoneContato")
public class TelefoneContatoController {
 
    @Autowired
    TelefoneContatoRepository telefoneContatoRepository;

    
    @GetMapping
    public List<TelefoneContato> todosTelefonesContato() {
        return telefoneContatoRepository.findAll();
    }
    
    @PostMapping
    public ResponseEntity<TelefoneContato> cadastrarTelefoneContato(@RequestBody @Valid TelefoneContato telefoneContato){
        telefoneContatoRepository.save(telefoneContato);
        return ResponseEntity.status(HttpStatus.CREATED).body(telefoneContato);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelefoneContato> encotraTelefoneContatoPorId(@PathVariable Long id){
        return ResponseEntity.ok(getTelefoneContato(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelefoneContato> atualizaTelefoneContato(@Valid @PathVariable Long id, @RequestBody TelefoneContato telefoneContato){
        getTelefoneContato(id);
        telefoneContato.setId(id);
        telefoneContatoRepository.save(telefoneContato);
        return ResponseEntity.ok(telefoneContato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TelefoneContato> removeTelefoneContato(@PathVariable Long id){
        telefoneContatoRepository.delete(getTelefoneContato(id));
        return ResponseEntity.noContent().build();
    }
        
    private TelefoneContato getTelefoneContato(Long id) {
        return telefoneContatoRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Telefone de contato não encontrado"));
    }
}
