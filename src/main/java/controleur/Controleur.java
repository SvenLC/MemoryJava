package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import Memory.Etat;
import Memory.Memory;
import Memory.cartes.carte.CarteMemory;
import Memory.cartes.carte.ICarte;
import Memory.grille.Grille;
import ihm.CarteJButton;
import ihm.KeyboardListener;
import ihm.Listener;
import ihm.MemoryMenu;
import ihm.MemoryWindows;

public class Controleur {

    private static ICarte carte1;
    private static ICarte carte2;
    private static int x1 = 0;
    private static int y1 = 0;
    private static int x2 = 0;
    private static int y2 = 0;
    private static MemoryWindows fenetre;
    private static MemoryMenu menu;
    private static Listener listener;
    private static KeyboardListener keyboardListener;
    private Memory memory;
    private boolean victoire;
    private int compteur = 0;
    private int idCarte1 = -1;
    private int idCarte2 = -1;

    public Controleur() {

        memory = new Memory();
        listener = new Listener(this);
        keyboardListener = new KeyboardListener(this);
        fenetre = new MemoryWindows("Memory", listener, keyboardListener);
        fenetre.setFocusable(true);
        fenetre.requestFocusInWindow();

    }

    public void GererClick(ActionEvent e) {

        if (idCarte1 != -1 && idCarte2 != -1) {
            if (!memory.CheckCarte(idCarte1, idCarte2)) {
                memory.SetSleep(idCarte1, idCarte2);
                fenetre.CacherCarte(idCarte1, idCarte2);
            }

            idCarte1 = -1;
            idCarte2 = -1;

        }

        int i = ((CarteJButton) e.getSource()).getId();

        if (idCarte1 == -1) {
            idCarte1 = i;
            memory.SetActive(i);
            String imageId = memory.GetImageId(i);
            fenetre.voirCarte(i, imageId);
        } else {
            idCarte2 = i;

            memory.SetActive(i);
            String imageId = memory.GetImageId(i);
            fenetre.voirCarte(i, imageId);

        }

        fenetre.requestFocusInWindow();

    }

    public void OuvrirMenu(KeyEvent e) {

        menu = new MemoryMenu("Menu", listener);

        menu.requestFocusInWindow();
        menu.setFocusable(true);
        menu.requestFocusInWindow();
    }

    public void Quitter() {
        // Vérifier que toutes les connexions soient fermées et tout ça et tout ça !!!!!

        System.exit(0);
    }

    public boolean autoMemory(Grille grille) {

        victoire = false;

        System.out.println("Choix de la carte 1");
        do {
            carte1 = new CarteMemory(grille.getCarte(x1, y1));
            if (carte1.getEtat().equals(Etat.SLEEP)) {
                System.out.println("X=" + x1 + " Y=" + y1 + carte1.toString());
            } else {
                if (x1 < 3) {
                    x1++;
                } else {
                    x1 = 0;
                    if (y1 < 3) {
                        y1++;
                    }
                }
            }

        } while (!carte1.getEtat().equals(Etat.SLEEP));
        grille.getCarte(x1, y1).active();

        System.out.println("Choix de la carte 2");

        do {
            carte2 = new CarteMemory(grille.getCarte(x2, y2));
            if (carte2.getEtat().equals(Etat.SLEEP)) {

                System.out.println("X=" + x2 + " Y=" + y2 + carte2.toString());
            } else {
                if (x2 < 3) {
                    x2++;
                } else {
                    x2 = 0;
                    if (y2 < 3) {
                        y2++;
                    }
                }
            }

        } while (!carte2.getEtat().equals(Etat.SLEEP));

        grille.getCarte(x2, y2).active();

        int a1 = x1;
        int b1 = y1;
        int a2 = x2;
        int b2 = y2;

        if (carte1.getCouleur() == carte2.getCouleur() && carte1.getMotif() == carte2.getMotif()) {
            grille.getCarte(a1, b1).toDisplay();
            grille.getCarte(a2, b2).toDisplay();
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
            System.out.println("Les cartes ne correspondent pas");
            if (x2 < 3) {
                x2++;
            } else {
                x2 = 0;
                if (y2 < 3) {
                    y2++;
                }
            }
        }

        if (compteur == 8) {
            victoire = true;
        }

        return victoire;

    }

}