package br.com.fiap.vocatalk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.vocatalk.dto.requestDTO.ClienteRequestDTO;
import br.com.fiap.vocatalk.dto.responseDTO.ClienteResponseDTO;
import br.com.fiap.vocatalk.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Page<EntityModel<ClienteResponseDTO>>> buscarTodos(Pageable pageable) {
        Page<EntityModel<ClienteResponseDTO>> clientes = clienteService.buscarTodos(pageable);
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ClienteResponseDTO>> buscarPorId(@PathVariable Long id) {
        EntityModel<ClienteResponseDTO> clienteModel = clienteService.buscarPorId(id);
        return ResponseEntity.ok(clienteModel);
    }

    @PostMapping
    public ResponseEntity<EntityModel<ClienteResponseDTO>> cadastrar(@RequestBody ClienteRequestDTO cliente) {
        EntityModel<ClienteResponseDTO> clienteModel = clienteService.cadastrar(cliente);
        return ResponseEntity.ok(clienteModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<ClienteResponseDTO>> atualizar(@PathVariable Long id,
            @RequestBody ClienteRequestDTO cliente) {
        EntityModel<ClienteResponseDTO> clienteModel = clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(clienteModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
