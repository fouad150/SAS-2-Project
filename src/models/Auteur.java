package models;
import java.util.ArrayList;
public class Auteur {
    private int idAuteur;
    private String nomAuteur;
    private String notionaliteAuteur;
    private ArrayList<Livre> livres;

    public Auteur(String nomAuteur, String notionaliteAuteur) {
        this.nomAuteur = nomAuteur;
        this.notionaliteAuteur = notionaliteAuteur;
    }

    public void setIdAuteur(int idAuteur) {
        this.idAuteur = idAuteur;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }

    public void setNotionaliteAuteur(String notionaliteAuteur) {
        this.notionaliteAuteur = notionaliteAuteur;
    }

    public void setLivres(ArrayList<Livre> livres) {
        this.livres = livres;
    }

    public String getNomAuteur() {
        return nomAuteur;
    }

    public int getIdAuteur() {
        return idAuteur;
    }

    public String getNotionaliteAuteur() {
        return notionaliteAuteur;
    }

    public ArrayList<Livre> getLivres() {
        return livres;
    }
}
