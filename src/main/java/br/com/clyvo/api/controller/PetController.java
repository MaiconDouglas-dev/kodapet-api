package br.com.clyvo.api.controller;

import br.com.clyvo.api.dto.request.PetRequest;
import br.com.clyvo.api.dto.response.PetResponse;
import br.com.clyvo.api.service.PetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pets")
@Tag(name = "Pet", description = "Endpoints de Pets")
public class PetController {

    private final PetService service;

    public PetController(PetService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PetResponse> criar(@RequestBody @Valid PetRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @GetMapping
    public ResponseEntity<Page<PetResponse>> listar(
            @RequestParam(required = false) String nome,
            @PageableDefault(size = 10, sort = "nome", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(service.listar(nome, pageable));
    }
}