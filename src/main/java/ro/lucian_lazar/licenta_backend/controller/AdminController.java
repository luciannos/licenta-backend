package ro.lucian_lazar.licenta_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.lucian_lazar.licenta_backend.dto.ComandaDto;
import ro.lucian_lazar.licenta_backend.dto.ProdusDto;
import ro.lucian_lazar.licenta_backend.entity.Produs;
import ro.lucian_lazar.licenta_backend.mapper.ComandaMapper;
import ro.lucian_lazar.licenta_backend.mapper.ProdusMapper;
import ro.lucian_lazar.licenta_backend.service.ComandaService;
import ro.lucian_lazar.licenta_backend.service.ProdusService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final ProdusService produsService;
    private final ProdusMapper produsMapper;
    private final ComandaService comandaService;
    private final ComandaMapper comandaMapper;

    public AdminController(ProdusService produsService, ProdusMapper produsMapper, ComandaService comandaService, ComandaMapper comandaMapper) {
        this.produsService = produsService;
        this.produsMapper = produsMapper;
        this.comandaService = comandaService;
        this.comandaMapper = comandaMapper;
    }

    @PostMapping("/produse")
    public ResponseEntity<ProdusDto> addProdus(@RequestBody ProdusDto produsDto) {
        Produs produs = produsMapper.dtoToEntity(produsDto);
        Produs produsSalvat = produsService.save(produs);
        return ResponseEntity.ok(produsMapper.entityToDto(produsSalvat));
    }

    @PutMapping("/produse/{id}")
    public ResponseEntity<ProdusDto> updateProdus(@PathVariable Long id, @RequestBody ProdusDto produsDto) {
        // Asigură-te că ID-ul din cale este folosit, nu cel din body
        produsDto.setId(id);
        Produs produs = produsMapper.dtoToEntity(produsDto);
        Produs produsActualizat = produsService.save(produs);
        return ResponseEntity.ok(produsMapper.entityToDto(produsActualizat));
    }

    @GetMapping("/comenzi")
    @Transactional(readOnly = true)
    public ResponseEntity<List<ComandaDto>> getIstoricComenzi() {
        List<ComandaDto> comenzi = comandaService.getAllComenzi().stream()
                .map(comandaMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(comenzi);
    }
} 