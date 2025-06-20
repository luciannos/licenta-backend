package ro.lucian_lazar.licenta_backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
public class LoginDTO {
    @NotBlank
    private String email;

    @NotBlank
    private String parola;

}