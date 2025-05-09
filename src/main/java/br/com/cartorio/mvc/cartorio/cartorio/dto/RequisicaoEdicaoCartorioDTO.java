package br.com.cartorio.mvc.cartorio.cartorio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record RequisicaoEdicaoCartorioDTO(
        @NotNull(message = "O id é obrigatório")
        Long id,

        @NotBlank(message = "O nome é obrigatório")
        @Length(min = 3, max = 255, message = "O nome tem que ter entre 3 e 255 caracteres")
        String nome,

        @NotBlank(message = "O endereco é obrigatório")
        @Length(min = 3, max = 255, message = "O endereco tem que ter entre 3 e 255 caracteres")
        String endereco,

        @NotEmpty(message = "É necessário informar ao menos uma certidão")
        List<String> certidoes
) {
}
