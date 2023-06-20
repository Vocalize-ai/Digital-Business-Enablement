package br.com.fiap.vocatalk.dto.responseDTO;

import org.springframework.hateoas.RepresentationModel;

import br.com.fiap.vocatalk.models.TipoPagamento;
import io.swagger.v3.oas.annotations.media.Schema;
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
public class TipoPagamentoResponseDTO extends RepresentationModel<TipoPagamentoResponseDTO> {

    @Schema(description = "Id do tipo de pagamento")
    @NotNull
    private Long id;

    @Schema(description = "Nome do tipo de pagamento")
    @NotBlank
    @Size(max = 100)
    private String nome;

    @Schema(description = "Descrição do nome do tipo de pagamento")
    private String descricao;

    public TipoPagamentoResponseDTO(TipoPagamento tipoPagamento) {
        this.id = tipoPagamento.getId();
        this.nome = tipoPagamento.getNome();
        this.descricao = tipoPagamento.getDescricao();
    }

}
