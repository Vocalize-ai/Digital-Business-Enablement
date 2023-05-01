package br.com.fiap.vocatalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.vocatalk.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
