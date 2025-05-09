package br.com.cartorio.mvc.cartorio.cartorio.dto;

import br.com.cartorio.mvc.cartorio.cartorio.model.Cartorio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record RequisicaoNovoCartorioDTO(
        @NotBlank(message = "O nome é obrigatório")
        @Length(min = 3, max = 255, message = "O nome tem que ter entre 3 e 255 caracteres")
        String nome,

        @NotBlank(message = "O endereco é obrigatório")
        @Length(min = 3, max = 255, message = "O endereco tem que ter entre 3 e 255 caracteres")
        String endereco,

        @NotEmpty(message = "É necessário informar ao menos uma certidão")
        List<String> certidoes
) {

    public Cartorio toEntity() {
        Cartorio cartorio = new Cartorio();
        cartorio.setNome(this.nome);
        cartorio.setEndereco(this.endereco);
        cartorio.setCertidoes(this.certidoes);
        return cartorio;
    }
}
