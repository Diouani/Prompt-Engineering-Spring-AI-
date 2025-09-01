package fr.enset.chatbot.controleurs;

import fr.enset.chatbot.services.ServiceIA;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/comparaison")
@CrossOrigin(origins = "*")
public class ControleurComparaison {
    
    private final ServiceIA serviceIA;
    
    public ControleurComparaison(ServiceIA serviceIA) {
        this.serviceIA = serviceIA;
    }
    
    @PostMapping("/gpt4o")
    public Map<String, String> questionnerGPT4(@RequestParam String question) {
        String reponse = serviceIA.obtenirReponseGPT4(question, 
            "Tu es GPT-4o, un assistant intelligent développé par OpenAI.");
        
        Map<String, String> resultat = new HashMap<>();
        resultat.put("modele", "GPT-4o");
        resultat.put("question", question);
        resultat.put("reponse", reponse);
        
        return resultat;
    }
    
    @PostMapping("/llama32")
    public Map<String, String> questionnerLlama(@RequestParam String question) {
        String reponse = serviceIA.obtenirReponseLlama(question,
            "Tu es Llama 3.2, un assistant intelligent dÃ©veloppÃ© par Meta.");
        
        Map<String, String> resultat = new HashMap<>();
        resultat.put("modele", "Llama 3.2");
        resultat.put("question", question);
        resultat.put("reponse", reponse);
        
        return resultat;
    }
    
    @PostMapping("/comparer")
    public String comparerLesModeles(@RequestParam String question) {
        return serviceIA.comparerModeles(question);
    }
}
