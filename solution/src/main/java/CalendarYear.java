import java.util.ArrayList;
import java.util.List;

public class CalendarYear {

    private static final String[] MONTH_NAMES = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    private final List<Month> months;

    public CalendarYear(Weekday firstDayOfYear, boolean isLeapYear) {
        this.months = buildYear(firstDayOfYear, isLeapYear);
    }

    private List<Month> buildYear(Weekday firstDay, boolean isLeapYear) {
        List<Month> months = new ArrayList<>();
        Weekday current = firstDay;

        for(int monthNumber = 1; monthNumber<=12; monthNumber++) {
            int daysInMonth = daysInMonth(monthNumber, isLeapYear);
            Month month = new Month(MONTH_NAMES[monthNumber-1], current, daysInMonth);
            months.add(month);
            current = month.getLastDay().next();
        }
        return months;
    }

    private int daysInMonth(int monthNumber, boolean isLeapYear) {
        return switch (monthNumber) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear ? 29 : 28;
            default -> throw new IllegalArgumentException("Invalid month " + monthNumber);
        };
    }

    public Month getMonth(int monthNumber) {
        if (monthNumber < 1 || monthNumber > 12) {
            throw new IllegalArgumentException("Invalid month: " + monthNumber);
        }
        return months.get(monthNumber - 1);
    }

    public Weekday getWeekday(int day, int month) {
        return getMonth(month).getWeekday(day);
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        for (Month month : months) {
            result.append(printMonth(month));
        }
        return result.toString();
    }

    private String printMonth(Month month) {
        StringBuilder result = new StringBuilder();
        result.append(month.getName());
        result.append("\nMon Tue Wed Thu Fri Sat Sun\n");

        int offset = month.getFirstDay().ordinal();
        result.append("    ".repeat(offset));

        for (int day = 1; day <= month.getDayCount(); day++) {
            result.append(String.format("%3d ", day));
            if ((offset + day) % 7 == 0) {
                result.append("\n");
            }
        }
        result.append("\n\n");
        return result.toString();
    }
}