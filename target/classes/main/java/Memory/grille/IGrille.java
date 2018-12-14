package Memory.grille;

import Memory.cartes.carte.ICarte;

public interface IGrille {

    public ICarte getCarte(int x, int y);

    public ICarte getCarte(int x);

}