package br.com.fiap.vocatalk.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.fiap.vocatalk.models.ItemFatura;
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
public class ServicoAdicionalDTO {

    private Long id;

    private String nome;

    private BigDecimal valor;

    private String descricao;

    private List<ItemFatura> itensFatura;

}
