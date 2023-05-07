package br.com.fiap.vocatalk.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_vt_endereco")
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_endereco")
    private Long id;
    
    @Size(min = 3, max=80)
    @NotBlank(message = "O logradouro tem que ser preenchido")
    @Column(name="nm_logradouro")
    private String logradouro;

    @Max(value = 9999)
    @Min(value = 0, message ="O número tem que ser positivo")
    @NotNull
    @Column(name="nr_logradouro")
    private int numero;

    @Size(min=0, max=40)
    @Column(name="ds_complemento")
    private String complemento;
    
    @NotBlank(message = "O bairro tem que ser preenchido")
    @Size(min=2, max=40)
    @Column(name="nm_bairro")
    private String bairro;

    @NotBlank(message = "A cidade tem que ser preenchido")
    @Size(min=2, max=80)
    @Column(name="nm_cidade")
    private String cidade;

    @NotBlank(message = "O Estado tem que ser preenchido")
    @Size(min=2, max=80)
    @Column(name="nm_estado")
    private String estado;

    @Size(min=0, max=8)
    @Column(name="ds_cep")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    Cliente cliente;
}
