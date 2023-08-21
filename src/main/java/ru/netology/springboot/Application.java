package ru.netology.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@ConditionalOnProperty
	@Bean
	public SystemProfile devProfile() {
		return new DevProfile();
	}

	@Bean
	public SystemProfile prodProfile() {
		return new ProductionProfile();
	}

	@RestController
	@RequestMapping("/")
	public static class ProfileController {
		private final SystemProfile profile;

		public ProfileController(SystemProfile profile) {
			this.profile = profile;
		}

		@GetMapping("profile")
		public String getProfile() {
			return profile.getProfile();
		}
	}
}