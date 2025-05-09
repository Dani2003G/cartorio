package br.com.cartorio.mvc.cartorio.cartorio.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Certidao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "certidoes")
    private Set<Cartorio> cartorios;

}
