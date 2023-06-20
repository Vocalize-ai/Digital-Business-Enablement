package br.com.fiap.vocatalk.dto.requestDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class ServicoAdicionalRequestDTO {

    @Schema(description = "Id do servico adicional", example = "1")
    @NotNull(message = "O ID do Serviço adicional é obrigatório")
    @Min(0)
    @Max(99999999)
    private Long id;

}
