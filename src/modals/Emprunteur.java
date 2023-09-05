package modals;

public class Emprunteur {
    private String nomEmprunteur;
    private int codeEmprunteur;
    private Object[] reservations;

    public Emprunteur(String nomEmprunteur, int codeEmprunteur) {
        this.nomEmprunteur = nomEmprunteur;
        this.codeEmprunteur = codeEmprunteur;
    }

    public void setReservations(Object[] reservations) {
        this.reservations = reservations;
    }

    public void setCodeEmprunteur(int codeEmprunteur) {
        this.codeEmprunteur = codeEmprunteur;
    }

    public void setNomEmprunteur(String nomEmprunteur) {
        this.nomEmprunteur = nomEmprunteur;
    }

    public Object[] getReservations() {
        return reservations;
    }

    public int getCodeEmprunteur() {
        return codeEmprunteur;
    }

    public String getNomEmprunteur() {
        return nomEmprunteur;
    }
}
