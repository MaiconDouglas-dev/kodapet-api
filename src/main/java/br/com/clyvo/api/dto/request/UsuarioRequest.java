package br.com.clyvo.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequest(
        @NotBlank(message = "O nome é obrigatório") String nome,
        @NotBlank(message = "O email é obrigatório")
        @Email(message = "Formato inválido") String email,

        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 8, message = "A senha deve possuir no mínimo 8 caracteres.")
        String senha,

        @NotBlank(message = "O perfil é obrigatório") String perfil
) {
}