package br.com.fiap.vocatalk.models;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Table(name="t_vt_cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Long id;

    @NotBlank(message = "O nome tem que ser preenchido")
    @Size(min = 0, max= 120)
    @Column(name="nm_cliente")
    private String nome;

    @NotBlank(message = "O cpf tem que ser preenchido")
    @Size(min=11, max= 11)
    @Column(name="nr_cpf", unique = true)
    private String cpf;
    
    @NotNull(message = "A data não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name="dt_cadastro")
    private Date dataCadastro;

    @OneToOne(mappedBy = "cliente")
    private Login login;

    @OneToMany(mappedBy = "cliente")
    private List<Fatura> fatura = new ArrayList<Fatura>();

    @OneToOne(mappedBy = "cliente")
    private Telefone telefoneContato;
}
