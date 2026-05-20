package br.com.clyvo.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PetRequest(
        @NotNull(message = "ID do Tutor é obrigatório") Long idTutor,
        @NotBlank(message = "Nome do pet é obrigatório") String nome,
        String especie,
        String raca,
        String sexo,
        LocalDate dataNascimento,
        BigDecimal pesoKg
) {
}