package br.com.fiap.vocatalk.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.fiap.vocatalk.dto.responseDTO.ClienteResponseDTO;

public interface ClienteService {

    Page<ClienteResponseDTO> getAll(Pageable pageable);
    
}
