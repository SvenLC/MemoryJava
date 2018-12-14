package ihm;

import javax.swing.JFrame;

public class MemoryVictory extends JFrame {

    private static final long serialVersionUID = 1L;

    public MemoryVictory(String title, Listener listener) {

        
        setFocusable(true);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

}