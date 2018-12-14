package memory;

import memory.cartes.carte.CarteMemory;
import controleur.Controleur;
import dao.CarteDAO;

public class App {
    public static void main(String[] args) {
        new Controleur();

        CarteMemory c = CarteDAO.getInstance().read(1);
        System.out.println(c.toString());
        CarteDAO.getInstance().create(c);
    }
}
