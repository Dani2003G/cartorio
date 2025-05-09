package br.com.cartorio.mvc.cartorio.cartorio.model;

import br.com.cartorio.mvc.cartorio.cartorio.dto.RequisicaoEdicaoCartorioDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Cartorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String endereco;

    @ManyToMany
    @JoinTable(
            name = "cartorio_certidao",
            joinColumns = @JoinColumn(name = "cartorio_id"),
            inverseJoinColumns = @JoinColumn(name = "certidao_id")
    )
    private List<Certidao> certidoes;

    public void atualizarDados(RequisicaoEdicaoCartorioDTO requisicao) {
        this.nome = requisicao.getNome();
        this.endereco = requisicao.getEndereco();
    }
}
