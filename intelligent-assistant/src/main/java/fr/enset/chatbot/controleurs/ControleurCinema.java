package fr.enset.chatbot.controleurs;

import fr.enset.chatbot.modeles.ReponseFilms;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cinema")
@CrossOrigin(origins = "*")
public class ControleurCinema {

    private final ChatClient clientChat;

    public ControleurCinema(ChatClient.Builder constructeurClient) {
        this.clientChat = constructeurClient
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .build();
    }

    @PostMapping("/recommandations")
    public ReponseFilms obtenirRecommandations(@RequestParam String demande) {
        return clientChat.prompt()
                .system("Tu es un expert en cinÃ©ma. Tu recommandes des films en rÃ©pondant avec une structure JSON prÃ©cise.")
                .user(demande)
                .call()
                .entity(ReponseFilms.class);
    }
}
