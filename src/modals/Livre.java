package modals;

public class Livre {
    private String titre;
    private String auteur;
    private int numeroISBN;
    private int quantity;
    private Object[] reservations;

    public Livre(String titre, String auteur, int numeroISBN, int quantity) {
        this.titre = titre;
        this.auteur = auteur;
        this.numeroISBN = numeroISBN;
        this.quantity = quantity;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setNumeroISBN(int numeroISBN) {
        this.numeroISBN = numeroISBN;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setReservations(Object[] reservations) {
        this.reservations = reservations;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getNumeroISBN() {
        return numeroISBN;
    }

    public int getQuantity() {
        return quantity;
    }
}
