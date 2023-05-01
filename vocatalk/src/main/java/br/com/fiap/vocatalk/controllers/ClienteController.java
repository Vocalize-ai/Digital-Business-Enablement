package br.com.fiap.vocatalk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.vocatalk.models.Cliente;
import br.com.fiap.vocatalk.repository.ClienteRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/cliente")
public class ClienteController {
    
    @Autowired
    ClienteRepository clienteRepository;


    @GetMapping
    public List<Cliente> todosClientes( ) {
        return clienteRepository.findAll();
    }
    
    @PostMapping
    public ResponseEntity<Cliente> cadastraCliente(@Valid @RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> encontraClientePorId(@RequestParam Long id) {
       
        var clienteEncontrado = clienteRepository.findById(id);
       
        return ResponseEntity.ok((clienteEncontrado.get()));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizaCadastro(@Valid @PathVariable Long id, @RequestBody Cliente cliente) {

        var clientencontrado = clienteRepository.findById(id);

        if (clientencontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(id);
        clienteRepository.save(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> removerCadastro(@PathVariable Long id) {
        
       var clienteEncontrado = clienteRepository.findById(id);
        if(clienteEncontrado.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        clienteRepository.delete(clienteEncontrado.get());

        return ResponseEntity.noContent().build();
    }
}
