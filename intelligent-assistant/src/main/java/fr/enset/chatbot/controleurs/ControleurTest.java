package fr.enset.chatbot.controleurs;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "*")
public class ControleurTest {
    
    @GetMapping("/ping")
    public Map<String, Object> ping() {
        Map<String, Object> reponse = new HashMap<>();
        reponse.put("status", "OK");
        reponse.put("message", "Assistant Intelligent est actif");
        reponse.put("timestamp", LocalDateTime.now());
        reponse.put("version", "1.0.0");
        return reponse;
    }
    
    @GetMapping("/info")
    public Map<String, Object> informationsSysteme() {
        Map<String, Object> info = new HashMap<>();
        info.put("nom_application", "Assistant Intelligent");
        info.put("description", "Chatbot basÃ© sur GPT-4o et Llama 3.2");
        return info;
    }
}
