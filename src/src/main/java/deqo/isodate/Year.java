package deqo.isodate;

/**
 * Classe représentant une année
 */
public class Year {

    /**
     * Année
     */
    private int year;

    /**
     * Récupère l'année
     * @return année
     */
    public int getYear() {
        return year;
    }

    public Year(int year) {
        this.year = year;
    }

    /** Calcule si l'année est bissextile
     *
     * @return true s'il s'agit d'une année bissextile
     */
    public boolean isLeapYear() {
        return ((year % 4 == 0) && (year % 100 != 0)) || year % 400 == 0;
    }
}
