package models;

import java.util.Date;

public class Reservation {
  private int idReservation;
  private String dateEmprunt;
  private String dateRecuperation;
  private String statut;
  private Livre livre;
  private Emprunteur emprunteur;

  public Reservation(String dateEmprunt, String dateRecuperation, String statut) {
    this.dateEmprunt = dateEmprunt;
    this.dateRecuperation = dateRecuperation;
    this.statut = statut;
  }

  public Reservation(int idReservation,String dateEmprunt, String dateRecuperation, String statut) {
    this.idReservation = idReservation;
    this.dateEmprunt = dateEmprunt;
    this.dateRecuperation = dateRecuperation;
    this.statut = statut;
  }

  public Reservation(int idReservation,String dateEmprunt, String statut, Livre livre, Emprunteur emprunteur) {
    this.idReservation = idReservation;
    this.dateEmprunt = dateEmprunt;
    this.statut = statut;
    this.livre = livre;
    this.emprunteur = emprunteur;
  }

  public void setDateEmprunt(String dateEmprunt) {
    this.dateEmprunt = dateEmprunt;
  }

  public void setStatut(String statut) {
    this.statut = statut;
  }

  public void setLivre(Livre livre) {
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

  public String getDateEmprunt() {
    return dateEmprunt;
  }

  public void setEmprunteur(Emprunteur emprunteur) {
    this.emprunteur = emprunteur;
  }

  public void setDateRecuperation(String dateRecuperation) {
    this.dateRecuperation = dateRecuperation;
  }
  public String getDateRecuperation() {
    return dateRecuperation;
  }
}
