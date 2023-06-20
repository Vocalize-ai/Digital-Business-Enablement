package br.com.fiap.vocatalk.dto.requestDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContratarRequestPlanoDTO {

    @Schema(description = "ID do cliente", example = "1")
    @NotNull(message = "O numero do ID do cliente é obrigatório")
    @Min(1)
    @Max(99999999)
    private Long cliente;

    @Schema(description = "ID do plano", example = "1")
    @NotNull(message = "O número do ID do plano é obrigatório")
    @Min(1)
    @Max(99999999)
    private Long plano;

    @Schema(description = "ID do tipo de pagamento", example = "1")
    @NotNull(message = "O número do ID do tipoPagamento é obrigatório")
    @Min(1)
    @Max(99999999)
    private Long tipoPagamento;

}
