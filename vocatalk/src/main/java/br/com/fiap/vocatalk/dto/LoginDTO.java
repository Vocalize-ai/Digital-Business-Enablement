package br.com.fiap.vocatalk.dto;

import java.time.LocalDateTime;

import br.com.fiap.vocatalk.models.Cliente;
import br.com.fiap.vocatalk.models.Login;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    private Long id;

    private String email;

    private LocalDateTime ultimoLogin;

    private Cliente cliente;

    public LoginDTO(Login login) {
        this.id = login.getId();
        this.email = login.getEmail();
        this.ultimoLogin = login.getUltimoLogin();
        this.cliente = login.getCliente();
    }

}
