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

    private static int x = 0;
    private static int y = 0;  
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
        
        CarteMemory carte1 = (CarteMemory)grille.getCarte(x);
        CarteMemory carte2 = (CarteMemory)grille.getCarte(y);   
        
        while(!victoire) {  
            Thread.sleep(1000);
          
            carte1 = (CarteMemory)grille.getCarte(x);  
            carte2 = (CarteMemory)grille.getCarte(y);    

            while(!carte1.getEtat().equals(Etat.SLEEP)) {
               
                x++;
                carte1 = (CarteMemory)grille.getCarte(x);                  

            }  
            grille.getCarte(x).active();         

            while(!carte2.getEtat().equals(Etat.SLEEP)) { 

                y++;
                carte2 = (CarteMemory)grille.getCarte(y);                   
                      
            }
            grille.getCarte(y).active();
            
            

            
            //System.out.println("Carte 1 : X=" + x + " Y=" + y + " Carte 2 : X=" + x2 + " Y=" + y2);
            System.out.println(carte1.toString() + "\n" + carte2.toString());           
            
            

            if (carte1.isCompatible(carte2)) {                
                grille.getCarte(x).toDisplay();
                grille.getCarte(y).toDisplay();                
                System.out.println("Les cartes correspondent");

                y = x;
                compteur++;
            } 

            else {
                SetSleep(x, y);                
                System.out.println("Les cartes ne correspondent pas");

                if(y == 15) {
                    y = 0;
                    if(x < 15) {
                        x++;
                    }
                }
                else {
                    y++;
                }              
            }

            if (compteur == 8) {
                victoire = true;                
                System.out.println("Victoire !");
            }

        }

        return victoire;

    }

}