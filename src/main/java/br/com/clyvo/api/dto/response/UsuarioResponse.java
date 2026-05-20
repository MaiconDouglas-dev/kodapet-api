package br.com.clyvo.api.dto.response;

import br.com.clyvo.api.domain.Usuario;

import java.time.LocalDate;

public record UsuarioResponse(Long id, String nome, String email, String perfil, String ativo,
                              LocalDate dataCadastro) {
    public UsuarioResponse(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getPerfil(), usuario.getAtivo(), usuario.getDataCadastro());
    }
}