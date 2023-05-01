package br.com.fiap.vocatalk.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="v_vt_login")
public class Login {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_login")
    private Long id;

    @NotBlank(message = "O e-mail tem que ser preenchido")
    @Email
    @Column(name = "ds_email", unique = true)
    private String email;

    @NotBlank(message = "A senha tem que ser preenchida")
    @Size(min = 8,max=20)
    @Column(name="ds_senha")
    private String senha;

    @NotNull(message = "A data não pode ser nula")
    @Column(name="dt_ultimo_login")
    @Temporal(TemporalType.DATE)
    private Date ultimoLogin;

}
