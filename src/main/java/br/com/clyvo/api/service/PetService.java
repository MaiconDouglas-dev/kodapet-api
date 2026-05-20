package br.com.clyvo.api.service;

import br.com.clyvo.api.domain.Pet;
import br.com.clyvo.api.domain.Tutor;
import br.com.clyvo.api.dto.request.PetRequest;
import br.com.clyvo.api.dto.response.PetResponse;
import br.com.clyvo.api.exception.ResourceNotFoundException;
import br.com.clyvo.api.repository.PetRepository;
import br.com.clyvo.api.repository.TutorRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final TutorRepository tutorRepository;

    public PetService(PetRepository petRepository, TutorRepository tutorRepository) {
        this.petRepository = petRepository;
        this.tutorRepository = tutorRepository;
    }

    @Transactional
    @CacheEvict(value = "pets", allEntries = true)
    public PetResponse criar(PetRequest request) {
        Tutor tutor = tutorRepository.findById(request.idTutor()).orElseThrow(() -> new ResourceNotFoundException("Tutor vinculado não encontrado."));

        Pet pet = new Pet();
        pet.setTutor(tutor);
        pet.setNome(request.nome());
        pet.setEspecie(request.especie());
        pet.setRaca(request.raca());
        pet.setSexo(request.sexo());
        pet.setDataNascimento(request.dataNascimento());
        pet.setPesoKg(request.pesoKg());

        return new PetResponse(petRepository.save(pet));
    }

    @Cacheable(value = "pets")
    public Page<PetResponse> listar(String nome, Pageable pageable) {
        if (nome != null && !nome.isBlank()) {
            return petRepository.findByNomeContainingIgnoreCase(nome, pageable).map(PetResponse::new);
        }
        return petRepository.findAll(pageable).map(PetResponse::new);
    }
}