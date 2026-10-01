import Exceptions.SaisieInvalideException;
import Exceptions.VideoDejaExistanteException;
import Modele.Abstract.Video;
import Modele.GestionVideotheque;
import Modele.Videotheque;

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

                        break;
                    case 6:

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

    public String saisieTitre() {


        System.out.println("Saisissez le nom du titre");
        String titre = scanner.nextLine();

        if (titre.isEmpty()) {
            throw new SaisieInvalideException("Il faut remplir le champ");
        }
        return titre;

    }

    public int dureeVideo() {

        System.out.println("Saisissez la durée");
        int duree = scanner.nextInt();

        scanner.nextLine();

        if (duree <= 0 ) {
            throw  new SaisieInvalideException("Il faut saisir une durée!");
        }
        return duree;
    }

    public LocalDate dateSortie() throws DataFormatException {

        System.out.println("Saisissez une date");
        String date = scanner.nextLine();
        if(!date.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
            throw new DataFormatException("La date n'est pas au format dd/mm/yyyy");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return LocalDate.parse(date, formatter);
    }

    public String realisateur() {

        System.out.println("Saisissez le nom du réalisateur");
        String realisateur = scanner.nextLine();
        if (realisateur.isEmpty()) {
            throw new SaisieInvalideException("Veuillez saisir un réalisateur!");
        }
        return realisateur;
    }

    public void ajouterVideo() throws SaisieInvalideException, VideoDejaExistanteException {

        System.out.println("Type de format (1= DVD, 2= MP4, 3= AVI) : ");
        int choix = scanner.nextInt();

        Video create = null;

        switch (choix) {
            case 1:
                create = creerDVD();
                break;
            case 2:
                create = creerMP4();
                break;
            case 3:
                create = creerAVI();
                break;
            default:
        }

        videotheque.ajouterVideo(create);
    }








}
