package Memory.cartes.carte;

import Memory.Symbole;
import Memory.Couleur;
import Memory.Etat;

public class CarteMemory implements ICarte {
    protected int ID;
    protected Couleur couleur;
    protected Symbole motif;
    protected Etat etat;
    protected String imageId;

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

    public CarteMemory(Couleur couleur, Symbole motif) {
        this.couleur = couleur;
        this.motif = motif;
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
        return c.getCouleur().equals(this.getCouleur()) || c.getMotif().equals(this.getMotif());
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
        return "Carte [couleur = " + couleur + " Motif = " + motif + " Etat = " + etat + " Image = " + imageId + "]";
    }

}