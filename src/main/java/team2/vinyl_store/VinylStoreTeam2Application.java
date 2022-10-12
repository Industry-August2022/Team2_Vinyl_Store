package team2.vinyl_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class VinylStoreTeam2Application {

	public static void main(String[] args) {
		SpringApplication.run(VinylStoreTeam2Application.class, args);
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/*").allowedOrigins("http://localhost:4200");
                registry.addMapping("/api/*/*").allowedOrigins("http://localhost:4200");
                registry.addMapping("/api/*/*/*").allowedOrigins("http://localhost:4200");
            }
        };
    }

}
