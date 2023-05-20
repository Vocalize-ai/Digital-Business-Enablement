package br.com.fiap.vocatalk.dto;

import java.math.BigDecimal;
import java.sql.Date;

import br.com.fiap.vocatalk.models.Cliente;
import br.com.fiap.vocatalk.models.TipoPagamento;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "O valor da fatura não pode ser nulo")
    private BigDecimal valor;

    @NotNull(message = "A data de vencimento da fatura não pode ser nulo")
    private Date dataVencimento;

    @NotNull(message = "A data de pagamento da fatura não pode ser nulo")
    private Date dataPagamento;

    private Cliente cliente;

    private TipoPagamento tipoPagamento;

}
