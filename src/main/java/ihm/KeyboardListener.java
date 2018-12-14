package ihm;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controleur.Controleur;

public class KeyboardListener implements KeyListener {

    private  Controleur controleur;

    public KeyboardListener(Controleur controleur) {

        this.controleur = controleur;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        // if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
        System.out.println("Youhou !");
        controleur.OuvrirMenu(e);

        // }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}