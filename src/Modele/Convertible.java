package Modele;

public interface Convertible {

    // Convertir au format MP4 ou AVI et renvoi le nouvel objet.
    // Le fichier d'origine est conservé
    FichierVideo convertir(String formatCible);


}
