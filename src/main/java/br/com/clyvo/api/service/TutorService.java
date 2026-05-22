package br.com.clyvo.api.service;

import br.com.clyvo.api.domain.Tutor;
import br.com.clyvo.api.domain.Usuario;
import br.com.clyvo.api.dto.request.TutorRequest;
import br.com.clyvo.api.dto.response.TutorResponse;
import br.com.clyvo.api.exception.BusinessRuleException;
import br.com.clyvo.api.exception.ResourceNotFoundException;
import br.com.clyvo.api.repository.TutorRepository;
import br.com.clyvo.api.repository.UsuarioRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TutorService {

    private final TutorRepository tutorRepository;
    private final UsuarioRepository usuarioRepository;

    public TutorService(TutorRepository tutorRepository, UsuarioRepository usuarioRepository) {
        this.tutorRepository = tutorRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    @CacheEvict(value = "tutores", allEntries = true)
    public TutorResponse criar(TutorRequest request) {
        Usuario usuario = usuarioRepository.findById(request.idUsuario())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário vinculado não encontrado."));

        if (tutorRepository.existsByCpf(request.cpf())) {
            throw new BusinessRuleException("Já existe um tutor cadastrado com este CPF.");
        }
        
        if (tutorRepository.existsByUsuarioId(usuario.getId())) {
            throw new BusinessRuleException("Este usuário já está vinculado a um tutor.");
        }

        Tutor tutor = new Tutor();
        tutor.setUsuario(usuario);
        tutor.setNome(request.nome());
        tutor.setCpf(request.cpf());
        tutor.setTelefone(request.telefone());
        tutor.setEndereco(request.endereco());
        tutor.setDataNascimento(request.dataNascimento());

        return new TutorResponse(tutorRepository.save(tutor));
    }

    @Cacheable(value = "tutores")
    public Page<TutorResponse> listar(String nome, Pageable pageable) {
        if (nome != null && !nome.isBlank()) {
            return tutorRepository.findByNomeContainingIgnoreCase(nome, pageable).map(TutorResponse::new);
        }
        return tutorRepository.findAll(pageable).map(TutorResponse::new);
    }
}