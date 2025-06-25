package ro.lucian_lazar.licenta_backend.service;

import org.springframework.stereotype.Service;
import ro.lucian_lazar.licenta_backend.entity.Produs;
import ro.lucian_lazar.licenta_backend.repository.ProdusRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProdusRepository productRepository;

    public ProductService(ProdusRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Produs> getAll() {
        return productRepository.findAll();
    }

    public Produs getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Produs save(Produs produs) {
        return productRepository.save(produs);
    }

    public void delete(long id) {
        productRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Produs> getTopVanzari() {
        return productRepository.findTop5ByOrderByNumarVanzariDesc();
    }
}
