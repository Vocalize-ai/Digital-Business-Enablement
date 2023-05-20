package br.com.fiap.vocatalk.dto;

import java.time.LocalDateTime;

import br.com.fiap.vocatalk.models.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteDTO {

    private Long id;

    private String nome;

    private String cpf;

    private LocalDateTime dataCadastro;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.dataCadastro = cliente.getDataCadastro();
    }

    @Override
    public String toString() {
        return "ClienteDTO [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dataCadastro=" + dataCadastro + "]";
    }



    

    

}