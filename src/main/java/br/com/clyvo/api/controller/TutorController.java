package br.com.clyvo.api.controller;

import br.com.clyvo.api.dto.request.TutorRequest;
import br.com.clyvo.api.dto.response.TutorResponse;
import br.com.clyvo.api.service.TutorService;
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
@RequestMapping("/api/v1/tutores")
@Tag(name = "Tutor", description = "Endpoints de Tutores")
public class TutorController {

    private final TutorService service;

    public TutorController(TutorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TutorResponse> criar(@RequestBody @Valid TutorRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @GetMapping
    public ResponseEntity<Page<TutorResponse>> listar(
            @RequestParam(required = false) String nome,
            @PageableDefault(size = 10, sort = "nome", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(service.listar(nome, pageable));
    }
}