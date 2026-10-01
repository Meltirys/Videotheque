import Modele.GestionVideotheque;
import Modele.Videotheque;

import java.util.Scanner;

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

        int choix = 1;


        do {
            afficherMenu();

            try {
                choix = scanner.nextInt();
                afficherMenu();

                switch (choix) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

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
            }

        }
    }


}
