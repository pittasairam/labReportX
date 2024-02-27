package com.rf.labrex;


import com.rf.labrex.entity.Hospital;
import com.rf.labrex.entity.LaboratoryWorker;
import com.rf.labrex.entity.Patient;
import com.rf.labrex.entity.UserRole;
import com.rf.labrex.repository.HospitalRepository;
import com.rf.labrex.repository.LaboratoryWorkerRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class LabrexApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabrexApplication.class, args);
	}

	/*@Bean
	public ApplicationRunner hospitalDataInitializer(HospitalRepository hospitalRepository, LaboratoryWorkerRepository repository) {
		return args -> {
			for (int i = 0; i < 5; i++) {
				Hospital hospital = new Hospital();
				hospitalRepository.save(hospital);
				LaboratoryWorker laboratoryWorker=new LaboratoryWorker();
				laboratoryWorker.setRole(UserRole.WORKER);
				repository.save(laboratoryWorker);
			}
		};
	}*/
}
