package br.com.fiap.vocatalk.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
@Table(name = "t_vt_telefone_contato")
public class Telefone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefone_contato")
    private Long id;

    @Size(min = 2, max = 2)
    @NotBlank(message = "O ddd dever tem que ser preenchido")
    @Column(name = "nr_ddd")
    private String ddd;

    @Size(min = 8, max = 10)
    @NotBlank(message = "O telefone tem que ser preenchida")
    @Column(name = "nr_telefone", unique = true)
    private String telefone;

    @OneToOne(mappedBy = "telefoneContato")
    private Cliente cliente;

    @Override
    public String toString() {
        return "Telefone [id=" + id + ", numero=" + telefone + "]";
    }

}
