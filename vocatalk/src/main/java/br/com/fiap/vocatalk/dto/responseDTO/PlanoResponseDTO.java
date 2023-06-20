package br.com.fiap.vocatalk.dto.responseDTO;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlanoResponseDTO extends RepresentationModel<PlanoResponseDTO> {

    @Schema(description = "Id do plano")
    @NotNull
    private Long id;

    @Schema(description = "Nome do plano")
    @NotBlank
    @Size(max = 100)
    private String nome;

    @Schema(description = "Quantidade de minutos do plano")
    @Min(0)
    private int quantidadeMinutos;

    @Schema(description = "Quantidade de internet do plano")
    @Min(0)
    private int quantidadeInternet;

    @Schema(description = "Valor mensal do plano")
    @NotNull
    private BigDecimal valorMensal;
}
