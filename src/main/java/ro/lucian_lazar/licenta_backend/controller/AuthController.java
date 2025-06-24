package ro.lucian_lazar.licenta_backend.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ro.lucian_lazar.licenta_backend.dto.*;
import ro.lucian_lazar.licenta_backend.entity.User;
import ro.lucian_lazar.licenta_backend.repository.UserRepository;
import ro.lucian_lazar.licenta_backend.security.JwtUtil;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Blacklist pentru token-uri invalidate
    public static final Set<String> TOKEN_BLACKLIST = ConcurrentHashMap.newKeySet();

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterDto dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email deja folosit.");
        }
        User user = new User();
        user.setNume(dto.getNume());
        user.setPrenume(dto.getPrenume());
        user.setGen(dto.getGen());
        user.setEmail(dto.getEmail());
        user.setParola(passwordEncoder.encode(dto.getParola()));
        user.setAdresa(dto.getAdresa());
        user.setTelefon(dto.getTelefon());
        // Rolul și data înregistrării sunt setate automat în entitate

        userRepository.save(user);
        return ResponseEntity.ok("Înregistrare reușită.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDto dto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getParola()));
        String token = jwtUtil.genereazaToken(dto.getEmail());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            TOKEN_BLACKLIST.add(token);
            return ResponseEntity.ok("Logout cu succes.");
        }
        return ResponseEntity.badRequest().body("Token lipsă sau invalid.");
    }
}