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

    private static ICarte carte1;
    private static ICarte carte2;
    private static int x1 = 0;
    private static int y1 = 0;
    private static int x2 = 0;
    private static int y2 = 0;
    private int compteur = 0;
    private boolean victoire;

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

    public boolean autoPlay() throws InterruptedException {
        victoire = false;
        
        
        while(!victoire) {   

            carte1 = grille.getCarte(x1, y1);
            carte2 = grille.getCarte(x2, y2);

              

            while (!carte1.getEtat().equals(Etat.SLEEP) ){
                carte1 = grille.getCarte(x1, y1);
                
                               
                if (x1 < 3) {
                    x1++;
                } else {
                    x1 = 0;
                    if (y1 < 3) {
                        y1++;
                    }
                }               

            } 
            grille.getCarte(x1, y1).active();

            while (!carte2.getEtat().equals(Etat.SLEEP)) {
                carte2 = grille.getCarte(x2, y2);
               
                if (x2 < 3) {
                    x2++;
                } else {
                    x2 = 0;
                    if (y2 < 3) {
                        y2++;
                    }
                }              

            }
            grille.getCarte(x2, y2).active();

            //Thread.sleep(500);
            System.out.println("Carte 1 : X=" + x1 + " Y=" + y1 + " Carte 2 : X=" + x2 + " Y=" + y2);
            System.out.println(carte1.toString() + "\n" + carte2.toString());
            

            
                

            
            int a1 = x1;
            int b1 = y1;
            int a2 = x2;
            int b2 = y2;

            if (carte1.isCompatible(carte2)) {
                grille.getCarte(a1, b1).toDisplay();
                grille.getCarte(a2, b2).toDisplay();
                //Thread.sleep(500);
                System.out.println("Les cartes correspondent");
                if (x1 < 3) {
                    x1++;
                } else {
                    x1 = 0;
                    if (y1 < 3) {
                        y1++;
                    }
                }
                x2 = x1;
                y2 = y1;

                compteur++;
            } else {
                grille.getCarte(a1, b1).sleep();
                grille.getCarte(a2, b2).sleep();
                //Thread.sleep(500);
                System.out.println("Les cartes ne correspondent pas");
                if (x2 < 3) {
                    x2++;
                } else {
                    x2 = 0;
                    if (y2 < 3) {
                        y2++;
                    }
                    else {
                        y2 = 0;
                    }
                }
            }

            if (compteur == 8) {
                victoire = true;
                //Thread.sleep(500);
                System.out.println("Victoire !");
            }

        }

        

        return victoire;

    }

}