package ro.lucian_lazar.licenta_backend.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.lucian_lazar.licenta_backend.dto.ProdusDto;
import ro.lucian_lazar.licenta_backend.entity.Produs;
import ro.lucian_lazar.licenta_backend.mapper.ProdusMapper;
import ro.lucian_lazar.licenta_backend.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/produse")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProdusDto> getAllProduse() {
        return productService.getAll().stream()
                .map(ProdusMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdusDto> getProdusById(@PathVariable Long id) {
        Produs produs = productService.getById(id);
        return produs != null
                ? ResponseEntity.ok(ProdusMapper.toDto(produs))
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProdusDto> createProdus(@Valid @RequestBody ProdusDto dto) {
        Produs produs = productService.save(ProdusMapper.toEntity(dto));
        return ResponseEntity.ok(ProdusMapper.toDto(produs));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdusDto> updateProdus(@PathVariable Long id, @Valid @RequestBody ProdusDto dto) {
        Produs existent = productService.getById(id);
        if (existent == null) {
            return ResponseEntity.notFound().build();
        }
        existent.setNume(dto.getNume());
        existent.setPret(dto.getPret());
        Produs updated = productService.save(existent);
        return ResponseEntity.ok(ProdusMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdus(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
