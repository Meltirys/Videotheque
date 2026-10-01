package Modele;

import Modele.Abstract.Video;
import java.time.LocalDate;

public class DVD extends Video {

    private String numero;
    private int zone;

    public DVD(String titre, String realisateur, LocalDate dateSortie, int duree, String numero, int zone) {
        super(titre, realisateur, dateSortie, duree);
        this.numero = numero;
        this.zone = zone;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "numero='" + numero + '\'' +
                ", zone=" + zone +
                '}';
    }
}
