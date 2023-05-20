package br.com.fiap.vocatalk.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.fiap.vocatalk.exceptions.RestNotFoundException;
import br.com.fiap.vocatalk.models.ServicoAdicional;
import br.com.fiap.vocatalk.repositories.ServicoAdicionalRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/servicoAdicional")
public class ServicoAdicionalController {
    
    @Autowired
    ServicoAdicionalRepository servicoAdicionalRepository;
    
    @GetMapping
    public List<ServicoAdicional> todosServicosAdicionais() {
        return servicoAdicionalRepository.findAll();
    }
    
    @PostMapping
    public ResponseEntity<ServicoAdicional> cadastrarServicoAdiconal(@Valid @RequestBody ServicoAdicional servicoAdicional){
        servicoAdicionalRepository.save(servicoAdicional);
        return ResponseEntity.status(HttpStatus.CREATED).body(servicoAdicional);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoAdicional> encotraServicoAdiconalPorId(@PathVariable Long id){
        return ResponseEntity.ok(getServicoAdicional(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoAdicional> atualizaSevicoAdicional(@Valid @PathVariable Long id, @RequestBody ServicoAdicional servicoAdicional){
        getServicoAdicional(id);
        servicoAdicional.setId(id);
        servicoAdicionalRepository.save(servicoAdicional);
        return ResponseEntity.ok(servicoAdicional);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ServicoAdicional> removeServicoAdicional(@PathVariable Long id){
        servicoAdicionalRepository.delete(getServicoAdicional(id));
        return ResponseEntity.noContent().build();
    }
        
    private ServicoAdicional getServicoAdicional(Long id) {
        return servicoAdicionalRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Serviço adicional não encontrado"));
    }
}
