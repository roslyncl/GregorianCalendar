import java.util.ArrayList;
import java.util.List;

public class Month {

    private final String name;
    private final List<Weekday> days;

    public Month(String name, Weekday firstDay, int dayInMonth) {
        this.name = name;
        this.days = buildDays(firstDay, dayInMonth);
    }

    private List<Weekday> buildDays(Weekday firstDay, int dayInMonth) {
        List<Weekday> days = new ArrayList<>();
        Weekday current = firstDay;

        for(int day=1; day<=dayInMonth; day++) {
            days.add(current);
            current=current.next();
        }
        return days;
    }

    public String getName() {
        return name;
    }

    public int getDayCount() {
        return days.size();
    }

    public Weekday getWeekday(int day) {
        if (day < 1 || day > days.size()) {
            throw new IllegalArgumentException("Invalid day: " + day + " for month " + name);
        }
        return days.get(day - 1);
    }

    public Weekday getFirstDay() {
        return days.getFirst();
    }

    public Weekday getLastDay() {
        return days.getLast();
    }
}