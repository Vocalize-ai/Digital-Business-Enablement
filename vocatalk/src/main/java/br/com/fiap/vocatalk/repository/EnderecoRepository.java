package br.com.fiap.vocatalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.vocatalk.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco,Long>{
    
}
