package memory.cartes.carte;

import memory.Symbole;
import memory.Etat;
import memory.Couleur;

public interface ICarte {

    public void active();

    public void sleep();

    public void toDisplay();

    public boolean isCompatible(ICarte c);

    public Couleur getCouleur();

    public Symbole getMotif();

    public Etat getEtat();

    public String getImage();

}