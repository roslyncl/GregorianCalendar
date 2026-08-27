import exception.InvalidYearException;

import java.util.Scanner;

public class Main {
    private static final String EXIT_COMMAND = "exit";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = inputYear(scanner);
        while (!input.equalsIgnoreCase(EXIT_COMMAND)) {
            processYear(input);
            input = inputYear(scanner);
        }
        scanner.close();
    }

    private static void processYear(String input) {
        try {
            int yearValue = Integer.parseInt(input);
            GregorianCalendar gregorianCalendar = new GregorianCalendar(yearValue);
            System.out.println(gregorianCalendar.getCalendarYear().print());
        } catch (NumberFormatException e) {
            System.out.println("Error: " + input + " is not valid number");
        } catch (InvalidYearException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String inputYear(Scanner scanner) {
        System.out.print("Enter year: ");
        return scanner.nextLine().trim();
    }
}
