package Memory;

import Memory.cartes.PaquetCarteMemory;
import Memory.cartes.carte.CarteMemory;
import Memory.grille.Grille;

public class Memory {
    private static Grille grille;
    private static PaquetCarteMemory paquet;

    public Memory() {

        PaquetCarteMemory paquet = new PaquetCarteMemory();
        paquet.melanger();

        Grille grille = new Grille(paquet) {
        };

        this.grille = grille;
        this.paquet = paquet;

    }

    public boolean checkCarte(int IdCarte1, int IdCarte2) {

        CarteMemory carte1 = null;
        CarteMemory carte2 = null;
        boolean match = false;

        carte1 = (CarteMemory) grille.getCarte(IdCarte1);
        carte2 = (CarteMemory) grille.getCarte(IdCarte2);

        if (carte1.getImage().equals(carte2.getImage())) {
            grille.getCarte(IdCarte1).toDisplay();
            grille.getCarte(IdCarte2).toDisplay();
            match = true;
            System.out.println("Cartes compatible");
        } else {
            System.out.println("Pas de cartes compatible");
        }

        return match;
    }

    public void setSleep(int carteId1, int carteId2) {

        grille.getCarte(carteId1).sleep();
        grille.getCarte(carteId2).sleep();

    }

    public void setActive(int i) {
        grille.getCarte(i).active();
    }

    public String getImageId(int i) {

        return grille.getCarte(i).getImage();
    }

}