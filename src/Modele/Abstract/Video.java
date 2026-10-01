package Modele.Abstract;

import Modele.Lisible;

import java.time.LocalDate;

public abstract class Video implements Lisible {

    protected String titre;
    protected String realisateur;
    protected LocalDate dateSortie;
    protected int duree;

    public Video(String titre, int duree, LocalDate dateSortie, String realisateur) {
        this.titre = titre;
        this.duree = duree;
        this.dateSortie = dateSortie;
        this.realisateur = realisateur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(LocalDate dateSortie) {
        this.dateSortie = dateSortie;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public abstract String getSupport();

    @Override
    public String toString() {
        return "Video{" +
                "titre='" + titre + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", dateSortie=" + dateSortie +
                ", duree=" + duree +
                '}';
    }

}

