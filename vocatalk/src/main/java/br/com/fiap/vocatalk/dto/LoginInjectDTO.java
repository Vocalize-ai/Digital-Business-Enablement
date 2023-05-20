package br.com.fiap.vocatalk.dto;

import java.time.LocalDateTime;

import br.com.fiap.vocatalk.models.Cliente;
import br.com.fiap.vocatalk.models.Login;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInjectDTO {

    private Long id;

    @NotBlank(message = "O e-mail tem que ser preenchido")
    @Email
    private String email;

    @NotBlank(message = "A senha tem que ser preenchida")
    @Size(min = 8)
    private String senha;

    private LocalDateTime ultimoLogin;

    private Cliente cliente;

    public LoginInjectDTO(Login login) {
        this.id = login.getId();
        this.email = login.getEmail();
        this.senha = login.getSenha();
        this.ultimoLogin = login.getUltimoLogin();
        this.cliente = login.getCliente();
    }
    
}
