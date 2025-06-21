package ro.lucian_lazar.licenta_backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
public class LoginDto {
    @NotBlank
    private String email;

    @NotBlank
    private String parola;

}