package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controleur.Controleur;

public class Listener implements ActionListener {

    public Controleur controleur;

    public Listener(Controleur controleur) {
        super();
        this.controleur = controleur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // ((JButton)e.getSource()).getText();
        int event = e.getModifiers();
        String BText = ((JButton) e.getSource()).getText();

        if (event == ActionEvent.MOUSE_EVENT_MASK) {

            switch (BText) {
            case "Carte":
                controleur.GererClick(e);
                break;
            case "Quitter":
                controleur.Quitter();
                break;
            default:
                break;
            }

        }

        // System.out.println(e.toString());
    }
}