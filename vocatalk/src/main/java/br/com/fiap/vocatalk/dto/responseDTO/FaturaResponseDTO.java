package br.com.fiap.vocatalk.dto.responseDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FaturaResponseDTO extends RepresentationModel<FaturaResponseDTO> {

    @Schema(description = "Id da fatura")
    @NotNull
    private Long id;

    @Schema(description = "Valor da fatura")
    @NotNull
    private BigDecimal valor;

    @Schema(description = "Data de vencimento da fatura")
    @NotNull
    private LocalDateTime dataVencimento;

    @Schema(description = "Data de pagamento da fatura")
    private LocalDateTime dataPagamento;

    @Schema(description = "Id do cliente associado à fatura")
    @NotNull
    private Long cliente;

    @Schema(description = "Tipo de pagamento da fatura")
    @NotNull
    private TipoPagamentoResponseDTO tipoPagamento;

    @Schema(description = "Itens da fatura")
    @NotNull
    private ItemFaturaResponseDTO itemFatura;

    @Schema(description = "Mostra se já foi paga", example = "false")
    @NotNull
    private boolean faturado;

}
