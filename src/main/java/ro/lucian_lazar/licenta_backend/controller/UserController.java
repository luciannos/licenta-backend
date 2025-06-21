package ro.lucian_lazar.licenta_backend.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ro.lucian_lazar.licenta_backend.dto.UserDto;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/me")
    public ResponseEntity<String> profil(Authentication authentication) {
        return ResponseEntity.ok("Salut, " + authentication.getName());
    }
    @PostMapping(value = "/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<UserDto> register(@ModelAttribute UserDto user) {
        return ResponseEntity.ok(user);
    }
}
