package br.com.fiap.vocatalk.dto.requestDTO;

import io.swagger.v3.oas.annotations.media.Schema;
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
public class TelefoneRequestDTO {

    @Schema(description = "DDD do telefone", example = "11")
    @NotNull(message = "O DDD do telefone não pode ser nulo")
    @Size(min = 2, max = 2, message = "O DDD deve ter 2 caracteres")
    private String ddd;

    @Schema(description = "Número de telefone", example = "999999999")
    @NotNull(message = "O número de telefone não pode ser nulo")
    @Size(min = 9, max = 9, message = "O número de telefone deve ter 9 caracteres")
    private String telefone;

}
