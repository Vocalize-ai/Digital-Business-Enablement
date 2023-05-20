package br.com.fiap.vocatalk.dto;
import java.io.Serializable;

import br.com.fiap.vocatalk.models.TipoPagamento;
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
public class TipoPagamentoDTO implements Serializable {

    private Long id;

    private String nome;

    public TipoPagamentoDTO(TipoPagamento tipoPagamento) {
        this.id = tipoPagamento.getId();
        this.nome = tipoPagamento.getNome();
    }

}
