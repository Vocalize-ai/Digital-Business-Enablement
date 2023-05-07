package br.com.fiap.vocatalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.vocatalk.models.TelefoneContato;

public interface TelefoneContatoRepository extends JpaRepository<TelefoneContato,Long>{
    
}
