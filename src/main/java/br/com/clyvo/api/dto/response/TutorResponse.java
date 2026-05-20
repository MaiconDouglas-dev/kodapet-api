package br.com.clyvo.api.dto.response;

import br.com.clyvo.api.domain.Tutor;

import java.time.LocalDate;

public record TutorResponse(Long id, Long idUsuario, String nome, String cpf, String telefone,
                            String endereco, LocalDate dataNascimento) {
    public TutorResponse(Tutor tutor) {
        this(tutor.getId(), tutor.getUsuario() != null ? tutor.getUsuario().getId() : null, tutor.getNome(), tutor.getCpf(), tutor.getTelefone(), tutor.getEndereco(), tutor.getDataNascimento());
    }
}