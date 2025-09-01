package fr.enset.chatbot.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

@Service
public class ServiceIA {
    
    private final OpenAiChatModel modeleOpenAi;
    private final OllamaChatModel modeleOllama;
    private final ChatClient clientChatOpenAi;
    private final ChatClient clientChatOllama;

    public ServiceIA(OpenAiChatModel modeleOpenAi, 
                     OllamaChatModel modeleOllama,
                     ChatClient.Builder constructeur) {
        this.modeleOpenAi = modeleOpenAi;
        this.modeleOllama = modeleOllama;
        this.clientChatOpenAi = constructeur.chatModel(modeleOpenAi).build();
        this.clientChatOllama = constructeur.chatModel(modeleOllama).build();
    }
    
    public String obtenirReponseGPT4(String question, String systeme) {
        return clientChatOpenAi.prompt()
                .system(systeme)
                .user(question)
                .call()
                .content();
    }
    
    public String obtenirReponseLlama(String question, String systeme) {
        return clientChatOllama.prompt()
                .system(systeme)
                .user(question)
                .call()
                .content();
    }
    
    public String comparerModeles(String question) {
        String systeme = "Tu es un assistant intelligent. RÃ©ponds de maniÃ¨re concise et prÃ©cise.";
        
        String reponseGPT = obtenirReponseGPT4(question, systeme);
        String reponseLlama = obtenirReponseLlama(question, systeme);
        
        return String.format("""
            === COMPARAISON DES MODéLES ===
            
            ðŸ“‹ Question: %s
            
            ðŸ¤– GPT-4o:
            %s
            
            ðŸ¦™ Llama 3.2:
            %s
            
            ============================
            """, question, reponseGPT, reponseLlama);
    }
}
