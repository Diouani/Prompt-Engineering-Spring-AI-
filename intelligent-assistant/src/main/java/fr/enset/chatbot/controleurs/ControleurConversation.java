package fr.enset.chatbot.controleurs;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/conversation")
@CrossOrigin(origins = "*")
public class ControleurConversation {
    
    private final ChatClient clientChat;

    public ControleurConversation(ChatClient.Builder constructeur, ChatMemory memoire) {
        this.clientChat = constructeur
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(memoire).build())
                .build();
    }
    
    @PostMapping("/discuter")
    public String discuterAvecIA(@RequestParam String question) {
        List<Message> exemples = List.of(
                new UserMessage("Quelle est la capitale de la France?"),
                new AssistantMessage("LA CAPITALE DE LA FRANCE EST PARIS")
        );
        
        return clientChat.prompt()
                .system("Tu es un assistant intelligent. RÃ©ponds toujours en majuscules et sois trÃ¨s prÃ©cis.")
                .messages(exemples)
                .user(question)
                .call()
                .content();
    }
}
