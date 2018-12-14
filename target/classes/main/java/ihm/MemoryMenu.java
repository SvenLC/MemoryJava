package ihm;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MemoryMenu extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final Font menuFont = new Font(Font.DIALOG, Font.BOLD, 30);

    public MemoryMenu(String title, Listener listener) {
        super("Memory Chaton !");

        setLayout(new GridLayout(7, 1));

        JButton continuer = new JButton("Continuer");
        JButton sauvegarder = new JButton("Sauvegarder");
        JButton nouvellePartie = new JButton("Nouvelle partie");
        JButton charger = new JButton("Charger");
        JButton score = new JButton("Score");
        JButton aide = new JButton("Aide");
        JButton quitter = new JButton("Quitter");

        continuer.setFont(menuFont);
        sauvegarder.setFont(menuFont);
        nouvellePartie.setFont(menuFont);
        charger.setFont(menuFont);
        score.setFont(menuFont);
        aide.setFont(menuFont);
        quitter.setFont(menuFont);

        add(continuer);
        add(sauvegarder);
        add(nouvellePartie);
        add(charger);
        add(score);
        add(aide);
        add(quitter);

        setUndecorated(true);

        quitter.addActionListener(listener);

        setFocusable(true);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

}