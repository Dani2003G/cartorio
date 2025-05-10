package br.com.cartorio.mvc.cartorio.cartorio.controller;

import br.com.cartorio.mvc.cartorio.cartorio.dto.RequisicaoEdicaoCartorioDTO;
import br.com.cartorio.mvc.cartorio.cartorio.dto.RequisicaoNovoCartorioDTO;
import br.com.cartorio.mvc.cartorio.cartorio.service.CartorioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cartorio")
public class CartorioController {

    private final CartorioService service;

    @GetMapping("/formularioNovo")
    public ModelAndView formularioNovo() {
        ModelAndView mv = new ModelAndView("/cartorio/formularioNovo");
        mv.addObject("cartorio", new RequisicaoNovoCartorioDTO());
        return mv;
    }

    @PostMapping("/novo")
    public ModelAndView cadastrar(@Valid @ModelAttribute("cartorio") RequisicaoNovoCartorioDTO requisicao, BindingResult result) {
        ModelAndView mv = new ModelAndView("redirect:/home");
        if (result.hasErrors()) {
            mv = new ModelAndView("/cartorio/formularioNovo");
            mv.addObject("cartorio", requisicao);
        } else {
            service.salvar(requisicao);
        }
        return mv;
    }

    @GetMapping("/formularioEdicao/{id}")
    public ModelAndView formularioEdicao(RequisicaoEdicaoCartorioDTO requisicao, @PathVariable Long id) {
        ModelAndView mv = new ModelAndView("/cartorio/formularioEdicao");
        mv.addObject("cartorio", service.buscarPorId(id));
        return mv;
    }

    @PutMapping("/atualizar")
    public ModelAndView atualizar(@Valid @ModelAttribute("cartorio") RequisicaoEdicaoCartorioDTO requisicao, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/cartorio/formularioEdicao");
            mv.addObject("cartorio", requisicao);
            return mv;
        }
        service.atualizar(requisicao);
        return new ModelAndView("redirect:/home");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
