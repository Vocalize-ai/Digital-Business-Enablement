package br.com.fiap.vocatalk.models;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_VT_PLANO")
public class Plano implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plano")
    private Long id;

    @Size(min = 5, max = 40)
    @NotBlank(message = "O nome do plano tem que ser preenchido")
    @Column(name = "nm_plano")
    private String nome;

    @NotNull(message = "A quantidade de minutos não pode ser nula")
    @Column(name = "qtd_franquia_minutos")
    @Max(value = 99999)
    @Min(value = 0)
    private int qtdMinutos;

    @NotNull(message = "A quantidade de internet não pode ser nula")
    @Column(name = "qtd_franquia_internet")
    @Max(value = 9999)
    @Min(value = 0)
    private int qtdInternet;

    @NotNull(message = "O valor mensal não pode ser nulo")
    @Column(name = "vlr_mensal", precision = 10, scale = 2)
    private BigDecimal valorMensal;

    // @JsonIgnore
    // @OneToMany(mappedBy = "plano")
    // private List<ItemFatura> itemFatura;

    @Size(min = 0, max = 60)
    @Column(name = "ds_plano")
    private String descricao;

    public Plano(@Size(min = 5, max = 40) @NotBlank(message = "O nome do plano tem que ser preenchido") String nome,
            @NotNull(message = "A quantidade de minutos não pode ser nula") @Max(99999) @Min(0) int qtdMinutos,
            @NotNull(message = "A quantidade de internet não pode ser nula") @Max(9999) @Min(0) int qtdInternet,
            @NotNull(message = "O valor mensal não pode ser nulo") BigDecimal valorMensal,
            @Size(min = 0, max = 60) String descricao) {
        this.nome = nome;
        this.qtdMinutos = qtdMinutos;
        this.qtdInternet = qtdInternet;
        this.valorMensal = valorMensal;
        this.descricao = descricao;
    }
}
