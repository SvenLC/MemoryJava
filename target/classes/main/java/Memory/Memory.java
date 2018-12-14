package Memory;

import Memory.cartes.PaquetCarteMemory;
import Memory.cartes.carte.CarteMemory;
import Memory.grille.Grille;

public class Memory {
    private static Grille grille;
    private static PaquetCarteMemory paquet;

    public Memory() {

        paquet = new PaquetCarteMemory();
        paquet.melanger();

        grille = new Grille(paquet) {
        };

    }

    public boolean CheckCarte(int IdCarte1, int IdCarte2) {

        CarteMemory carte1 = null;
        CarteMemory carte2 = null;
        boolean match = false;

        carte1 = (CarteMemory) grille.getCarte(IdCarte1);
        carte2 = (CarteMemory) grille.getCarte(IdCarte2);

        if (carte1.isCompatible(carte2)) {
            grille.getCarte(IdCarte1).toDisplay();
            grille.getCarte(IdCarte2).toDisplay();
            match = true;
            System.out.println("Cartes compatible");
        } else {
            System.out.println("Pas de cartes compatible");
        }

        return match;
    }

    public void SetSleep(int carteId1, int carteId2) {

        grille.getCarte(carteId1).sleep();
        grille.getCarte(carteId2).sleep();

    }

    public void SetActive(int i) {
        grille.getCarte(i).active();
    }

    public String GetImageId(int i) {

        return grille.getCarte(i).getImage();
    }

    public Grille GetGrille() {

        return grille;
    }

}