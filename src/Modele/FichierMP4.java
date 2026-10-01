package Modele;

import java.time.LocalDate;
import java.util.List;

public class FichierMP4 extends FichierVideo {


    public FichierMP4(String titre, int duree, LocalDate dateSortie, String realisateur, String chemin) {
        super(titre, duree, dateSortie, realisateur, chemin);
    }

    @Override
    protected List<String> optionsEncodage() {
        return List.of("-c:v", "libx264", "-preset", "fast", "-crf", "23",
                "-c:a", "aac", "-b:a", "160k");
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
        return "MP4";
    }

    @Override
    public void run() {

    }
}
