package modals;

import java.util.Date;

public class Reservation {
  private Date dateEmprunt;

  private Date dateRecuperation;
  private String statut;
  private Object livre;
  private Object emprunteur;

  public Reservation(Date dateEmprunt, String statut, Object livre, Object emprunteur) {
    this.dateEmprunt = dateEmprunt;
    this.statut = statut;
    this.livre = livre;
    this.emprunteur = emprunteur;
  }

  public void setDateEmprunt(Date dateEmprunt) {
    this.dateEmprunt = dateEmprunt;
  }

  public void setStatut(String statut) {
    this.statut = statut;
  }

  public void setLivre(Object livre) {
    this.livre = livre;
  }

  public Object getEmprunteur() {
    return emprunteur;
  }

  public Object getLivre() {
    return livre;
  }

  public String getStatut() {
    return statut;
  }

  public Date getDateEmprunt() {
    return dateEmprunt;
  }

  public void setEmprunteur(Object emprunteur) {
    this.emprunteur = emprunteur;
  }

  public void setDateRecuperation(Date dateRecuperation) {
    this.dateRecuperation = dateRecuperation;
  }
  public Date getDateRecuperation() {
    return dateRecuperation;
  }
}
