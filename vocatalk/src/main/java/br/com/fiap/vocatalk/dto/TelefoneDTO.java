package br.com.fiap.vocatalk.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TelefoneDTO {
    private Long id;
    private String ddd;
    private String telefone;
    private ClienteDTO cliente;

    // Construtores, getters e setters
}