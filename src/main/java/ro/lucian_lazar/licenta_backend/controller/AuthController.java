package ro.lucian_lazar.licenta_backend.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ro.lucian_lazar.licenta_backend.dto.*;
import ro.lucian_lazar.licenta_backend.model.User;
import ro.lucian_lazar.licenta_backend.repository.UserRepository;
import ro.lucian_lazar.licenta_backend.security.JwtUtil;

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

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterDTO dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email deja folosit.");
        }
        User user = new User(dto.getNume(), dto.getPrenume(),dto.getGen() , dto.getEmail(), passwordEncoder.encode(dto.getParola()), dto.getAdresa(), dto.getTelefon() );
        userRepository.save(user);
        return ResponseEntity.ok("Înregistrare reușită.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO dto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getParola()));
        String token = jwtUtil.genereazaToken(dto.getEmail());
        return ResponseEntity.ok(new JwtResponse(token));
    }
}