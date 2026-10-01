package Modele;

import Exceptions.*;
import Modele.Abstract.Video;

import java.util.ArrayList;

public class GestionVideotheque {

    private static ArrayList<Video> videotheque =new ArrayList<>();

    public static ArrayList getVideotheque() {
        return videotheque;
    }

    void ajouterVideo(Video v) throws VideoDejaExistanteException, SaisieInvalideException {

        //TODO : Vérifier l'existance de la video et exception si c'est le cas
        //TODO : Ajouter la video si non existante
        try {
            rechercherVideo(v.getTitre());
        } catch (VideothequeVideException | VideoIntrouvableException e) {
            videotheque.add(v);
            System.out.println("La video a été ajouter avec succès!");
            return;
        }
        throw new VideoDejaExistanteException("Cette vidéo existe déjà!");
    }

    void listerVideo() throws VideothequeVideException {

        if (videotheque.isEmpty()) {
            throw new VideothequeVideException("La vidéothèque est vide!");
        }
        for (Video v = getVideotheque()) {
            System.out.println(v);
        }

    }

    void rechercherVideo(String titre) throws VideothequeVideException, VideoIntrouvableException {

    }

    void supprimerVideo(String titre) throws VideoIntrouvableException, VideothequeVideException {

    }

    void lireVideo(String titre) throws VideoIntrouvableException, VideothequeVideException, LectureImpossibleException {

    }

    void convertirVideo(String titre, String formatCible)
            throws VideoIntrouvableException, VideothequeVideException, ConversionImpossibleException, SaisieInvalideException {

    }
}
