package br.com.fiap.vocatalk.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.vocatalk.dto.requestDTO.ClienteRequestDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "t_vt_cliente", uniqueConstraints = @UniqueConstraint(columnNames = "nr_cpf"))
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @NotBlank(message = "O nome tem que ser preenchido")
    @Size(min = 0, max = 120)
    @Column(name = "nm_cliente")
    private String nome;

    @NotBlank(message = "O cpf tem que ser preenchido")
    @Size(min = 11, max = 11)
    @Column(name = "nr_cpf", unique = true)
    private String cpf;

    @NotNull(message = "A data não pode ser nula")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_cadastro")
    private LocalDateTime dataCadastro;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Login login;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Fatura> fatura = new ArrayList<Fatura>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_telefone_contato")
    private Telefone telefone;

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dataCadastro=" + dataCadastro
                + ", telefoneContato=" + telefone + "]";
    }

    public Cliente(ClienteRequestDTO cliente) {
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.telefone = new Telefone(cliente.getTelefone());
    }

}
