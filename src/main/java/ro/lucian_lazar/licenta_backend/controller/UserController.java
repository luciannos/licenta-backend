package ro.lucian_lazar.licenta_backend.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ro.lucian_lazar.licenta_backend.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import ro.lucian_lazar.licenta_backend.entity.User;
import ro.lucian_lazar.licenta_backend.repository.UserRepository;
import ro.lucian_lazar.licenta_backend.dto.ComandaDto;
import ro.lucian_lazar.licenta_backend.mapper.ComandaMapper;
import ro.lucian_lazar.licenta_backend.service.ComandaService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ComandaService comandaService;
    @Autowired
    private ComandaMapper comandaMapper;

    @GetMapping("/me")
    public ResponseEntity<User> getMe(Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) return ResponseEntity.notFound().build();
        user.setParola(null); // nu trimitem parola
        return ResponseEntity.ok(user);
    }

    @PutMapping("/adresa")
    public ResponseEntity<?> updateAdresa(Authentication authentication, @RequestBody String adresa) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) return ResponseEntity.notFound().build();
        user.setAdresa(adresa);
        userRepository.save(user);
        return ResponseEntity.ok("Adresa actualizată cu succes.");
    }

    public static class ChangePasswordRequest {
        public String parolaVeche;
        public String parolaNoua;
    }

    @PutMapping("/parola")
    public ResponseEntity<?> updateParola(Authentication authentication, @RequestBody ChangePasswordRequest req) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) return ResponseEntity.notFound().build();
        if (!passwordEncoder.matches(req.parolaVeche, user.getParola())) {
            return ResponseEntity.badRequest().body("Parola veche este incorectă.");
        }
        user.setParola(passwordEncoder.encode(req.parolaNoua));
        userRepository.save(user);
        return ResponseEntity.ok("Parola a fost schimbată cu succes.");
    }

    @GetMapping("/comenzi")
    @Transactional(readOnly = true)
    public ResponseEntity<List<ComandaDto>> getComenzileMele(Authentication authentication) {
        String email = authentication.getName();
        List<ComandaDto> comenzi = comandaService.getComenziByUserEmail(email).stream()
                .map(comandaMapper::toDto)
                .toList();
        return ResponseEntity.ok(comenzi);
    }

    @PutMapping("/telefon")
    public ResponseEntity<?> updateTelefon(Authentication authentication, @RequestBody String telefon) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) return ResponseEntity.notFound().build();
        user.setTelefon(telefon);
        userRepository.save(user);
        return ResponseEntity.ok("Numărul de telefon a fost actualizat cu succes.");
    }
}
