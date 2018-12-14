package memory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import memory.cartes.carte.CarteMemory;
import memory.Memory;

public class MemoryTest {

    private final Couleur couleur = Couleur.BLACK;
    private final Symbole motif = Symbole.ARBRE;
    private final String imageId = "1";

    private static Memory memory = new Memory();

    CarteMemory carte1 = new CarteMemory(couleur, motif, imageId);
    CarteMemory carte2 = new CarteMemory(couleur, motif, imageId);
    CarteMemory carte3 = new CarteMemory(couleur, motif, imageId);

    @Test
    public void SetSleepTest() {

        memory.GetGrille().ajouterUneCarte(0, 0, carte1);
        memory.GetGrille().ajouterUneCarte(1, 0, carte1);

        memory.SetSleep(0, 1);

        assertTrue(memory.GetGrille().getCarte(0, 0).getEtat().equals(Etat.SLEEP)
                && memory.GetGrille().getCarte(0, 1).getEtat().equals(Etat.SLEEP));

    }

    @Test
    public void SetActiveTest() {

        memory.GetGrille().ajouterUneCarte(0, 0, carte1);

        memory.SetActive(0);

        assertTrue(memory.GetGrille().getCarte(0, 0).getEtat().equals(Etat.ACTIVE));
    }

    @Test
    public void CheckCarteTrue() {

        memory.GetGrille().ajouterUneCarte(0, 0, carte1);
        memory.GetGrille().ajouterUneCarte(1, 0, carte2);

        assertTrue(memory.CheckCarte(0, 1));

    }

    @Test
    public void CheckCarteFalse() {

        carte3.setCouleur(Couleur.PINK);

        memory.GetGrille().ajouterUneCarte(2, 0, carte3);

        assertFalse(memory.CheckCarte(0, 2));

    }
}