package br.com.fiap.vocatalk.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.vocatalk.dto.requestDTO.ClienteRequestDTO;
import br.com.fiap.vocatalk.dto.responseDTO.ClienteResponseDTO;

public interface ClienteService {

    Page<EntityModel<ClienteResponseDTO>> buscarTodos(Pageable pageable);

    EntityModel<ClienteResponseDTO> buscarPorId(Long id);

    EntityModel<ClienteResponseDTO> cadastrar(ClienteRequestDTO cliente);

    EntityModel<ClienteResponseDTO> atualizar(Long id, ClienteRequestDTO cliente);

    void deletar(Long id);

    ClienteResponseDTO getCliente(Long id);

}
