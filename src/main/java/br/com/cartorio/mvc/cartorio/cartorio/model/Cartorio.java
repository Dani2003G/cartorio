package br.com.cartorio.mvc.cartorio.cartorio.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
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

}
