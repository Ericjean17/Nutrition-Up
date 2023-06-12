import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

    public static String date = "2023-06-12";
    

   public static void getTotal(){
        String username = "orion";
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
    String username = "orion";
   // calGoal = Double.parseDouble(Validate.calorieGoal);
        try (BufferedReader reader = new BufferedReader(new FileReader("UserInfo.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("/");
                if (fields.length > 4 && fields[0].equalsIgnoreCase(username) && fields[1].equalsIgnoreCase(date)) {
                    proGoal = Double.parseDouble(fields[7]);
                    fatGoal = Double.parseDouble(fields[6]);
                    
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


public static void findProgress(){
   calProgress = calTotal / calGoal;
   proProgress = proTotal / proGoal;
   fatProgress = fatTotal / fatGoal;
}

 
public static void main(String[] args) throws Exception {
getTotal();
getGoal();
findProgress();
//System.out.println(calProgress);
System.out.println(fatProgress);
System.out.println(proProgress);

}
}