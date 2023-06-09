package br.com.fiap.vocatalk.dto.responseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.RepresentationModel;

import br.com.fiap.vocatalk.models.ItemFatura;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemFaturaResponseDTO extends RepresentationModel<ItemFaturaResponseDTO> {

    @Schema(description = "Id do item da fatura")
    @NotNull
    private Long id;

    @Schema(description = "Status do item da fatura")
    private Character status;

    @Schema(description = "Data de adição do item da fatura")
    private LocalDateTime dataAdicionado;

    @Schema(description = "Plano associado ao item da fatura")
    @NotNull
    private PlanoResponseDTO plano;

    @Schema(description = "Lista de serviços adicionais associados ao item da fatura")
    private List<ServicoAdicionalResponseDTO> servicosAdicionais;

    @Schema(description = "Fatura associada ao item")
    @NotNull
    @Valid
    private FaturaResponseDTO fatura;

    public ItemFaturaResponseDTO(ItemFatura itemFatura) {
        this.id = itemFatura.getId();
        this.status = itemFatura.getStatus();
        this.dataAdicionado = itemFatura.getDataAdicionado();
        this.plano = new PlanoResponseDTO(itemFatura.getPlano());
        this.servicosAdicionais = itemFatura.getServicosAdicionais()
                .stream()
                .map(ServicoAdicionalResponseDTO::new)
                .collect(Collectors.toList());
        this.fatura = new FaturaResponseDTO(itemFatura.getFatura());
    }

}
