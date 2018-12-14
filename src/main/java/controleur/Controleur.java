package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import ihm.CarteJButton;
import ihm.KeyboardListener;
import ihm.Listener;
import ihm.MemoryMenu;
import ihm.MemoryVictory;
import ihm.MemoryWindows;
import memory.Memory;

public class Controleur {

    private Memory memory;
    // Windows
    private MemoryWindows fenetre;
    private MemoryMenu menu;
    private MemoryVictory victory;
    // Listener
    private Listener listener;
    private KeyboardListener keyboardListener;
    // Card Id
    private int idCarte1 = -1;
    private int idCarte2 = -1;

    public Controleur() throws InterruptedException {

        memory = new Memory();
        memory.autoPlay();

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

        if (memory.isVictory()) {

            victory = new MemoryVictory("Vitoire !", listener);

            victory.requestFocusInWindow();
        }

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

}