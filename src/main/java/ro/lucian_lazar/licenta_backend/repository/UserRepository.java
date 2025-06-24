package ro.lucian_lazar.licenta_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.lucian_lazar.licenta_backend.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
