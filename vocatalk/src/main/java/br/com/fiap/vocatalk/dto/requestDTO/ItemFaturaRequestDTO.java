package br.com.fiap.vocatalk.dto.requestDTO;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
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
public class ItemFaturaRequestDTO {

    @Schema(description = "ID do plano")
    @NotNull(message = "O ID do plano não pode ser nulo")
    @Min(1)
    @Max(99999999)
    private Long plano;

    @Schema(description = "Lista de serviços adicionais")
    @Valid
    private List<ServicoAdicionalRequestDTO> servicosAdicionais = new ArrayList<>();

}
