package Memory;

public enum Symbole {
    MAISON("maison"), BALLON("ballon"), FANION("fanion"), DIAMANT("diamant"), ARBRE("arbres"), ETOILE("étoile"), LAPIN("lapins"), RADIS("*radis"), DINDON("dindon"), VIDE("*vide*");

    private String affichage; // 6 caractères différents

    private Symbole(String affichage) {
        this.affichage = affichage;
    }

    @Override
    public String toString() {
        return affichage;
    }

    public static String getStringFromSymbole(Symbole motif) {
        String m = motif.affichage;
 
        return m;
 
        
    }

    public static Symbole getSymboleFromString(String motif) {
        Symbole enumSymbole = null;

        for (Symbole s : Symbole.values()) {
            if(s.affichage.equals(motif)) {
                enumSymbole = s;
            }

        }

        return enumSymbole;
    }
  
}