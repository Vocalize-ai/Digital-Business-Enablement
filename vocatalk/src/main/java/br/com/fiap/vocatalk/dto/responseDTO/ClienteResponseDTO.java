package br.com.fiap.vocatalk.dto.responseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteResponseDTO extends RepresentationModel<ClienteResponseDTO> {

    @Schema(description = "Id do cliente", example = "1")
    private Long id;

    @Schema(description = "Nome do cliente", example = "Luan Reis")
    private String nome;

    @Schema(description = "CPF do cliente", example = "44488877799")
    private String cpf;

    @Schema(description = "Email do cliente", example = "luan.reis@fiap.com.br")
    private String email;

    @Schema(description = "Uma lista de faturas")
    private List<FaturaResponseDTO> fatura = new ArrayList<FaturaResponseDTO>();

    @Schema(description = "Telefone desse cliente")
    private TelefoneResponseDTO telefone;

    @Schema(description = "Data do cadastro desse cliente", example = "2023-05-25T15:45:00")
    private LocalDateTime dataCadastro;

    @Override
    public String toString() {
        return "ClienteResponseDao [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dataCadastro=" + dataCadastro
                + ", email=" + email + ", fatura=" + fatura + ", telefone=" + telefone + "]";
    }

}
