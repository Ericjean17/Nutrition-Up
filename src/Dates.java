import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dates {
    public static String d1, d2, d3, d4, d5, d6, d7;

    public static void progressDates() {
        String formattedDate = FoodDiaryWindow.formattedDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate currentDate = LocalDate.parse(formattedDate, formatter);
        DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();

        if (currentDayOfWeek == DayOfWeek.SUNDAY) {
            System.out.println("Sunday");
            d7 = currentDate.plusDays(6).toString();
            d6 = currentDate.plusDays(5).toString();
            d5 = currentDate.plusDays(4).toString();
            d4 = currentDate.plusDays(3).toString();
            d3 = currentDate.plusDays(2).toString();
            d2 = currentDate.plusDays(1).toString();
            d1 = currentDate.toString();
        } else if (currentDayOfWeek == DayOfWeek.MONDAY) {
            System.out.println("Monday");
            d7 = currentDate.plusDays(5).toString();
            d6 = currentDate.plusDays(4).toString();
            d5 = currentDate.plusDays(3).toString();
            d4 = currentDate.plusDays(2).toString();
            d3 = currentDate.plusDays(1).toString();
            d2 = currentDate.toString();
            d1 = currentDate.minusDays(1).toString();
        } else if (currentDayOfWeek == DayOfWeek.TUESDAY) {
            System.out.println("Tuesday");
            d7 = currentDate.plusDays(4).toString();
            d6 = currentDate.plusDays(3).toString();
            d5 = currentDate.plusDays(2).toString();
            d4 = currentDate.plusDays(1).toString();
            d3 = currentDate.toString();
            d2 = currentDate.minusDays(1).toString();
            d1 = currentDate.minusDays(2).toString();
        } else if (currentDayOfWeek == DayOfWeek.WEDNESDAY) {
            System.out.println("Wednesday");
            d7 = currentDate.plusDays(3).toString();
            d6 = currentDate.plusDays(2).toString();
            d5 = currentDate.plusDays(1).toString();
            d4 = currentDate.toString();
            d3 = currentDate.minusDays(1).toString();
            d2 = currentDate.minusDays(2).toString();
            d1 = currentDate.minusDays(3).toString();
        } else if (currentDayOfWeek == DayOfWeek.THURSDAY) {
            System.out.println("Thursday");
            d7 = currentDate.plusDays(2).toString();
            d6 = currentDate.plusDays(1).toString();
            d5 = currentDate.toString();
            d4 = currentDate.minusDays(1).toString();
            d3 = currentDate.minusDays(2).toString();
            d2 = currentDate.minusDays(3).toString();
            d1 = currentDate.minusDays(4).toString();
        } else if (currentDayOfWeek == DayOfWeek.FRIDAY) {
            System.out.println("Friday");
            d7 = currentDate.plusDays(1).toString();
            d6 = currentDate.toString();
            d5 = currentDate.minusDays(1).toString();
            d4 = currentDate.minusDays(2).toString();
            d3 = currentDate.minusDays(3).toString();
            d2 = currentDate.minusDays(4).toString();
            d1 = currentDate.minusDays(5).toString();
        } else { // Saturday
            System.out.println("Saturday");
            d7 = currentDate.toString();
            d6 = currentDate.minusDays(1).toString();
            d5 = currentDate.minusDays(2).toString();
            d4 = currentDate.minusDays(3).toString();
            d3 = currentDate.minusDays(4).toString();
            d2 = currentDate.minusDays(5).toString();
            d1 = currentDate.minusDays(6).toString();
        }
    }
}
