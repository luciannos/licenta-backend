package ro.lucian_lazar.licenta_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ro.lucian_lazar.licenta_backend.entity.User;
import ro.lucian_lazar.licenta_backend.repository.UserRepository;

@SpringBootApplication
public class LicentaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LicentaBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (userRepository.findByEmail("admin@magazin.com").isEmpty()) {
				User admin = new User();
				admin.setNume("Admin");
				admin.setPrenume("User");
				admin.setEmail("admin@magazin.com");
				admin.setParola(passwordEncoder.encode("admin123"));
				admin.setRole("ADMIN");
				admin.setGen("-");
				admin.setAdresa("-");
				admin.setTelefon("-");
				userRepository.save(admin);
				System.out.println(">>> Utilizator ADMIN creat cu succes!");
			}
		};
	}
}
