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

import br.com.fiap.vocatalk.exceptions.RestNotFoundException;
import br.com.fiap.vocatalk.models.TipoPagamento;
import br.com.fiap.vocatalk.repositories.TipoPagamentoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tipoPagamento")
public class TipoPagamentoController {
    
    @Autowired
    TipoPagamentoRepository tipoPagamentoRepository;

    @GetMapping
    public List<TipoPagamento> todosTiposPagamentos() {
        return tipoPagamentoRepository.findAll();
    }
    
    @PostMapping
    public ResponseEntity<TipoPagamento> cadastrarTipoPagamento(@Valid @RequestBody TipoPagamento tipoPagamento){
        tipoPagamentoRepository.save(tipoPagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoPagamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPagamento> encotraTipoPagamentoPorId(@PathVariable Long id){
        return ResponseEntity.ok(getTipoPagamento(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPagamento> atualizaTipoPagamento(@Valid @PathVariable Long id, @RequestBody TipoPagamento tipoPagamento){
        getTipoPagamento(id);
        tipoPagamento.setId(id);
        tipoPagamentoRepository.save(tipoPagamento);
        return ResponseEntity.ok(tipoPagamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoPagamento> removeTipoPagamento(@PathVariable Long id){
        tipoPagamentoRepository.delete(getTipoPagamento(id));
        return ResponseEntity.noContent().build();
    }
        
    private TipoPagamento getTipoPagamento(Long id) {
        return tipoPagamentoRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Tipo de pagamento não encontrado"));
    }
}
