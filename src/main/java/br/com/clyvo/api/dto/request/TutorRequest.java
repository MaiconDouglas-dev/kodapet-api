package br.com.clyvo.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TutorRequest(
        @NotNull(message = "ID do usuário é obrigatório") Long idUsuario,
        @NotBlank(message = "O nome é obrigatório") String nome,
        @NotBlank(message = "O CPF é obrigatório") String cpf,
        String telefone, String endereco, LocalDate dataNascimento
) {
}
