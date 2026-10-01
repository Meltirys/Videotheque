package outils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public final class Ffmpeg {

    private Ffmpeg() {

    }

        public static int convertir(File entree, File sortie, List<String> options)
        throws IOException, InterruptedException {
            List<String> commande = new ArrayList<>();
            commande.add("ffmpeg");
            commande.add("-y");
            commande.add("-loglevel");
            commande.add("error");
            commande.add("-i");
            commande.add(entree.getAbsolutePath());
            commande.addAll(options);
            commande.add(sortie.getAbsolutePath());

            ProcessBuilder pb = new ProcessBuilder(commande);
            pb.redirectErrorStream(true);
            Process processus = pb.start();

            BufferedReader lecteur = new BufferedReader(new InputStreamReader(processus.getInputStream()));
            String donnee;
            while ((donnee = lecteur.readLine()) != null) {
                System.out.println(donnee);
            }
            return processus.waitFor();
        }
    
}
