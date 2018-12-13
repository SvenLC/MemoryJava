package Memory.cartes;

import java.util.HashSet;

import Memory.cartes.carte.CarteMemory;
import Memory.cartes.carte.ICarte;
import Memory.Symbole;
import Memory.Couleur;
import java.util.*;

public class PaquetCarteMemory extends Paquet<ICarte>{       
    private static final int NBR_COULEURS = 4;
    private static final int NBR_MOTIFS = 2;
        
    public static HashSet<Couleur> getCouleurs() {
        HashSet<Couleur> couleurs = new HashSet<Couleur>();    
      
        while (couleurs.size() < NBR_COULEURS) {            
            int random = (int)(Math.random() * (Couleur.values().length)); 
            couleurs.add(Couleur.values()[random]);            
        }  

        return couleurs;
    } 

    public static HashSet<Symbole> getSymboles(){
       HashSet<Symbole> motifs = new HashSet<Symbole>();            
        
        while(motifs.size() < NBR_MOTIFS) {            
            int random = (int)(Math.random() * (Symbole.values().length - 1)); 
            motifs.add(Symbole.values()[random]);            
        }  

        return motifs;
    }

    public PaquetCarteMemory() {
              
        HashSet<Couleur> couleurs = getCouleurs();
        HashSet<Symbole> motifs = getSymboles();
        int i = 0;        
           
        for (Couleur couleur : couleurs) {
            for (Symbole motif : motifs) {               
                CarteMemory c1 = new CarteMemory(couleur, motif);
                CarteMemory c2 = new CarteMemory(couleur, motif);
                c1.setImage(Integer.toString(i));
                c2.setImage(Integer.toString(i));
                this.add(c1);
                this.add(c2);
                i += 1;
               
           }
        }  
        
        
        
    }

  
}
