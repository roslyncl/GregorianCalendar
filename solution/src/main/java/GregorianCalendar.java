import exception.InvalidYearException;

import java.time.LocalDate;
import java.time.Year;

public class GregorianCalendar {
    private static final int MIN_YEAR = 1600;

    private final int year;

    public GregorianCalendar(int year) {
        if (year <= MIN_YEAR) {
            throw new InvalidYearException("Year incorrect: " + year + " <= " + MIN_YEAR);
        }
        this.year = year;
    }

    public boolean isLeap() {
        return Year.isLeap(year);
    }

    public Weekday getFirstDayOfWeek() {
        return Weekday.from(LocalDate.of(year, 1, 1).getDayOfWeek());
    }

    public CalendarYear getCalendarYear() {
        return new CalendarYear(getFirstDayOfWeek(), isLeap());
    }
}