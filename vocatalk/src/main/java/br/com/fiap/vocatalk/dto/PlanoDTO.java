package br.com.fiap.vocatalk.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.fiap.vocatalk.models.ItemFatura;
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
public class PlanoDTO {

    private Long id;

    @Size(min = 5, max = 40)
    @NotBlank(message = "O nome do plano tem que ser preenchido")
    private String nome;

    @NotNull(message = "A quantidade de minutos não pode ser nula")
    @Max(value = 99999)
    @Min(value = 0)
    private int qtdMinutos;

    @NotNull(message = "A quantidade de internet não pode ser nula")
    @Max(value = 9999)
    @Min(value = 0)
    private int qtdInternet;

    @NotNull(message = "O valor mensal não pode ser nulo")
    private BigDecimal valorMensal;

    private List<ItemFatura> itemFatura;

    @Size(min = 0, max = 60)
    private String descricao;

}
