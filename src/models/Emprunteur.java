package models;
import java.util.ArrayList;
public class Emprunteur {
    private int idEmprunteur;
    private String nomEmprunteur;
    private int codeEmprunteur;
    private ArrayList<Reservation> reservations;

    public Emprunteur(String nomEmprunteur, int codeEmprunteur) {
        this.nomEmprunteur = nomEmprunteur;
        this.codeEmprunteur = codeEmprunteur;
    }

    public Emprunteur(int idEmprunteur,String nomEmprunteur, int codeEmprunteur) {
        this.idEmprunteur=idEmprunteur;
        this.nomEmprunteur = nomEmprunteur;
        this.codeEmprunteur = codeEmprunteur;
    }

    public Emprunteur(int idEmprunteur,String nomEmprunteur, int codeEmprunteur, ArrayList<Reservation> reservations) {
        this.idEmprunteur=idEmprunteur;
        this.nomEmprunteur = nomEmprunteur;
        this.codeEmprunteur = codeEmprunteur;
        this.reservations = reservations;
    }

    public void setIdEmprunteur(int idEmprunteur) {
        this.idEmprunteur = idEmprunteur;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void setCodeEmprunteur(int codeEmprunteur) {
        this.codeEmprunteur = codeEmprunteur;
    }

    public void setNomEmprunteur(String nomEmprunteur) {
        this.nomEmprunteur = nomEmprunteur;
    }

    public int getIdEmprunteur() {
        return idEmprunteur;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public int getCodeEmprunteur() {
        return codeEmprunteur;
    }

    public String getNomEmprunteur() {
        return nomEmprunteur;
    }
}
