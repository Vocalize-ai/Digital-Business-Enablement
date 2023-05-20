package br.com.fiap.vocatalk.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.vocatalk.dto.ItemFaturaDTO;
import br.com.fiap.vocatalk.exceptions.RestNotFoundException;
import br.com.fiap.vocatalk.models.ItemFatura;
import br.com.fiap.vocatalk.models.Plano;
import br.com.fiap.vocatalk.models.ServicoAdicional;
import br.com.fiap.vocatalk.repositories.ItemFaturaRepository;
import br.com.fiap.vocatalk.repositories.PlanoRepository;
import br.com.fiap.vocatalk.repositories.ServicoAdicionalRepository;

@Service
public class ItemFaturaService {

    private final ItemFaturaRepository itemFaturaRepository;
    private final PlanoRepository planoRepository;
    private final ServicoAdicionalRepository servicoAdicionalRepository;

    @Autowired
    public ItemFaturaService(ItemFaturaRepository itemFaturaRepository,
            PlanoRepository planoRepository,
            ServicoAdicionalRepository servicoAdicionalRepository) {
        this.itemFaturaRepository = itemFaturaRepository;
        this.planoRepository = planoRepository;
        this.servicoAdicionalRepository = servicoAdicionalRepository;
    }

    public ItemFaturaDTO criarItemFatura(ItemFaturaDTO itemFaturaDTO) {
        ItemFatura itemFatura = new ItemFatura();
        BeanUtils.copyProperties(itemFaturaDTO, itemFatura);

        // Obter o plano existente no banco de dados
        Plano plano = planoRepository.findById(itemFaturaDTO.getPlano().getId())
                .orElseThrow(() -> new RestNotFoundException("Plano não encontrado"));

        // Obter os serviços adicionais existentes no banco de dados
        // Obter os serviços adicionais existentes no banco de dados
        List<ServicoAdicional> servicosAdicionais = new ArrayList<>();
    for (ServicoAdicional servicoAdicional : itemFaturaDTO.getServicosAdicionais()) {
        ServicoAdicional servicoAdicionalEncontrado = servicoAdicionalRepository.findById(servicoAdicional.getId())
                .orElseThrow(() -> new RestNotFoundException("Serviço adicional não encontrado: " + servicoAdicional.getId()));
        servicosAdicionais.add(servicoAdicionalEncontrado);
    }

        itemFatura.setPlano(plano);
        itemFatura.setServicosAdicionais(servicosAdicionais);

        ItemFatura itemFaturaSalvo = itemFaturaRepository.save(itemFatura);
        ItemFaturaDTO itemFaturaSalvoDTO = new ItemFaturaDTO();
        BeanUtils.copyProperties(itemFaturaSalvo, itemFaturaSalvoDTO);
        return itemFaturaSalvoDTO;
    }

    // Outros métodos do serviço (atualizar, excluir, buscar por ID, etc.)

}
