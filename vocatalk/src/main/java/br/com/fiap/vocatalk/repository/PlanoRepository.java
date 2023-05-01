package br.com.fiap.vocatalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.vocatalk.models.Plano;

public interface PlanoRepository extends JpaRepository<Plano,Long>{
    
}
