package ro.lucian_lazar.licenta_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.lucian_lazar.licenta_backend.dto.ProductOrderDto;
import ro.lucian_lazar.licenta_backend.entity.Comanda;
import ro.lucian_lazar.licenta_backend.entity.Produs;
import ro.lucian_lazar.licenta_backend.mapper.ProductOrderMapper;
import ro.lucian_lazar.licenta_backend.model.ProductOrder;
import ro.lucian_lazar.licenta_backend.repository.ComandaRepository;
import ro.lucian_lazar.licenta_backend.repository.ProdusRepository;
import ro.lucian_lazar.licenta_backend.repository.ProductOrderRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductOrderService {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Autowired
    private ComandaRepository comandaRepository;

    @Autowired
    private ProdusRepository produsRepository;

    public List<ProductOrderDto> getAll() {
        return productOrderRepository.findAll().stream()
                .map(ProductOrderMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<ProductOrderDto> getById(Long id) {
        return productOrderRepository.findById(id)
                .map(ProductOrderMapper::toDto);
    }

    public ProductOrderDto create(ProductOrderDto dto) {
        Comanda comanda = comandaRepository.findById(dto.getComandaId())
                .orElseThrow(() -> new IllegalArgumentException("Comanda nu există"));
        Produs produs = produsRepository.findById(dto.getProdusId())
                .orElseThrow(() -> new IllegalArgumentException("Produsul nu există"));

        ProductOrder entity = ProductOrderMapper.toEntity(dto, comanda, produs);
        return ProductOrderMapper.toDto(productOrderRepository.save(entity));
    }

    public void delete(Long id) {
        productOrderRepository.deleteById(id);
    }
}
