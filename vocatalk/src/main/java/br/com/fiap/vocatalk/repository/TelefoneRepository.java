package br.com.fiap.vocatalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.vocatalk.models.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone,Long>{
    
}
