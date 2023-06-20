package br.com.fiap.vocatalk.dto.requestDTO;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FaturaRequestDTO {

    @Schema(description = "Valor da fatura", example = "100.50")
    @NotNull(message = "O valor da fatura não pode ser nulo")
    @DecimalMin(value = "0.00", inclusive = true, message = "O valor da fatura deve ser igual ou maior que 0")
    @DecimalMax(value = "99999999.99", inclusive = true, message = "O valor da fatura não pode ser maior que 9999999999.99")
    private BigDecimal valor;

    @Schema(description = "Data de vencimento da fatura", example = "19/06/2023")
    @NotNull(message = "A data de vencimento da fatura não pode ser nula")
    private String dataVencimento;

    @Schema(description = "Data de pagamento da fatura", example = "15/06/2023")
    private String dataPagamento;

    @Schema(description = "ID do cliente", example = "1")
    @NotNull(message = "O ID do cliente não pode ser nulo")
    @Min(1)
    @Max(99999999)
    private Long cliente;

    @Schema(description = "ID do tipo de pagamento", example = "1")
    @NotNull(message = "O ID do tipo de pagamento não pode ser nulo")
    @Min(1)
    @Max(99999999)
    private Long tipoPagamento;

    @Schema(description = "Informações do item da fatura")
    @NotNull(message = "As informações do item da fatura não podem ser nulas")
    @Valid
    private ItemFaturaRequestDTO itemFatura;
}
