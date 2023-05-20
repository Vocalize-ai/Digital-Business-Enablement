package br.com.fiap.vocatalk.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.fiap.vocatalk.models.ItemFatura;
import br.com.fiap.vocatalk.models.Plano;
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
public class PlanoDTO {

    private Long id;

    private String nome;

    private int qtdMinutos;

    private int qtdInternet;

    private BigDecimal valorMensal;

    private List<ItemFatura> itemFatura;

    private String descricao;

    public PlanoDTO(Plano plano) {
        this.nome = plano.getNome();
        this.qtdMinutos = plano.getQtdMinutos();
        this.qtdInternet = plano.getQtdInternet();
        this.valorMensal = plano.getValorMensal();
        this.descricao = plano.getDescricao();
    }



    

}
