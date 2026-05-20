package br.com.clyvo.api.dto.response;

import br.com.clyvo.api.domain.Pet;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PetResponse(Long id, Long idTutor, String nome, String especie, String raca,
                          String sexo, LocalDate dataNascimento, BigDecimal pesoKg) {
    public PetResponse(Pet pet) {
        this(pet.getId(), pet.getTutor() != null ? pet.getTutor().getId() : null, pet.getNome(), pet.getEspecie(), pet.getRaca(), pet.getSexo(), pet.getDataNascimento(), pet.getPesoKg());
    }
}