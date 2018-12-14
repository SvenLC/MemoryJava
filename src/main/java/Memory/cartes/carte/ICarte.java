package Memory.cartes.carte;

import Memory.Symbole;
import Memory.Etat;
import Memory.Couleur;

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