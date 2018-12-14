package ihm;

import javax.swing.JButton;

public class CarteJButton extends JButton {
    
    private static final long serialVersionUID = 1L;

    private int Id;

    public CarteJButton(int Id) {
        super();
        this.Id = Id;
    }

    public int getId() {

        return this.Id;
    }

}