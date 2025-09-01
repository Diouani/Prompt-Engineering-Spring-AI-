package fr.enset.chatbot.configuration;

import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationIA {

    @Bean
    public ChatMemory memoireChat() {
        return new InMemoryChatMemory();
    }
}
