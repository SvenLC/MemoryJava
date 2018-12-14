package memory.grille;

import java.util.Iterator;

import memory.cartes.IPaquet;
import memory.cartes.carte.ICarte;
import memory.cartes.carte.CarteMemory;

public abstract class Grille implements IGrille {

    protected final int NB_COLONNES = 4;
    protected final int NB_LIGNES = 4;

    private ICarte[][] grille = new CarteMemory[NB_LIGNES][NB_COLONNES];

    public Grille(IPaquet<ICarte> p) {
        this.grille = new ICarte[NB_LIGNES][NB_COLONNES];
        this.remplirDeCartes(p);

    }

    public ICarte getCarte(int x, int y) {
        return this.grille[x][y];
    }

    public ICarte getCarte(int i) {

        int x = i / 4;
        int y = i % 4;

        ICarte carte = grille[y][x];

        return carte;
    }

    public void ajouterUneCarte(int ligne, int colonne, ICarte c) {
        this.grille[ligne][colonne] = c;
    }

    public void remplirDeCartes(IPaquet<ICarte> p) {
        Iterator<ICarte> it = p.iterator();

        for (int ligne = 0; ligne < NB_LIGNES; ligne++) {
            for (int colonne = 0; colonne < NB_COLONNES; colonne++) {
                ICarte c = it.next();

                this.ajouterUneCarte(ligne, colonne, c);

            }
        }
    }
}