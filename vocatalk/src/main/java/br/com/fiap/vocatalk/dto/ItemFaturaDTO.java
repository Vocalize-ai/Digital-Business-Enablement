package br.com.fiap.vocatalk.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.vocatalk.models.ItemFatura;
import br.com.fiap.vocatalk.models.Plano;
import br.com.fiap.vocatalk.models.ServicoAdicional;
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

    private Character status;

    private LocalDateTime adicionado;

    private Plano plano;

    private List<ServicoAdicional> servicosAdicionais = new ArrayList<>();

    public ItemFaturaDTO(ItemFatura itemFatura) {
        this.id = itemFatura.getId();
        this.status = itemFatura.getStatus();
        this.adicionado = itemFatura.getAdicionado();
        this.plano = itemFatura.getPlano();
        this.servicosAdicionais = itemFatura.getServicosAdicionais();
    }




    

}
