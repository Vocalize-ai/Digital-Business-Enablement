package br.com.fiap.vocatalk.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    public ItemFaturaService(ItemFaturaRepository itemFaturaRepository, PlanoRepository planoRepository,
            ServicoAdicionalRepository servicoAdicionalRepository) {
        this.itemFaturaRepository = itemFaturaRepository;
        this.planoRepository = planoRepository;
        this.servicoAdicionalRepository = servicoAdicionalRepository;
    }


    public List<ItemFaturaDTO> getAll() {
        List<ItemFatura> itemFaturas = itemFaturaRepository.findAll();
        return itemFaturas.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }



    public ItemFaturaDTO create(ItemFaturaDTO itemFaturaDTO) {
        ItemFatura itemFatura = new ItemFatura();
        BeanUtils.copyProperties(itemFaturaDTO, itemFatura);

        Plano plano = planoRepository.findById(itemFaturaDTO.getPlano().getId())
                .orElseThrow(() -> new RestNotFoundException("Plano não encontrado"));

        itemFatura.setStatus('A');
        itemFatura.setAdicionado(LocalDateTime.now());


        List<ServicoAdicional> servicosAdicionais = new ArrayList<>();

        for (ServicoAdicional servicoAdicional : itemFaturaDTO.getServicosAdicionais()) {
            ServicoAdicional servicoAdicionalEncontrado = servicoAdicionalRepository.findById(servicoAdicional.getId())
                    .orElseThrow(() -> new RestNotFoundException(
                            "Serviço adicional não encontrado: " + servicoAdicional.getId()));
            servicosAdicionais.add(servicoAdicionalEncontrado);
        }

        log.info("cadastrando servicos: " + servicosAdicionais);
        itemFatura.setPlano(plano);
        itemFatura.setServicosAdicionais(servicosAdicionais);

        ItemFatura itemFaturaSalvo = itemFaturaRepository.save(itemFatura);
        ItemFaturaDTO itemFaturaSalvoDTO = new ItemFaturaDTO();
        BeanUtils.copyProperties(itemFaturaSalvo, itemFaturaSalvoDTO);
        return itemFaturaSalvoDTO;
    }


    private ItemFaturaDTO convertToDto(ItemFatura itemFatura) {
        ItemFaturaDTO itemFaturaDTO = new ItemFaturaDTO();
        itemFaturaDTO.setId(itemFatura.getId());
        itemFaturaDTO.setStatus(itemFatura.getStatus());
        itemFaturaDTO.setAdicionado(itemFatura.getAdicionado());
        itemFaturaDTO.setPlano(itemFatura.getPlano());
        itemFaturaDTO.setServicosAdicionais(itemFatura.getServicosAdicionais());
        return itemFaturaDTO;
    }


}
