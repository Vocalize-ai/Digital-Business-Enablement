package br.com.fiap.vocatalk.dto.responseDTO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.fiap.vocatalk.controllers.ClienteController;
// import br.com.fiap.vocatalk.controllers.FaturaController;
import br.com.fiap.vocatalk.models.Cliente;
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
    @JsonInclude(Include.NON_NULL)
    private String email;

    @Schema(description = "Telefone desse cliente")
    private TelefoneResponseDTO telefone;

    @Schema(description = "Data do cadastro desse cliente", example = "2023-05-25T15:45:00")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCadastro;

    @Schema(description = "Uma lista de faturas")
    private List<FaturaResponseDTO> faturas = new ArrayList<FaturaResponseDTO>();

    public ClienteResponseDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getLogin() != null ? cliente.getLogin().getEmail() : null;
        this.telefone = new TelefoneResponseDTO(cliente.getTelefone());
        this.dataCadastro = cliente.getDataCadastro();
        this.faturas = cliente.getFatura().stream()
                .map(FaturaResponseDTO::new)
                .collect(Collectors.toList());
        addSelfLink();
        addTodosLink();
    }

    // Métodos para adicionar links
    private void addSelfLink() {
        Link selfLink = linkTo(methodOn(ClienteController.class).buscarPorId(this.id)).withSelfRel();
        this.add(selfLink);
    }

    private void addTodosLink() {
        Link todosLink = linkTo(methodOn(ClienteController.class).buscarTodos(Pageable.unpaged()))
                .withRel("all");
        this.add(todosLink);
    }

    @Override
    public String toString() {
        return "ClienteResponseDao [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dataCadastro=" + dataCadastro
                + ", email=" + email + ", fatura=" + faturas + ", telefone=" + telefone + "]";
    }

}
