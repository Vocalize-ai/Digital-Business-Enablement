package br.com.fiap.vocatalk.dto.responseDTO;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
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
public class ServicoAdicionalResponseDTO extends RepresentationModel<ServicoAdicionalResponseDTO> {

    @Schema(description = "Id do plano")
    @NotNull
    private Long id;

    @Schema(description = "Nome do plano")
    @NotBlank
    @Size(max = 100)
    private String nome;

    @Schema(description = "Valor do plano")
    @NotNull
    private BigDecimal valor;

    @Schema(description = "Descrição do plano")
    private String descricao;

    @Schema(description = "Itens da fatura associados ao plano")
    @Valid
    private List<ItemFaturaResponseDTO> itensFatura;

}
