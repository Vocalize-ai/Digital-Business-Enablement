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
@Table(name = "t_vt_tipo_pagamento")
public class TipoPagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tipo_pagamento")
    private Long id;

    @Size(min = 2, max = 50)
    @NotBlank(message = "O nome do tipo de pagamento tem que ser preenchido")
    @Column(name = "nm_tipo_pagamento")
    private String nome;

    @Size(min = 0, max = 80)
    @Column(name = "ds_tipo_pagamento")
    private String descricao;
}
