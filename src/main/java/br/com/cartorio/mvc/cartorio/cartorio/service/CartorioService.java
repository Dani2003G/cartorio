package br.com.cartorio.mvc.cartorio.cartorio.service;

import br.com.cartorio.mvc.cartorio.cartorio.dto.DadosListagemCartorioDTO;
import br.com.cartorio.mvc.cartorio.cartorio.dto.RequisicaoEdicaoCartorioDTO;
import br.com.cartorio.mvc.cartorio.cartorio.dto.RequisicaoNovoCartorioDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CartorioService {
    void salvar(@Valid RequisicaoNovoCartorioDTO requisicao);

    void atualizar(@Valid RequisicaoEdicaoCartorioDTO requisicao);

    void deletar(Long id);

    Page<DadosListagemCartorioDTO> buscarTodos(Pageable paginacao);

    RequisicaoEdicaoCartorioDTO buscarPorId(Long id);
}
