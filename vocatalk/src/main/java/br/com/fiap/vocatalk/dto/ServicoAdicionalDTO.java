package br.com.fiap.vocatalk.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.fiap.vocatalk.models.ItemFatura;
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
public class ServicoAdicionalDTO {

    private Long id;

    @Size(min = 5, max = 40)
    @NotBlank(message = "O nome do serviço adicional tem que ser preenchido")
    private String nome;

    @NotNull(message = "O valor não pode ser nulo")
    private BigDecimal valor;

    @NotBlank(message = "A descrição do serviço adicional tem que ser preenchida")
    @Size(min = 10, max = 60)
    private String descricao;

    private List<ItemFatura> itensFatura;

}
