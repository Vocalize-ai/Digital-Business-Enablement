package br.com.fiap.vocatalk.models;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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
@Table(name = "T_VT_SERVICO_ADICIONAL")

public class ServicoAdicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servico_adicional")
    private Long id;

    @Size(min = 5, max = 40)
    @NotBlank(message = "O nome do serviço adicional tem que ser preenchido")
    @Column(name = "nm_servico")
    private String nome;

    @NotNull(message = "O valor não pode ser nulo")
    @Column(name = "vlr_servico", precision = 10, scale = 2)
    private BigDecimal valor;

    @NotBlank(message = "A descrição do serviço adicional tem que ser preenchida")
    @Size(min = 10, max = 60)
    @Column(name = "ds_servico_adional")
    private String descricao;

    @ManyToMany(mappedBy = "servicosAdicionais")
    private List<ItemFatura> itensFatura;

}
