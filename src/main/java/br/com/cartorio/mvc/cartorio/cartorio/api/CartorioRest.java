package br.com.cartorio.mvc.cartorio.cartorio.api;

import br.com.cartorio.mvc.cartorio.cartorio.dto.DadosListagemCartorioDTO;
import br.com.cartorio.mvc.cartorio.cartorio.dto.RequisicaoEdicaoCartorioDTO;
import br.com.cartorio.mvc.cartorio.cartorio.dto.RequisicaoNovoCartorioDTO;
import br.com.cartorio.mvc.cartorio.cartorio.service.CartorioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cartorio")
public class CartorioRest {

    private final CartorioService service;

    @GetMapping
    public ResponseEntity<Page<DadosListagemCartorioDTO>> buscarCartorios(@PageableDefault Pageable paginacao) {
        return ResponseEntity.ok(service.buscarTodos(paginacao));
    }

    @PostMapping
    public ResponseEntity novo(@RequestBody @Valid RequisicaoNovoCartorioDTO requisicao) {
        service.salvar(requisicao);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid RequisicaoEdicaoCartorioDTO requisicao) {
        service.atualizar(requisicao);
        return ResponseEntity.ok(requisicao);
    }

    @DeleteMapping
    public ResponseEntity deletar(@RequestParam Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscarPorId")
    public ResponseEntity buscarPorId(@RequestParam Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

}
