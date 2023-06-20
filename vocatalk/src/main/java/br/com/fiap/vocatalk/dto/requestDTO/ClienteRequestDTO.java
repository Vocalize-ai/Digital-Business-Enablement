package br.com.fiap.vocatalk.dto.requestDTO;

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
public class ClienteRequestDTO {

    @Schema(description = "Nome do cliente", example = "Luan Reis")
    @NotBlank
    @Size(max = 100, message = "100 caracteres no máximo para o nome")
    private String nome;

    @Schema(description = "CPF do cliente", example = "4458745878")
    @NotBlank
    @Size(max = 11, min = 11, message = "O CPF deve ter 11 caracteres")
    private String cpf;

    @Schema(description = "Telefone")
    @NotNull(message = "Telefone não pode ser nulo")
    @Valid
    private TelefoneRequestDTO telefone;


}
