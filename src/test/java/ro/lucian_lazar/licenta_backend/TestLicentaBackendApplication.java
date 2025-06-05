package ro.lucian_lazar.licenta_backend;

import org.springframework.boot.SpringApplication;

public class TestLicentaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.from(LicentaBackendApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
