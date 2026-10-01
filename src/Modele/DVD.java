package Modele;

import Modele.Abstract.Video;
import java.time.LocalDate;

public class DVD extends Video {

    private String numero;
    private int zone;

    DVD(String titre, int duree, LocalDate dateSortie, String realisateur, String numero, int zone) {
        super(titre, duree, dateSortie, realisateur);
        this.numero = numero;
        this.zone = zone;
    }

    public void lire() {
        return "Prenez le DVD " + this.numero + "\"" + this.titre + "\" et insérez-le dans un lecteur zone " + this.zone + ".";
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
    public String getSupport() {
        return "";
    }

    @Override
    public String toString() {
        return "DVD{" +
                "numero='" + numero + '\'' +
                ", zone=" + zone +
                '}';
    }
}
