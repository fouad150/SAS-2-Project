package models;
import java.util.ArrayList;
public class Livre {
    private int idLivre;
    private String titre;
    private int numeroISBN;
    private int quantity;

    private  String nomAuteur;//input

    private Auteur auteur;
    private ArrayList<Reservation> reservations;

    public Livre(int idLivre) {
        this.idLivre = idLivre;
    }

    public Livre(String titre, int numeroISBN, int quantity) {

        this.titre = titre;
        this.nomAuteur = nomAuteur;
        this.numeroISBN = numeroISBN;
        this.quantity = quantity;
    }
    public Livre(int idLivre,String titre, int numeroISBN, int quantity) {
        this.idLivre=idLivre;
        this.titre = titre;
        this.numeroISBN = numeroISBN;
        this.quantity = quantity;
    }

    public Livre(int idLivre,String titre, String auteur, int numeroISBN, int quantity, ArrayList<Reservation> reservations) {
        this.idLivre=idLivre;
        this.titre = titre;
        //this.auteur = auteur;
        this.numeroISBN = numeroISBN;
        this.quantity = quantity;
        this.reservations = reservations;
    }

    public void setIdLivre(int idLivre) {
        this.idLivre = idLivre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public void setNumeroISBN(int numeroISBN) {
        this.numeroISBN = numeroISBN;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }

    public int getIdLivre() {
        return idLivre;
    }

    public String getTitre() {
        return titre;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public int getNumeroISBN() {
        return numeroISBN;
    }

    public int getQuantity() {
        return quantity;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public String getNomAuteur() {
        return nomAuteur;
    }


}
