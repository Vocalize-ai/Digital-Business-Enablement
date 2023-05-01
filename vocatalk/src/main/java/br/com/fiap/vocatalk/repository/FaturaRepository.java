package br.com.fiap.vocatalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.vocatalk.models.Fatura;

public interface FaturaRepository extends JpaRepository<Fatura,Long>{
    
}
