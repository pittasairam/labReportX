package com.rf.labrex;


import com.rf.labrex.entity.LaboratoryWorker;
import com.rf.labrex.entity.UserRole;
import com.rf.labrex.repository.HospitalRepository;
import com.rf.labrex.repository.LaboratoryWorkerRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LabrexApplication {

	public LabrexApplication(PasswordEncoder encoder) {
		this.encoder = encoder;
	}

	private final PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(LabrexApplication.class, args);
	}

	@Bean
	public ApplicationRunner hospitalDataInitializer(HospitalRepository hospitalRepository, LaboratoryWorkerRepository repository) {
		return args -> {
		  LaboratoryWorker worker=LaboratoryWorker.builder().name("Furkan").lastName("Can").build();
		  worker.setRole(UserRole.ROLE_ADMIN);
		  worker.setPassword(encoder.encode("Ef123456789"));
		  worker.setIdentificationNumber("52657784048");
		  repository.save(worker);
		};
	}
}
