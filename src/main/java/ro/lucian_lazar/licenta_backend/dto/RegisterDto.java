package ro.lucian_lazar.licenta_backend.dto;


import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

@Getter
@Setter

public class RegisterDto {

    @NotBlank(message = "Numele este obligatoriu.")
    private String nume;

    @NotBlank(message = "Prenumele este obligatoriu.")
    private String prenume;

    @NotBlank(message = "Genul este oblgiatoriu.")
    private String gen;

    @Email(message = "Email invalid.")
    @NotBlank(message = "Emailul este obligatoriu.")
    private String email;

    @NotBlank(message = "Parola este obligatorie.")
    @Size(min = 8, message = "Parola trebuie să aibă cel puțin 8 caractere.")
    @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}$",
        message = "Parola trebuie să conțină cel puțin o literă mare, o literă mică, un număr și un caracter special (!@#$%^&*)"
    )
    private String parola;


    @NotBlank(message = "Adresa este obligatorie.")
    private String adresa;

    @NotBlank(message = " Numărul de telefon este obligatoriu.")
    private String telefon;


}
