import Exceptions.SaisieInvalideException;
import Exceptions.VideoDejaExistanteException;
import Modele.*;
import Modele.Abstract.Video;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Main {

    private static final GestionVideotheque videotheque = new Videotheque();
    private static final Scanner scanner = new Scanner(System.in);

    private static void afficherMenu() {
        System.out.println("========== VIDEOTHEQUE ==========");
        System.out.println("1. Ajouter une vidéo");
        System.out.println("2. Lister toutes les vidéos");
        System.out.println("3. Rechercher une vidéo");
        System.out.println("4. Supprimer une vidéo");
        System.out.println("5. Lire une vidéo");
        System.out.println("6. Convertir une vidéo");
        System.out.println("0. Quitter");
    }

    static void main() {

        int choix = -1;


        do {


            try {
                afficherMenu();
                System.out.println("Choix: ");
                choix = scanner.nextInt();
                scanner.nextLine();

                switch (choix) {
                    case 1:
                        ajouterVideo();
                        break;
                    case 2:
                        videotheque.listerVideo();
                        break;
                    case 3:
                        rechercherVideo();
                        break;
                    case 4:
                        supprimerVideo();
                        break;
                    case 5:
                        lireVideo();
                        break;
                    case 6:
                        convertirVideo();
                        break;
                    case 0:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Erreur : choix invalide.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        while (choix != 0);

        scanner.close();

    }

    public static String saisieTitre() {


        System.out.println("Saisissez le nom du titre");
        String titre = scanner.nextLine();

        if (titre.isEmpty()) {
            throw new SaisieInvalideException("Il faut remplir le champ");
        }
        return titre;

    }

    public static int saisieDureeVideo() {

        System.out.println("Saisissez la durée");
        int duree = scanner.nextInt();

        scanner.nextLine();

        if (duree <= 0 ) {
            throw  new SaisieInvalideException("Il faut saisir une durée!");
        }
        return duree;
    }

    public static LocalDate saisieDateSortie() throws DataFormatException {

        System.out.println("Saisissez une date");
        String date = scanner.nextLine();
        if(!date.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
            throw new DataFormatException("La date n'est pas au format dd/mm/yyyy");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return LocalDate.parse(date, formatter);
    }

    public static String saisieRealisateur() throws SaisieInvalideException {

        System.out.println("Saisissez le nom du réalisateur");
        String realisateur = scanner.nextLine();
        if (realisateur.isEmpty()) {
            throw new SaisieInvalideException("Veuillez saisir un réalisateur!");
        }
        return realisateur;
    }

    public static String saisieChemin()  throws SaisieInvalideException {
        System.out.println("Saisissez le chemin de la vidéo !");
        String chemin = scanner.nextLine();
        if (chemin.isEmpty()) {
            throw new SaisieInvalideException("Veuillez saisir le chemin de la vidéo !");
        }
        return chemin;
    }

    public static String saisieNumero()  throws SaisieInvalideException {
        System.out.println("Saisissez le numéro de DVD ex : DVD-010");
        String numero = scanner.nextLine();
        if (numero.isEmpty()) {
            throw new SaisieInvalideException("Veuillez saisir le numéro de DVD !");
        }
        return numero;
    }

    public static int saisieZone() {
        System.out.println("Saisissez la zone géographique du DVD");
        int zone = scanner.nextInt();
        scanner.nextInt();
        if (zone <= 0 ) {
            throw  new SaisieInvalideException("Il faut saisir une durée!");
        }
        return zone;
    }

        public static DVD CreerDVD () throws SaisieInvalideException, DataFormatException {
            String titre = saisieTitre();
            int duree = saisieDureeVideo();
            LocalDate dateSortie = saisieDateSortie();
            String realisateur = saisieRealisateur();
            String numero = saisieNumero();
            int zone = saisieZone();

            DVD dvd = new DVD(titre, duree, dateSortie, realisateur, numero, zone);
            return dvd;

        }

        public static FichierMP4 CreerMP4 () throws SaisieInvalideException, DataFormatException {
            String titre = saisieTitre();
            int duree = saisieDureeVideo();
            LocalDate dateSortie = saisieDateSortie();
            String realisateur = saisieRealisateur();
            String chemin = saisieChemin();

            FichierMP4 fichierMP4 = new FichierMP4(titre, duree, dateSortie, realisateur, chemin);
            return fichierMP4;
        }

        public static FichierAVI CreerAVI () throws SaisieInvalideException, DataFormatException {
            String titre = saisieTitre();
            int duree = saisieDureeVideo();
            LocalDate dateSortie = saisieDateSortie();
            String realisateur = saisieRealisateur();
            String chemin = saisieChemin();

            FichierAVI fichierAVI = new FichierAVI(titre, duree, dateSortie, realisateur, chemin);
            return fichierAVI;
        }






    public static void ajouterVideo() throws SaisieInvalideException, VideoDejaExistanteException, DataFormatException {

        System.out.println("Type de format (1= DVD, 2= MP4, 3= AVI) : ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        Video create = null;

        switch (choix) {
            case 1:
                create = CreerDVD();
                break;
            case 2:
                create = CreerMP4();
                break;
            case 3:
                create = CreerAVI();
                break;
            default:
        }

        videotheque.ajouterVideo(create);
    }

    public static void rechercherVideo() throws Exception {
        String titre = saisieTitre();
        videotheque.rechercherVideo(titre);
    }

    public static void supprimerVideo() throws Exception {
        String titre = saisieTitre();
        videotheque.supprimerVideo(titre);
        System.out.println(">> Vidéo supprimée.");
    }

    public static void lireVideo() throws Exception {
        String titre = saisieTitre();
        videotheque.lireVideo(titre);
    }

    public static void convertirVideo() throws Exception {
        String titre = saisieTitre();
        System.out.print("Format cible (MP4, AVI) : ");
        String formatCible = scanner.nextLine();
        System.out.println(">> Conversion en cours...");
        videotheque.convertirVideo(titre, formatCible);
        System.out.println(">> Conversion terminée.");
    }








}
