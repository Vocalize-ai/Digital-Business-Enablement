package br.com.fiap.vocatalk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.vocatalk.repositories.PlanoRepository;
import br.com.fiap.vocatalk.repositories.ServicoAdicionalRepository;
import br.com.fiap.vocatalk.repositories.TipoPagamentoRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    TipoPagamentoRepository tipoPagamentoRepository;

    @Autowired
    PlanoRepository planoRepository;

    @Autowired
    ServicoAdicionalRepository servicoAdicionalRepository;

    @Override
    public void run(String... args) throws Exception {

    }

}
