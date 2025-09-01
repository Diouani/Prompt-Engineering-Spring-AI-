package fr.enset.chatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssistantIntelligentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssistantIntelligentApplication.class, args);
        System.out.println("=== Assistant Intelligent dÃ©marrÃ© avec succÃ¨s ===");
        System.out.println("Interface H2: http://localhost:8080/h2-console");
        System.out.println("API Docs: http://localhost:8080/swagger-ui.html");
    }
}
