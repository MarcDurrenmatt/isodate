package deqo.isodate;

/**
 * Classe représentant un jour de l'année.
 *
 * Le parsing et le pretty-printing suivent le standard ISO 8601 YYYY-MM-DD
 */
public class IsoDate {

    /**
     * Année.
     */
    private int year;

    /**
     * Mois (nombre entre 1 et 12).
     */
    private int month;

    /**
     * Numéro du jour (nombre entre 1 et 31).
     */
    private int day;

    public static final int Y_SIZE = 4;
    public static final int M_SIZE = 2;

    public IsoDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /** Construit un jour de l'année.
     *
     * @param date la date au format YYYY-MM-DD
     */
    public IsoDate(String date) throws IsoDateException {
        if (!date.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$")) {
            throw new IsoDateException();
        }
        year = Integer.parseInt(date.substring(0, Y_SIZE));
        month = Integer.parseInt(date.substring(Y_SIZE + 1, Y_SIZE + 1 + M_SIZE));
        day = Integer.parseInt(date.substring(Y_SIZE + 1 + M_SIZE + 1));
    }

    /** Renvoie le jour en ISO 8601.
     *
     * @return chaîne au format YYYY-MM-DD
     */
    @Override
    public String toString() {
        return String.format("%d-%d-%d", year, month, day);
    }

    /** Calcule le nombre de jours écoulés depuis le 1er janvier.
     *
     * @return numéro du jour dans l'année depuis le 1er janvier
     */
    private int days_of_year() {
        final int[] months = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        final int leapFeb = 29;
        final int noLeapFeb = 28;
        boolean leap = new Year(year).isLeapYear();
        int days = 0;
        for (int i = 1; i < month; i++) {
            days += (i != 2 ? months[i - 1] : (leap? leapFeb : noLeapFeb));
        }
        return day + days;
    }

    /** Construit un objet IsoDays à partir de l'objet IsoDate ambient.
     *
     * @return objet IsoDays représentant le même jour
     */
    public IsoDays toIsoDays() {
        return new IsoDays(year, days_of_year());
    }
}
