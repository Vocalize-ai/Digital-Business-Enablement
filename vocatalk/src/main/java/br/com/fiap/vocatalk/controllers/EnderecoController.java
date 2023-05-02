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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.vocatalk.exception.RestNotFoundException;
import br.com.fiap.vocatalk.models.Endereco;
import br.com.fiap.vocatalk.repository.EnderecoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/endereco")
public class EnderecoController {
    
    @Autowired
    EnderecoRepository enderecoRepository;

    @GetMapping
    public List<Endereco> todosEnderecos( ) {
        return enderecoRepository.findAll();
    }
    
    @PostMapping
    public ResponseEntity<Endereco> cadastraEndereco(@Valid @RequestBody Endereco endereco) {
        enderecoRepository.save(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Endereco> encontraEnderecoPorId(@RequestParam Long id) {
        return ResponseEntity.ok(getEndereco(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizaEndereco(@Valid @PathVariable Long id, @RequestBody Endereco endereco) {
        getEndereco(id);
        endereco.setId(id);
        enderecoRepository.save(endereco);
        return ResponseEntity.ok(endereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Endereco> removerEndereco(@PathVariable Long id) {
        
        enderecoRepository.delete(getEndereco(id));

        return ResponseEntity.noContent().build();
    }

    private Endereco getEndereco(Long id) {
        return enderecoRepository.findById(id).orElseThrow(() -> new RestNotFoundException("endereço não encontrado"));
    }
}