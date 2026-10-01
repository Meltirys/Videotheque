package Modele;
import Modele.Abstract.Video

import java.time.LocalDate;

public class FichierAVI extends FichierVideo {

    private String chemin;

    public FichierAVI (String titre, String realisateur, LocalDate dateSortie, int duree, String chemin) {
        super(titre, realisateur, dateSortie, duree);
        this.chemin = chemin;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    @Override
    public String toString() {
        return "FichierAVI{" +
                "chemin='" + chemin + '\'' +
                '}';
    }

    public String getSupport() {
        return "AVI";
    }
}
