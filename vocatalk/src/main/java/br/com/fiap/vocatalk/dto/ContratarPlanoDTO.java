package br.com.fiap.vocatalk.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContratarPlanoDTO {

    private Long cliente;

    private Long plano;

    private Long tipoPagamento;

}
