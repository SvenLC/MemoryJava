package memory.cartes.carte;

import memory.Symbole;
import memory.Couleur;
import memory.Etat;

public class CarteMemory implements ICarte {
    private int ID;
    private Couleur couleur;
    private Symbole motif;
    private Etat etat;
    private String imageId;

    public CarteMemory() {
        super();
        this.couleur = Couleur.LIGHTGRAY;
        this.motif = Symbole.VIDE;
        this.etat = Etat.SLEEP;
        this.imageId = "";
    }

    public CarteMemory(ICarte c) {
        this.couleur = c.getCouleur();
        this.motif = c.getMotif();
        this.etat = c.getEtat();
        this.imageId = c.getImage();
    }

    public CarteMemory(Couleur couleur, Symbole motif, String imageId) {
        this.couleur = couleur;
        this.motif = motif;
        this.imageId = imageId;
        this.etat = Etat.SLEEP;

    }

    public int getId() {
        return this.ID;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public Symbole getMotif() {
        return motif;
    }

    public Etat getEtat() {
        return etat;
    }

    public String getImage() {
        return imageId;
    }

    public boolean isCompatible(ICarte c) {
        return c.getCouleur().equals(this.getCouleur()) && c.getMotif().equals(this.getMotif()) && c.getImage().equals(this.getImage());
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public void setMotif(Symbole symbole) {
        this.motif = symbole;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public void active() {
        this.etat = Etat.ACTIVE;
    }

    public void sleep() {
        this.etat = Etat.SLEEP;
    }

    public void toDisplay() {
        this.etat = Etat.VISIBLE;
    }

    public void setImage(String imageId) {
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return "Carte [Couleur = " + couleur + " Motif = " + motif + "]";
    }

}