package ro.lucian_lazar.licenta_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class AuthResponse {
    private String token;
    private UserDTO user;
}
