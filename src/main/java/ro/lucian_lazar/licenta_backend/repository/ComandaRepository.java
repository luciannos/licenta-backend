package ro.lucian_lazar.licenta_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.lucian_lazar.licenta_backend.entity.Comanda;

public interface ComandaRepository extends JpaRepository<Comanda, Long> {
}
