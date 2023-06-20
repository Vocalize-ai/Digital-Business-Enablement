package br.com.fiap.vocatalk.services.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import br.com.fiap.vocatalk.controllers.ClienteController;
import br.com.fiap.vocatalk.dto.requestDTO.ClienteRequestDTO;
import br.com.fiap.vocatalk.dto.responseDTO.ClienteResponseDTO;
import br.com.fiap.vocatalk.models.Cliente;
import br.com.fiap.vocatalk.repositories.ClienteRepository;
import br.com.fiap.vocatalk.services.ClienteService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.Link;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Page<EntityModel<ClienteResponseDTO>> buscarTodos(Pageable pageable) {
        Page<Cliente> clientesPage = clienteRepository.findAll(pageable);
        Page<ClienteResponseDTO> clientesResponsePage = clientesPage.map(ClienteResponseDTO::new);
        Page<EntityModel<ClienteResponseDTO>> entityModelPage = clientesResponsePage
                .map(clienteResponseDTO -> EntityModel.of(clienteResponseDTO));
        return entityModelPage;
    }

    @Override
    public EntityModel<ClienteResponseDTO> buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO(cliente);
        return EntityModel.of(clienteResponseDTO);
    }

    @Override
    public EntityModel<ClienteResponseDTO> cadastrar(ClienteRequestDTO cliente) {
        Cliente novoCliente = new Cliente(cliente);
        novoCliente.setDataCadastro(LocalDateTime.now());
        Cliente clienteSalvo = clienteRepository.save(novoCliente);
        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO(clienteSalvo);
        return EntityModel.of(clienteResponseDTO);
    }

    @Override
    public EntityModel<ClienteResponseDTO> atualizar(Long id, ClienteRequestDTO cliente) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        Cliente clienteAtualizado = clienteRepository.save(clienteExistente);
        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO(clienteAtualizado);
        return EntityModel.of(clienteResponseDTO);
    }

    @Override
    public void deletar(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        clienteRepository.delete(cliente);
    }

    @Override
    public ClienteResponseDTO getCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO(cliente);
        Link selfLink = linkTo(methodOn(ClienteController.class).buscarPorId(id)).withSelfRel();
        clienteResponseDTO.add(selfLink);
        return clienteResponseDTO;
    }

}
