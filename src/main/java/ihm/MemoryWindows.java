package ihm;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MemoryWindows extends JFrame {

    private static final long serialVersionUID = 1L;

    private List<CarteJButton> liste = new ArrayList<CarteJButton>();

    private static ImageIcon image1 = new ImageIcon(
            "C:/Users/svenl/OneDrive/Documents/BTS A2/Java/Memory3/Memory/src/main/java/img/1.jpg");
    private ImageIcon image2 = new ImageIcon(
            "C:/Users/svenl/OneDrive/Documents/BTS A2/Java/Memory3/Memory/src/main/java/img/2.jpg");
    private ImageIcon image3 = new ImageIcon(
            "C:/Users/svenl/OneDrive/Documents/BTS A2/Java/Memory3/Memory/src/main/java/img/3.jpg");
    private ImageIcon image4 = new ImageIcon(
            "C:/Users/svenl/OneDrive/Documents/BTS A2/Java/Memory3/Memory/src/main/java/img/4.jpg");
    private ImageIcon image5 = new ImageIcon(
            "C:/Users/svenl/OneDrive/Documents/BTS A2/Java/Memory3/Memory/src/main/java/img/5.jpg");
    private ImageIcon image6 = new ImageIcon(
            "C:/Users/svenl/OneDrive/Documents/BTS A2/Java/Memory3/Memory/src/main/java/img/6.jpg");
    private ImageIcon image7 = new ImageIcon(
            "C:/Users/svenl/OneDrive/Documents/BTS A2/Java/Memory3/Memory/src/main/java/img/7.jpg");
    private ImageIcon image8 = new ImageIcon(
            "C:/Users/svenl/OneDrive/Documents/BTS A2/Java/Memory3/Memory/src/main/java/img/8.jpg");
    private ImageIcon back = new ImageIcon(
            "C:/Users/svenl/OneDrive/Documents/BTS A2/Java/Memory3/Memory/src/main/java/img/back.jpg");

    private Dimension taille = new Dimension(200, 200);

    public MemoryWindows(String title, Listener listener, KeyboardListener keyboardListener) {
        super("Memory Chaton !");
        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        this.setUndecorated(true);

        addWindowListener(l);
        addKeyListener(keyboardListener);

        for (int i = 0; i < 16; i++) {
            liste.add(new CarteJButton(i));

        }

        setLayout(new GridLayout(4, 4));

        back = new ImageIcon(back.getImage().getScaledInstance(210, 210, Image.SCALE_DEFAULT));
        image1 = new ImageIcon(image1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        image2 = new ImageIcon(image2.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        image3 = new ImageIcon(image3.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        image4 = new ImageIcon(image4.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        image5 = new ImageIcon(image5.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        image6 = new ImageIcon(image6.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        image7 = new ImageIcon(image7.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        image8 = new ImageIcon(image8.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));

        ListIterator<CarteJButton> it = liste.listIterator();
        while (it.hasNext()) {
            CarteJButton carte = it.next();
            carte.setIcon(back);
            carte.setPreferredSize(taille);
            carte.addActionListener(listener);
            carte.setText("Carte");
            this.add(carte);
        }

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void cacherCarte(int idCarte1, int idCarte2) {

        this.liste.get(idCarte1).setIcon(back);
        this.liste.get(idCarte2).setIcon(back);
    }

    public void voirCarte(int id, String imageId) {

        ImageIcon image = getImageById(imageId);
        this.liste.get(id).setIcon(image);

    }

    public ImageIcon getImageById(String id) {
        ImageIcon image = back;
        switch (id) {
        case "0":
            image = image1;
            break;
        case "1":
            image = image2;
            break;
        case "2":
            image = image3;
            break;
        case "3":
            image = image4;
            break;
        case "4":
            image = image5;
            break;
        case "5":
            image = image6;
            break;
        case "6":
            image = image7;
            break;
        case "7":
            image = image8;
            break;

        default:
            break;
        }
        return image;
    }
}