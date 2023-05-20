package br.com.fiap.vocatalk.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FaturaDTO {

    private Long id;

    private BigDecimal valor;

    private LocalDateTime dataVencimento;

    private LocalDateTime dataPagamento;

    private ClienteDTO cliente;

    private TipoPagamentoDTO tipoPagamento;

    private ItemFaturaDTO itemFatura;

}
