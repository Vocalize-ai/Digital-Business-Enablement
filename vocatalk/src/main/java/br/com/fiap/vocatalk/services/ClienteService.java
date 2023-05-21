package br.com.fiap.vocatalk.services;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.vocatalk.dto.ClienteDTO;
import br.com.fiap.vocatalk.dto.FaturaDTO;
import br.com.fiap.vocatalk.models.Cliente;
import br.com.fiap.vocatalk.models.Fatura;
import br.com.fiap.vocatalk.repositories.ClienteRepository;

public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final FaturaService faturaService;

    public ClienteService(ClienteRepository clienteRepository, FaturaService faturaService) {
        this.clienteRepository = clienteRepository;
        this.faturaService = faturaService;
    }

    public List<ClienteDTO> getAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDTO> clienteDTOs = new ArrayList<>();

        for (Cliente cliente : clientes) {
            List<Fatura> faturaDTOs = new ArrayList<>();
            for (Fatura fatura : cliente.getFatura()) {
                FaturaDTO faturaDTO = new FaturaDTO();
                // Mapear os dados da fatura para o DTO
                faturaDTO.setId(fatura.getId());
                // ... Mapear outros atributos da fatura

                faturaDTOs.add(fatura);;
            }

            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setId(cliente.getId());
            clienteDTO.setNome(cliente.getNome());
            clienteDTO.setFatura(faturaDTOs);
            // ... Mapear outros atributos do cliente

            clienteDTOs.add(clienteDTO);
        }

        return clienteDTOs;
    }

}
