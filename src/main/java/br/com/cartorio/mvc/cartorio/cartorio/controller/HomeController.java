package br.com.cartorio.mvc.cartorio.cartorio.controller;

import br.com.cartorio.mvc.cartorio.cartorio.service.CartorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    private final CartorioService cartorioService;

    @GetMapping
    public ModelAndView home(@PageableDefault Pageable paginacao) {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("pagina", cartorioService.buscarTodos(paginacao));
        return mv;
    }

}
