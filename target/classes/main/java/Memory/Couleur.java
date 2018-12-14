package Memory;

import java.awt.Color;

public enum Couleur {
    BLUE("bleu", Color.blue), ORANGE("orange", Color.orange), CYAN("cyan", Color.cyan), BLACK("noire", Color.black),
    LIGHTGRAY("Gris clair", Color.lightGray), RED("Rouge", Color.red), PINK("Rose", Color.pink);

    private String couleur;
    private Color color;

    private Couleur(String couleur, Color color) {
        this.couleur = couleur;
        this.color = color;
    }

    public String getCouleur() {
        return couleur;
    }

    public Color getColor() {
        return color;
    }

    public static Color getColorFromCouleur(String couleur) {
        Color color = null;
        for (Couleur c : Couleur.values()) {
            if (c.couleur == couleur) {
                color = c.color;
            }

        }
        return color;
    }

    public static String getStringFromColor(Color color) {
        String couleur = null;

        for (Couleur c : Couleur.values()) {
            if (c.color.equals(color)) {
                couleur = c.couleur;
            }
        }

        return couleur;
    }

    public static Couleur getCouleurFromString(String couleurStr) {
        Couleur couleur = null;

        for (Couleur c : Couleur.values()) {
            if (c.couleur.equals(couleurStr)) {
                couleur = c;
            }
        }

        return couleur;
    }

    @Override
    public String toString() {
        return couleur;
    }

}