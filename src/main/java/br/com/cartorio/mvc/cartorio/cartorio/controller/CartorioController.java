package br.com.cartorio.mvc.cartorio.cartorio.controller;

import br.com.cartorio.mvc.cartorio.cartorio.dto.RequisicaoNovoCartorioDTO;
import br.com.cartorio.mvc.cartorio.cartorio.service.CartorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cartorio")
public class CartorioController {

    private final CartorioService service;

    @GetMapping
    public ModelAndView formulario(RequisicaoNovoCartorioDTO requisicao) {
        return new ModelAndView("/cartorio/formulario");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
