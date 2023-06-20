package br.com.fiap.vocatalk.dto.responseDTO;

import org.springframework.hateoas.RepresentationModel;

import br.com.fiap.vocatalk.models.Telefone;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TelefoneResponseDTO extends RepresentationModel<TelefoneResponseDTO> {

    @NotNull
    @Schema(description = "ID do telefone", example = "1")
    private Long id;

    @NotNull
    @Schema(description = "DDD do telefone", example = "11")
    private String ddd;

    @NotNull
    @Schema(description = "Número de telefone", example = "999999999")
    private String telefone;



    public TelefoneResponseDTO(Telefone telefone){
        this.id = telefone.getId();
        this.ddd = telefone.getDdd();
        this.telefone = telefone.getTelefone();
    }
}
