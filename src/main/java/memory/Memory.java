package memory;

import memory.cartes.PaquetCarteMemory;
import memory.cartes.carte.CarteMemory;
import memory.cartes.carte.ICarte;
import memory.grille.Grille;
import memory.grille.IGrille;

public class Memory {
    private static IGrille grille;
    private static PaquetCarteMemory paquet;
    private boolean victory;

    public Memory() {

        paquet = new PaquetCarteMemory();
        paquet.melanger();

        grille = new Grille(paquet){};

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

    public boolean isVictory(){

        for (int i = 0; i < 16; i++) {
            ICarte carte = grille.getCarte(i);

            if(carte.getEtat().equals(Etat.SLEEP)) {
                victory = false;
                i = 16;
            }
        }

        return victory;
    }

    public IGrille GetGrille() {

        return grille;
    }

}