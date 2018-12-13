package Memory;

public enum Etat {
    ACTIVE("Activé"), SLEEP("Non visible"), VISIBLE("Visible");

    private String affichage;

    private Etat(String affichage) {
        this.affichage = affichage;
    }

    public static Etat getEtatFromString(String etatStr) {
        Etat etat = null;

        for (Etat e : Etat.values()) {
            if (e.affichage.equals(etatStr)) {
                etat = e;
            }

        }

        return etat;
    }

    @Override
    public String toString() {
        return affichage;
    }

}