package br.com.cartorio.mvc.cartorio.cartorio.dto;

import br.com.cartorio.mvc.cartorio.cartorio.model.Cartorio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RequisicaoNovoCartorioDTO {
    @NotBlank(message = "O nome é obrigatório")
    @Length(min = 3, max = 255, message = "O nome tem que ter entre 3 e 255 caracteres")
    private String nome;

    @NotBlank(message = "O endereco é obrigatório")
    @Length(min = 3, max = 255, message = "O endereco tem que ter entre 3 e 255 caracteres")
    private String endereco;

    @NotEmpty(message = "É necessário informar ao menos uma certidão")
    private List<String> certidoes = new ArrayList<>();

    public Cartorio toEntity() {
        Cartorio cartorio = new Cartorio();
        cartorio.setNome(this.nome);
        cartorio.setEndereco(this.endereco);
        cartorio.setCertidoes(this.certidoes);
        return cartorio;
    }
}
