package Modele;

import java.time.LocalDate;
import java.util.List;

public class FichierAVI extends FichierVideo {

    public FichierAVI(String titre, int duree, LocalDate dateSortie, String realisateur, String chemin) {
        super(titre, duree, dateSortie, realisateur, chemin);
    }

    @Override
    protected List<String> optionsEncodage() {
        return List.of("-c:v", "mpeg4", "-q:v", "5",
                "-c:a", "libmp3lame", "-b:a", "192k");
    }

    @Override
    public String toString() {
        return "FichierMP4{" +
                "titre='" + titre + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", dateSortie=" + dateSortie +
                ", duree=" + duree +
                '}';
    }

    public String getSupport() {
        return "AVI";
    }

    @Override
    public void run() {

    }
}
