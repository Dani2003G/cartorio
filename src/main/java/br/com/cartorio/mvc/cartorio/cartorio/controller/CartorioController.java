package br.com.cartorio.mvc.cartorio.cartorio.controller;

import br.com.cartorio.mvc.cartorio.cartorio.dto.RequisicaoNovoCartorioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cartorio")
public class CartorioController {

    @GetMapping
    public ModelAndView formulario(RequisicaoNovoCartorioDTO requisicao) {
        return new ModelAndView("/cartorio/formulario");
    }

}
