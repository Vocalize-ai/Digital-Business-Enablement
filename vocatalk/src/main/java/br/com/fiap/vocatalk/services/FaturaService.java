package br.com.fiap.vocatalk.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.vocatalk.dto.FaturaDTO;
import br.com.fiap.vocatalk.models.Fatura;
import br.com.fiap.vocatalk.repositories.FaturaRepository;

@Service
public class FaturaService {

    private final FaturaRepository faturaRepository;

    @Autowired
    public FaturaService(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    public FaturaDTO criarFatura(FaturaDTO faturaDTO) {
        Fatura fatura = new Fatura();
        BeanUtils.copyProperties(faturaDTO, fatura);
        Fatura faturaSalva = faturaRepository.save(fatura);
        FaturaDTO faturaSalvaDTO = new FaturaDTO();
        BeanUtils.copyProperties(faturaSalva, faturaSalvaDTO);
        return faturaSalvaDTO;
    }


}
