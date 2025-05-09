package br.com.cartorio.mvc.cartorio.cartorio.service;

import br.com.cartorio.mvc.cartorio.cartorio.dto.RequisicaoEdicaoCartorioDTO;
import br.com.cartorio.mvc.cartorio.cartorio.dto.RequisicaoNovoCartorioDTO;
import jakarta.validation.Valid;

public interface CartorioService {
    void salvar(@Valid RequisicaoNovoCartorioDTO requisicao);

    void atualizar(@Valid RequisicaoEdicaoCartorioDTO requisicao);

    void deletar(Long id);
}
