package br.com.fiap.vocatalk.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="t_vt_telefone_contato")
public class Telefone {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_telefone_contato")
    private Long id;

    @Size(min = 2, max = 2)
    @NotBlank(message = "O ddd dever tem que ser preenchido")
    @Column(name="nr_ddd")
    private String ddd;

    @Size(min = 8, max = 10)
    @NotBlank(message = "O telefone tem que ser preenchida")
    @Column(name="nr_telefone",unique = true)
    private String telefone;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
}
