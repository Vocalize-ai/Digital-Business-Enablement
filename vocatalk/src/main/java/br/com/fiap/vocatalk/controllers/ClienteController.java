package br.com.fiap.vocatalk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.vocatalk.exceptions.RestNotFoundException;
import br.com.fiap.vocatalk.models.Cliente;
import br.com.fiap.vocatalk.repositories.ClienteRepository;
import br.com.fiap.vocatalk.repositories.TelefoneRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteRepository repository;

    @Autowired
    TelefoneRepository repositoryTelefone;

    @GetMapping
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @PostMapping()
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
    
        repository.save(cliente);

        return ResponseEntity.ok(cliente);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(getCliente(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long id, @RequestBody Cliente cliente) {
        getCliente(id);
        cliente.setId(id);
        repository.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> remover(@PathVariable Long id) {

        repository.delete(getCliente(id));

        return ResponseEntity.noContent().build();
    }

    private Cliente getCliente(Long id) {
        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("cliente não encontrado"));
    }
}
