package Modele;

import Exceptions.LectureImpossibleException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
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
    public void lire() throws LectureImpossibleException {
        super.lire();
            List<String> commande = new ArrayList<>();
            commande.add("ffplay");
            commande.add("-autoexist");
            commande.add("-windows_title");
            commande.add(getTitre());
            commande.add("-i");
            commande.add(getChemin());


            ProcessBuilder pb = new ProcessBuilder(commande);
            pb.redirectErrorStream(true);
        Process processus = null;
        try {
            processus = pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
