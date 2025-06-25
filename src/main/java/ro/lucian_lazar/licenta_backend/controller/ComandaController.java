package ro.lucian_lazar.licenta_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.lucian_lazar.licenta_backend.dto.ComandaDto;
import ro.lucian_lazar.licenta_backend.dto.DetaliuComandaDto;
import ro.lucian_lazar.licenta_backend.dto.PlaseazaComandaRequestDto;
import ro.lucian_lazar.licenta_backend.service.ComandaService;

import java.util.List;

@RestController
@RequestMapping("/api/comenzi")
public class ComandaController {

    private final ComandaService comandaService;

    public ComandaController(ComandaService comandaService) {
        this.comandaService = comandaService;
    }

    @PostMapping
    public ResponseEntity<ComandaDto> plaseazaComanda(
            @RequestBody PlaseazaComandaRequestDto request,
            @AuthenticationPrincipal UserDetails userDetails) {
        ComandaDto comandaPlasata = comandaService.plaseazaComanda(userDetails.getUsername(), request);
        return ResponseEntity.ok(comandaPlasata);
    }
} 