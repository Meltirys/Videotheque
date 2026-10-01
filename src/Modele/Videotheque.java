package Modele;

import Exceptions.*;
import Modele.Abstract.Video;

import java.util.ArrayList;

public class Videotheque implements GestionVideotheque {

    private static ArrayList<Video> videotheque =new ArrayList<>();

    public static ArrayList<Video> getVideotheque() {
        return videotheque;
    }


    @Override
    public void listerVideo() throws VideothequeVideException {

        if (getVideotheque().isEmpty()) {
            throw new VideothequeVideException("La vidéothèque est vide!");
        }
        for (Video v : getVideotheque()) {
            System.out.println(v);
        }
    }

    @Override
    public Video rechercherVideo(String titre) throws VideothequeVideException, VideoIntrouvableException {

        if (getVideotheque().isEmpty()) {
            throw new VideothequeVideException("La vidéothèque est vide!");
        }
        for (Video v : getVideotheque()) {
            if (v.getTitre().equalsIgnoreCase(titre)) {
                System.out.println("La vidéo " + titre + " a été trouvée!");
                return v;
            }
        }

        return null;
    }

    @Override
    public void supprimerVideo(String titre) throws VideoIntrouvableException, VideothequeVideException {

        Video v = rechercherVideo(titre);
        getVideotheque().remove(v);
        System.out.println("La vidéo a été supprimer");

    }

    @Override
    public void lireVideo(String titre) throws VideoIntrouvableException, VideothequeVideException, LectureImpossibleException {

        rechercherVideo(titre).//nom de la méthode pour lire ?
    }

    @Override
    public void convertirVideo(String titre, String formatCible) throws VideoIntrouvableException, VideothequeVideException, ConversionImpossibleException, SaisieInvalideException {
        // Rechercher la vidéo en rappelant la méthode au dessus
        Video video = rechercherVideo(titre);
        //instanceof..Avec le fichier qui fait la conversion
        if(!(video instanceof Convertible)) {
            throw new ConversionImpossibleException("La vidéo ne peut pas être convertie");
        }
    }
}
