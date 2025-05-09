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

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String endereco;

    @ElementCollection
    private List<String> certidoes;

    public void atualizarDados(RequisicaoEdicaoCartorioDTO requisicao) {
        this.nome = requisicao.nome();
        this.endereco = requisicao.endereco();
    }
}
