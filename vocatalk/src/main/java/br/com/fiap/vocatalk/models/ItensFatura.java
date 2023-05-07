package br.com.fiap.vocatalk.models;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="t_vt_itens_fatura")
public class ItensFatura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_itens_fatura")
    private Long id;

    @Size(min = 1, max = 1)
    @NotBlank(message = "O status do itens da fatura de ser preenchido")
    @Column(name="st_plano")
    private char status;

    @NotNull(message = "A data não pode ser nula")
    @Column(name="dt_item_adicionado")
    @Temporal(TemporalType.DATE)
    private Date adicionado;

    @ManyToAny
    @JoinColumn(name = "id_plano", nullable = false)
    private Plano plano;

    @ManyToAny
    @JoinColumn(name = "id_servico_adicional")
    private ServicoAdicional servicoAdicional;

    @OneToMany(mappedBy = "itensFatura")
    private List<Fatura> faturas;
}
