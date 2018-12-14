package Memory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Memory.cartes.carte.CarteMemory;

public class CarteMemoryTest {

    private final Couleur couleur = Couleur.BLACK;
    private final Symbole motif = Symbole.ARBRE;
    private final String imageId = "1";

    CarteMemory carte1 = new CarteMemory(couleur, motif, imageId);
    CarteMemory carte2 = new CarteMemory(couleur, motif, imageId);

    @Test
    public void CarteCompatible() {
        assertTrue(carte1.isCompatible(carte2));
    }

    @Test
    public void CouleurDifferente() {

        carte2.setCouleur(Couleur.BLUE);

        assertFalse(carte1.isCompatible(carte2));
    }

    @Test
    public void SymboleDifferent() {

        carte2.setMotif(Symbole.BALLON);

        assertFalse(carte1.isCompatible(carte2));
    }

    @Test
    public void ImageDifferente() {

        carte2.setImage("2");

        assertFalse(carte1.isCompatible(carte2));
    }

    @Test
    public void CouleurSymboleDifferents() {

        carte2.setCouleur(Couleur.CYAN);
        carte2.setMotif(Symbole.ETOILE);

        assertFalse(carte1.isCompatible(carte2));
    }

    @Test
    public void CouleurSymboleImageDifferent() {
        carte2.setCouleur(Couleur.ORANGE);
        carte2.setMotif(Symbole.RADIS);
        carte2.setImage("3");

        assertFalse(carte1.isCompatible(carte2));
    }

}