package br.com.clyvo.api.service;

import br.com.clyvo.api.domain.Usuario;
import br.com.clyvo.api.dto.request.UsuarioRequest;
import br.com.clyvo.api.dto.response.UsuarioResponse;
import br.com.clyvo.api.exception.BusinessRuleException;
import br.com.clyvo.api.exception.ResourceNotFoundException;
import br.com.clyvo.api.repository.UsuarioRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @CacheEvict(value = "usuarios", allEntries = true)
    public UsuarioResponse criar(UsuarioRequest request) {
        if (repository.existsByEmailIgnoreCase(request.email())) {
            throw new BusinessRuleException("Já existe um usuário cadastrado com este e-mail.");
        }

        if (request.senha() == null || request.senha().trim().length() < 8) {
            throw new BusinessRuleException("A senha deve possuir no mínimo 8 caracteres.");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setSenhaHash(request.senha());
        usuario.setPerfil(request.perfil());

        return new UsuarioResponse(repository.save(usuario));
    }

    @Cacheable(value = "usuarios")
    public Page<UsuarioResponse> listar(String nome, Pageable pageable) {
        if (nome != null && !nome.isBlank()) {
            return repository.findByNomeContainingIgnoreCase(nome, pageable).map(UsuarioResponse::new);
        }
        return repository.findAll(pageable).map(UsuarioResponse::new);
    }

    public UsuarioResponse buscarPorId(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));
        return new UsuarioResponse(usuario);
    }
}