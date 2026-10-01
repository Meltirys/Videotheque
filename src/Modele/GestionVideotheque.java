package Modele;

import Exceptions.*;
import Modele.Abstract.Video;

public interface GestionVideotheque {

    void ajouterVideo(Video v) throws VideoDejaExistanteException, SaisieInvalideException;

    void listerVideo() throws VideothequeVideException;

    Video rechercherVideo(String titre) throws VideothequeVideException, VideoIntrouvableException;

    void supprimerVideo(String titre) throws VideoIntrouvableException, VideothequeVideException;

    void lireVideo(String titre) throws VideoIntrouvableException, VideothequeVideException, LectureImpossibleException;

    void convertirVideo(String titre, String formatCible)
            throws VideoIntrouvableException, VideothequeVideException, ConversionImpossibleException, SaisieInvalideException;

}
