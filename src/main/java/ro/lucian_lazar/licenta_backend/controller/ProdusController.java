package ro.lucian_lazar.licenta_backend.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.lucian_lazar.licenta_backend.dto.ProdusDto;
import ro.lucian_lazar.licenta_backend.entity.Produs;
import ro.lucian_lazar.licenta_backend.mapper.ProdusMapper;
import ro.lucian_lazar.licenta_backend.service.ProdusService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/produse")
public class ProdusController {

    private final ProdusService produsService;
    private final ProdusMapper produsMapper;

    public ProdusController(ProdusService produsService, ProdusMapper produsMapper) {
        this.produsService = produsService;
        this.produsMapper = produsMapper;
    }

    @GetMapping
    public List<ProdusDto> getAllProduse() {
        return produsService.getAll().stream()
                .map(produsMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdusDto> getProdusById(@PathVariable Long id) {
        Produs produs = produsService.getById(id);
        return produs != null
                ? ResponseEntity.ok(produsMapper.entityToDto(produs))
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProdusDto> createProdus(@Valid @RequestBody ProdusDto dto) {
        Produs produs = produsService.save(produsMapper.dtoToEntity(dto));
        return ResponseEntity.ok(produsMapper.entityToDto(produs));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdusDto> updateProdus(@PathVariable Long id, @Valid @RequestBody ProdusDto dto) {
        Produs existent = produsService.getById(id);
        if (existent == null) {
            return ResponseEntity.notFound().build();
        }

        existent.setDenumire(dto.getDenumire());
        existent.setPret(dto.getPret());
        existent.setStoc(dto.getStoc());
        existent.setCategorie(dto.getCategorie());
        existent.setImagine(dto.getImagine());
        existent.setDescriere(dto.getDescriere());

        Produs updated = produsService.save(existent);
        return ResponseEntity.ok(produsMapper.entityToDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdus(@PathVariable Long id) {
        produsService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/recomandate")
    public List<ProdusDto> getRecomandari() {
        return produsService.getTopVanzari().stream()
                .map(produsMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
