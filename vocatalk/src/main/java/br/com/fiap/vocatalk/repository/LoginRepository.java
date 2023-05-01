package br.com.fiap.vocatalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.vocatalk.models.Login;

public interface LoginRepository extends JpaRepository<Login,Long>{

}
