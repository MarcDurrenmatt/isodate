package deqo.isodate;

/**
 * Classe représentant un numéro de jour dans l'année.
 *
 * Le parsing et le pretty-printing suivent le standard ISO 8601 YYYY-DDD
 */
public class IsoDays {

    /**
     * Année.
     */
    private int year;

    /**
     * Numéro du jour dans l'année (nombre supérieur ou égal à 1).
     */
    private int days;

    public static final int Y_SIZE = 4;

    public IsoDays(int year, int days) {
        this.year = year;
        this.days = days;
    }

    /**
     * Construit un jour de l'année.
     *
     * @param date la date au format YYYY-DDD
     */
    public IsoDays(String date) throws IsoDateException {
        if (!date.matches("^[0-9]{4}-[0-9]{3}$")) {
            throw new IsoDateException();
        }
        year = Integer.parseInt(date.substring(0, Y_SIZE));
        days = Integer.parseInt(date.substring(Y_SIZE + 1));
    }

    /**
     * Renvoie le jour en ISO 8601.
     *
     * @return chaîne au format YYYY-DDD
     */
    @Override
    public String toString() {
        return String.format("%04d-%03d", year, days);
    }
}
