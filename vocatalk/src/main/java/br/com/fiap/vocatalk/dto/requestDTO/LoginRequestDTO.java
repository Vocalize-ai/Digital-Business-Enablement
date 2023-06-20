package br.com.fiap.vocatalk.dto.requestDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {

    @Schema(description = "Email", example = "Luan.Reis@yteste.com")
    @NotNull(message = "O email não pode ser nulo")
    @Size(max = 80, message = "O email não pode ter mais de 80 caractares")
    private String email;

    @NotNull(message = "O ID do cliente não pode ser nulo")
    @Schema(description = "ID do cliente", example = "1")
    @Min(1)
    @Max(99999999)
    private Long cliente;

    @NotNull(message = "A senha não pode ser nula")
    @Schema(description = "Senha do usuário", example = "Batatinha123@")
    private String senha;

}
