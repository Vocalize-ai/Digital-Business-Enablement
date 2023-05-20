package br.com.fiap.vocatalk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.vocatalk.dto.ItemFaturaDTO;
import br.com.fiap.vocatalk.repositories.PlanoRepository;
import br.com.fiap.vocatalk.repositories.ServicoAdicionalRepository;
import br.com.fiap.vocatalk.services.ItemFaturaService;

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
    // @GetMapping("/{id}")
    // public ResponseEntity<ItemFatura> encontraItensFaturaPorId(@PathVariable Long
    // id) {
    // return ResponseEntity.ok(getItensFatura(id));
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<ItemFatura> removeItensFatura(@PathVariable Long id) {

    // itensFaturaRepository.delete(getItensFatura(id));
    // return ResponseEntity.noContent().build();
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity<ItemFatura> atualizaItensFatura(@PathVariable Long id,
    // @RequestBody @Valid ItemFatura itensFatura) {
    // getItensFatura(id);
    // itensFatura.setId(id);
    // itensFaturaRepository.save(itensFatura);
    // return ResponseEntity.ok(itensFatura);
    // }

    // private ItemFatura getItensFatura(Long id) {
    // return itensFaturaRepository.findById(id)
    // .orElseThrow(() -> new RestNotFoundException("Itens da fatura não
    // encontrado"));
    // }
}
