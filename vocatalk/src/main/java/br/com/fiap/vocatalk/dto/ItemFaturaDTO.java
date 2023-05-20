package br.com.fiap.vocatalk.dto;

import java.util.Date;
import java.util.List;

import br.com.fiap.vocatalk.models.Plano;
import br.com.fiap.vocatalk.models.ServicoAdicional;
import jakarta.validation.constraints.NotNull;
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
public class ItemFaturaDTO {

    private Long id;

    @NotNull(message = "O status do item da fatura não pode ser nulo")
    private Character status;

    @NotNull(message = "A data não pode ser nula")
    private Date adicionado;

    private Plano plano;

    private List<ServicoAdicional> servicosAdicionais;

}
