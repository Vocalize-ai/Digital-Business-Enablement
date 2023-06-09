package br.com.fiap.vocatalk.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_vt_fatura")
public class Fatura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fatura")
    private Long id;

    @NotNull(message = "O valor da fatura não pode ser nulo")
    @Column(name = "vlr_fatura", precision = 10, scale = 2)
    private BigDecimal valor;

    @NotNull(message = "A data de vencimento da fatura não pode ser nulo")
    @Column(name = "dt_vencimento")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataVencimento;

    @Column(name = "dt_pagamento")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataPagamento;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pagamento")
    private TipoPagamento tipoPagamento;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_itens_fatura")
    private ItemFatura itemFatura;

    @Override
    public String toString() {
        return "Fatura [id=" + id + ", valor=" + valor + ", dataVencimento=" + dataVencimento + ", dataPagamento="
                + dataPagamento + "]";
    }
}
