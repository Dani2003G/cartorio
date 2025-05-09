package br.com.cartorio.mvc.cartorio.cartorio.repository;

import br.com.cartorio.mvc.cartorio.cartorio.model.Cartorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartorioRepository extends JpaRepository<Cartorio, Long> {

}
