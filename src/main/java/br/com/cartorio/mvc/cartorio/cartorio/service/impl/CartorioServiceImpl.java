package br.com.cartorio.mvc.cartorio.cartorio.service.impl;

import br.com.cartorio.mvc.cartorio.cartorio.dto.DadosListagemCartorioDTO;
import br.com.cartorio.mvc.cartorio.cartorio.dto.RequisicaoEdicaoCartorioDTO;
import br.com.cartorio.mvc.cartorio.cartorio.dto.RequisicaoNovoCartorioDTO;
import br.com.cartorio.mvc.cartorio.cartorio.model.Cartorio;
import br.com.cartorio.mvc.cartorio.cartorio.repository.CartorioRepository;
import br.com.cartorio.mvc.cartorio.cartorio.service.CartorioService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class CartorioServiceImpl implements CartorioService {

    private final CartorioRepository repository;

    @Override
    public void salvar(RequisicaoNovoCartorioDTO requisicao) {
        repository.save(requisicao.toEntity());
    }

    @Override
    public void atualizar(RequisicaoEdicaoCartorioDTO requisicao) {
        Cartorio cartorio = repository.findById(requisicao.id()).orElse(null);
        if (Objects.isNull(cartorio)) {
            throw new ServiceException("Cartório informado não cadastrado no banco");
        }
        cartorio.atualizarDados(requisicao);
        repository.save(cartorio);
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<DadosListagemCartorioDTO> buscarTodos(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemCartorioDTO::new);
    }

    @Override
    public RequisicaoEdicaoCartorioDTO buscarPorId(Long id) {
        Cartorio cartorio = repository.findById(id).orElse(null);
        if (Objects.isNull(cartorio)) {
            throw new ServiceException("Cartório informado não cadastrado no banco");
        }
        return new RequisicaoEdicaoCartorioDTO(cartorio);
    }
}
