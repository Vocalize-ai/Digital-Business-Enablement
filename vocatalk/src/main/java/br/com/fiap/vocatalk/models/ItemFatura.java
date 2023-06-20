package br.com.fiap.vocatalk.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_vt_itens_fatura")
public class ItemFatura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_itens_fatura")
    private Long id;

    @NotNull(message = "A data não pode ser nula")
    @Column(name = "dt_item_adicionado")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataAdicionado;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_plano")
    private Plano plano;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "t_vt_itens_fat_serv_add", joinColumns = @JoinColumn(name = "id_item_fatura"), inverseJoinColumns = @JoinColumn(name = "id_servico_adicional"))
    private List<ServicoAdicional> servicosAdicionais;

    @OneToOne(mappedBy = "itemFatura")
    private Fatura fatura;

    @Override
    public String toString() {
        return "ItemFatura [id=" + id + ", status=" + ", dataAdicionado=" + dataAdicionado + "]";
    }

}
