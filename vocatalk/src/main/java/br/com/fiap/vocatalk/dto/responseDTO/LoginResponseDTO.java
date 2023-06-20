package br.com.fiap.vocatalk.dto.responseDTO;

import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

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
public class LoginResponseDTO extends RepresentationModel<LoginResponseDTO> {

    @NotNull
    @Schema(description = "Id do login", example = "1")
    private Long id;

    @NotNull
    @Schema(description = "Email do cliente", example = "Luan.reis@yteste.com")
    private String email;

    @NotNull
    @Schema(description = "id do cliente", example = "1")
    private Long cliente;

    @NotNull
    @Schema(description = "Data do ultimo acesso do usuario", example = "2023-05-20T10:30:00")
    private LocalDateTime ultimoAcesso;

}
