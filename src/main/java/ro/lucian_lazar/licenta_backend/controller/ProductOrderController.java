package ro.lucian_lazar.licenta_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.lucian_lazar.licenta_backend.dto.ProductOrderDto;
import ro.lucian_lazar.licenta_backend.service.ProductOrderService;

import java.util.List;

@RestController
@RequestMapping("/api/product-orders")
public class ProductOrderController {

    @Autowired
    private ProductOrderService service;

    @GetMapping
    public List<ProductOrderDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductOrderDto> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductOrderDto> create(@RequestBody ProductOrderDto dto) {
        try {
            return ResponseEntity.ok(service.create(dto));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
