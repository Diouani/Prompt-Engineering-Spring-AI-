package fr.enset.chatbot.modeles;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReponseFilms {
    
    private List<FilmInfo> films;
    private String commentaire;
    private int nombreTotal;
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FilmInfo {
        private String titre;
        private String realisateur;
        private int annee;
        private String genre;
        private double note;
        private String resume;
    }
}
