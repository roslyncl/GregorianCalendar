import java.time.DayOfWeek;

public enum Weekday {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public Weekday next() {
        Weekday[] all = values();
        int nextIndex = (this.ordinal() + 1) % all.length;
        return all[nextIndex];
    }

    public static Weekday from(DayOfWeek dayOfWeek) {
        return values()[dayOfWeek.getValue() - 1];
    }
}
