package ro.lucian_lazar.licenta_backend.dto;


import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter
@Setter

public class RegisterDTO {

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
    @Size(min = 6, message = "Parola trebuie să aibă cel puțin 6 caractere.")
    private String parola;


    @NotBlank(message = "Adresa este obligatorie.")
    private String adresa;

    @NotBlank(message = " Numărul de telefon este obligatoriu.")
    private String telefon;


    // Getters & Setters
}
