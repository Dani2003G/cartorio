package br.com.cartorio.mvc.cartorio.cartorio.dto;

import br.com.cartorio.mvc.cartorio.cartorio.model.Cartorio;

import java.util.List;

public record DadosListagemCartorioDTO(
        Long id,
        String nome,
        String endereco,
        List<String> certidoes
) {

    public DadosListagemCartorioDTO (Cartorio cartorio) {
        this(cartorio.getId(), cartorio.getNome(), cartorio.getEndereco(), cartorio.getCertidoes());
    }
}
