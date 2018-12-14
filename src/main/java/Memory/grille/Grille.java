package Memory.grille;

import java.util.Iterator;

import Memory.cartes.IPaquet;
import Memory.cartes.carte.ICarte;
import Memory.cartes.carte.CarteMemory;

public abstract class Grille implements IGrille {

    protected final int NB_COLONNES = 4;
    protected final int NB_LIGNES = 4;

    private ICarte[][] grille = new CarteMemory[NB_LIGNES][NB_COLONNES];

    public Grille() {
        this.grille = new ICarte[NB_COLONNES][NB_LIGNES];
    }

    public Grille(IPaquet<ICarte> p) {
        this.grille = new ICarte[NB_LIGNES][NB_COLONNES];
        this.remplirDeCartes(p);

    }

    public ICarte getCarte(int x, int y) {
        return this.grille[x][y];
    }

    public ICarte getCarte(int x) {
        ICarte carte = null;

        switch (x) {
        case 0:
            carte = getCarte(0, 0);
            break;
        case 1:
            carte = getCarte(1, 0);
            break;
        case 2:
            carte = getCarte(2, 0);
            break;
        case 3:
            carte = getCarte(3, 0);
            break;
        case 4:
            carte = getCarte(0, 1);
            break;
        case 5:
            carte = getCarte(1, 1);
            break;
        case 6:
            carte = getCarte(2, 1);
            break;
        case 7:
            carte = getCarte(3, 1);
            break;
        case 8:
            carte = getCarte(0, 2);
            break;
        case 9:
            carte = getCarte(1, 2);
            break;
        case 10:
            carte = getCarte(2, 2);
            break;
        case 11:
            carte = getCarte(3, 2);
            break;
        case 12:
            carte = getCarte(0, 3);
            break;
        case 13:
            carte = getCarte(1, 3);
            break;
        case 14:
            carte = getCarte(2, 3);
            break;
        case 15:
            carte = getCarte(3, 3);
            break;

        default:
            break;
        }

        return carte;
    }

    
    public void ajouterUneCarte(int ligne, int colonne, ICarte c) {
        this.grille[ligne][colonne] = c;
    }

    private void remplirDeCartes(IPaquet<ICarte> p) {
        Iterator<ICarte> it = p.iterator();

        for (int ligne = 0; ligne < NB_LIGNES; ligne++) {
            for (int colonne = 0; colonne < NB_COLONNES; colonne++) {
                ICarte c = it.next();

                this.ajouterUneCarte(ligne, colonne, c);

            }

        }

    }
}