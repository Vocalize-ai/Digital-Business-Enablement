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

import br.com.fiap.vocatalk.dto.ItemFaturaDTO;
import br.com.fiap.vocatalk.exceptions.RestNotFoundException;
import br.com.fiap.vocatalk.models.ItemFatura;
import br.com.fiap.vocatalk.repositories.PlanoRepository;
import br.com.fiap.vocatalk.repositories.ServicoAdicionalRepository;
import br.com.fiap.vocatalk.services.ItemFaturaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/itemFatura")
public class ItemFaturaController {

    @Autowired
    ItemFaturaService itemFaturaService;

    @Autowired
    PlanoRepository planoRepository;

    @Autowired
    ServicoAdicionalRepository servicoAdicionalRepository;

    @GetMapping
    public List<ItemFaturaDTO> todosItensFatura() {

        return itemFaturaService.getAll();
    }

    @PostMapping
    public ResponseEntity<ItemFaturaDTO> criarItemFatura(@RequestBody ItemFaturaDTO itemFaturaDTO) {
        ItemFaturaDTO itemFaturaSalvo = itemFaturaService.create(itemFaturaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemFaturaSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemFaturaDTO> encontraItensFaturaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(itemFaturaService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemFaturaDTO> atualizaItensFatura(@PathVariable Long id,
            @RequestBody @Valid ItemFaturaDTO itensFatura) {
        ItemFaturaDTO itemFaturaDTO = itemFaturaService.update(id, itensFatura);
        return ResponseEntity.ok(itemFaturaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemFatura> removeItensFatura(@PathVariable Long id) {

        try {
            itemFaturaService.deletePorID(id);
            return ResponseEntity.noContent().build();
        } catch (RestNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

}
