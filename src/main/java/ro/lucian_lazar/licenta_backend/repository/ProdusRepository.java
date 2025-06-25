package ro.lucian_lazar.licenta_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.lucian_lazar.licenta_backend.entity.Produs;
import java.util.List;

public interface ProdusRepository extends JpaRepository<Produs, Long> {
    List<Produs> findTop5ByOrderByNumarVanzariDesc();
}
