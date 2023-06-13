import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ProgressCalc {
    // Variables to store total and goal values for protein, fat, and calories
    public static double proTotal = 0;
    public static double fatTotal = 0;
    public static double calTotal = 0;
    public static double proGoal = 0;
    public static double fatGoal = 0;
    public static double calGoal = 0;
    
    // Variables to store progress percentages for protein, fat, and calories
    public static double proProgress = 0;
    public static double fatProgress = 0;
    public static double calProgress = 0;
    
    // Variables to store daily values for each day of the week
    public static String d1, d2, d3, d4, d5, d6, d7;
    
    // Lists to store progress values for each day of the week
    public static ArrayList<Double> calProgressList = new ArrayList<>();
    public static ArrayList<Double> proProgressList = new ArrayList<>();
    public static ArrayList<Double> fatProgressList = new ArrayList<>();
    
    /**
     * This method retrieves the total protein, fat, and calorie values for a specific date and username from the "DailyTotals.csv" file.
     */
    public static void getTotal() {
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

    /**
     * This method retrieves the protein and fat goal values for a specific username from the "UserInfo.csv" file.
     */
    public static void getGoal() {
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

    /**
     * This method calculates the progress percentages for protein, fat, and calories based on the total and goal values.
     */
    public static void findProgress() {
        calProgress = calTotal / calGoal * 100;
        proProgress = proTotal / proGoal * 100;
        fatProgress = fatTotal / fatGoal * 100;
    }


    // Set the array to have six indexes all equal to 0
    public static void baseArrays(){
        for (int i = 0; i < 7; i++) {
            calProgressList.add(0.0);
            proProgressList.add(0.0);
            fatProgressList.add(0.0);
        }
    }

    // Find the current date and day
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

    // Add the progress to the corresponding day of the week
    public static void addArray(){
        String formattedDate = FoodDiaryWindow.formattedDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate currentDate = LocalDate.parse(formattedDate, formatter);
        DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();

        if (currentDayOfWeek == DayOfWeek.SUNDAY) {
            calProgressList.add(0, calProgress);
            proProgressList.add(0, proProgress);
            fatProgressList.add(0, fatProgress);
        } else if (currentDayOfWeek == DayOfWeek.MONDAY) {
            calProgressList.add(1, calProgress);
            proProgressList.add(1, proProgress);
            fatProgressList.add(1, fatProgress);
        } else if (currentDayOfWeek == DayOfWeek.TUESDAY) {
            calProgressList.add(2, calProgress);
            proProgressList.add(2, proProgress);
            fatProgressList.add(2, fatProgress);
        } else if (currentDayOfWeek == DayOfWeek.WEDNESDAY) {
            calProgressList.add(3, calProgress);
            proProgressList.add(3, proProgress);
            fatProgressList.add(3, fatProgress);
        } else if (currentDayOfWeek == DayOfWeek.THURSDAY) {
            calProgressList.add(4, calProgress);
            proProgressList.add(4, proProgress);
            fatProgressList.add(4, fatProgress);
        } else if (currentDayOfWeek == DayOfWeek.FRIDAY) {
            calProgressList.add(5, calProgress);
            proProgressList.add(5, proProgress);
            fatProgressList.add(5, fatProgress);
        } else {
            calProgressList.add(6, calProgress);
            proProgressList.add(6, proProgress);
            fatProgressList.add(6, fatProgress);
        }
    }
}