package memory.grille;

import memory.cartes.IPaquet;
import memory.cartes.carte.ICarte;

public interface IGrille {

    public ICarte getCarte(int x, int y);

    public ICarte getCarte(int x);

    public void ajouterUneCarte(int ligne, int colonne, ICarte c);

    public void remplirDeCartes(IPaquet<ICarte> p);

}