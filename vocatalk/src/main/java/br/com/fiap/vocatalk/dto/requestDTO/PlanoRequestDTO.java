package br.com.fiap.vocatalk.dto.requestDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.vocatalk.models.ItemFatura;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class PlanoRequestDTO {

    @Schema(description = "Nome do plano", example = "Plano Básico")
    @NotBlank(message = "O nome do plano não pode estar em branco")
    @Size(max = 100, message = "O nome do plano deve ter no máximo 100 caracteres")
    private String nome;

    @Schema(description = "Quantidade de minutos", example = "1000")
    @Min(0)
    @Max(99999)
    private Integer quantidadeMinutos;

    @Schema(description = "Quantidade de internet (em MB)", example = "5000")
    @Min(0)
    @Max(99999)
    private Integer quantidadeInternet;

    @Schema(description = "Valor mensal do plano", example = "99.90")
    @NotNull(message = "O valor mensal do plano não pode ser nulo")
    @DecimalMin(value = "0.00", inclusive = true, message = "O valor mensal do plano deve ser igual ou maior que 0")
    @DecimalMax(value = "99999999.99", inclusive = true, message = "O valor mensal do plano não pode ser maior que 9999.99")
    private BigDecimal valorMensal;

    @Schema(description = "Itens da fatura associados ao plano")
    private List<ItemFatura> itemFatura = new ArrayList<>();

    @Schema(description = "Descrição do plano", example = "Plano com minutos ilimitados e 5GB de internet")
    @Size(max = 60, message = "O tamanho da descrição não deve ser maior 60 caracteres")
    private String descricao;

}
