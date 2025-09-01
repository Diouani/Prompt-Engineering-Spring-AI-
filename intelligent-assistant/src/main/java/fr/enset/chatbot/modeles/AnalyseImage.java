package fr.enset.chatbot.modeles;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalyseImage {
    
    private String descriptionGenerale;
    private List<String> objetsDetectes;
    private String couleurDominante;
    private String emotion;
    private String style;
    private double scorePrecision;
    private List<String> tags;
}
