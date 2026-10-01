package Modele;

import Exceptions.ConversionImpossibleException;
import Exceptions.LectureImpossibleException;
import Modele.Abstract.Video;
import Outils.Ffmpeg;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class FichierVideo extends Video implements Convertible, Runnable {
    private String chemin;

    public FichierVideo(String titre, int duree, LocalDate dateSortie, String realisateur, String chemin) {
        super(titre, duree, dateSortie, realisateur);
        this.chemin = chemin;
    }

    public void lire() throws LectureImpossibleException {
        File f = getFichier();
        if (!f.exists()) {
            throw new LectureImpossibleException("Fichier introuvable");
        }
        Thread t = new Thread(this);
        t.setDaemon(true);
        t.start();
    }

    public FichierVideo convertir(String formatCible) {
        if (getSupport().equalsIgnoreCase(formatCible)) {
            throw new ConversionImpossibleException("La vidéo est déjà au fomrat cible " + formatCible);
        }

        // prend le fichier sans extension ".mp4"
        Path p = Paths.get(chemin);
        String nomSansExtension = p.getFileName().toString().replaceFirst("[.][^.]+$", "");
        String cheminSortie = chemin.replace("." + getSupport().toLowerCase(), "." + formatCible.toLowerCase());

        // prend les infos du nouvel Objet "cible"
        FichierVideo cible;
        switch (formatCible.toLowerCase()) {
            case "mp4":
                cible = new FichierMP4(getTitre(), getDuree(), getDateSortie(), getRealisateur(), cheminSortie);
                break;
            case  "avi":
                cible = new FichierAVI(getTitre(), getDuree(), getDateSortie(), getRealisateur(), cheminSortie);
                break;
            default:
                throw new ConversionImpossibleException("Mauvais format !");
        }

        //Lancer ffmpeg avec les options du format "cible"
        int retourffmpeg = 1;
        try {
            retourffmpeg = Ffmpeg.convertir(getFichier(), cible.getFichier(), cible.optionsEncodage());
        } catch (IOException | InterruptedException e) {
            throw new ConversionImpossibleException("La conversion n'a pas pu être lancée !");
        }

        if (retourffmpeg != 0) {
            throw new ConversionImpossibleException("La conversion a échouée !");
        }

        return cible;
    }

    protected abstract List<String> optionsEncodage();


    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public java.io.File getFichier() {
        return new java.io.File(chemin);
    }
}
