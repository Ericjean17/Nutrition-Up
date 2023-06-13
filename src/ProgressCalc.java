import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
<<<<<<< HEAD

=======
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
>>>>>>> d6601cc10ab043999fd04f4cd441e833c5da76b8

public class ProgressCalc {
    public static double proTotal = 0;
    public static double fatTotal = 0;
    public static double calTotal = 0;
    public static double proGoal = 0;
    public static double fatGoal = 0;
    public static double calGoal = 0;
    public static double proProgress = 0;
    public static double fatProgress = 0;
    public static double calProgress = 0;
    public static String d1, d2, d3, d4, d5, d6, d7;
    public static ArrayList<Double> calProgressList = new ArrayList<>();
    public static ArrayList<Double> proProgressList = new ArrayList<>();
    public static ArrayList<Double> fatProgressList = new ArrayList<>();
    
    public static void getTotal(){
        String date = FoodDiaryWindow.formattedDate;
        String username = LoginWindow.inputtedUsername;
        try (BufferedReader reader = new BufferedReader(new FileReader("DailyTotals.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("/");
                if (fields.length > 4 && fields[0].equalsIgnoreCase(username) && fields[1].equalsIgnoreCase(date)) {
                    proTotal = Double.parseDouble(fields[4]);
                    fatTotal = Double.parseDouble(fields[3]);
                    calTotal = Double.parseDouble(fields[2]);
                    break;
                }
            }
            System.out.println(proTotal);
            System.out.println(fatTotal);
            System.out.println(calTotal);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void getGoal(){
        String username = LoginWindow.inputtedUsername;
        calGoal = Double.parseDouble(Validate.calorieGoal);
        try (BufferedReader reader = new BufferedReader(new FileReader("UserInfo.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("/");
                if (fields.length > 4 && fields[0].equalsIgnoreCase(username)) {
                    proGoal = Double.parseDouble(fields[7]);
                    fatGoal = Double.parseDouble(fields[6]);
                    
                    
                    break;
                }
            }
            System.out.println(proGoal);
            System.out.println(fatGoal);
            System.out.println(calGoal);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void findProgress(){
        calProgress = calTotal / calGoal * 100;
        proProgress = proTotal / proGoal * 100;
        fatProgress = fatTotal / fatGoal * 100;
    }

    public static void baseArrays(){
        for (int i = 0; i < 7; i++) {
            calProgressList.add(0.0);
            proProgressList.add(0.0);
            fatProgressList.add(0.0);
        }
    }

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
    public static void addArray(){
        String formattedDate = FoodDiaryWindow.formattedDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate currentDate = LocalDate.parse(formattedDate, formatter);
        DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();

        if (currentDayOfWeek == DayOfWeek.SUNDAY) {
            calProgressList.add(0, calProgress);
        } else if (currentDayOfWeek == DayOfWeek.MONDAY) {
            calProgressList.add(1, calProgress);
        } else if (currentDayOfWeek == DayOfWeek.TUESDAY) {
            calProgressList.add(2, calProgress);
        } else if (currentDayOfWeek == DayOfWeek.WEDNESDAY) {
            calProgressList.add(3, calProgress);
        } else if (currentDayOfWeek == DayOfWeek.THURSDAY) {
            calProgressList.add(4, calProgress);
        } else if (currentDayOfWeek == DayOfWeek.FRIDAY) {
            calProgressList.add(5, calProgress);
        } else {
            calProgressList.add(6, calProgress);
        }
    }
}