import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

class WriteCSV {
    private static final DecimalFormat df = new DecimalFormat("0.00");  

    public static void writeIntake() throws IOException{ // TO-DO: rename method, javadoc
        PrintWriter writer = new PrintWriter(new FileWriter("FoodIntake.csv", true));
        writer.println(LoginWindow.inputtedUsername + "/" + FoodDiaryWindow.formattedDate + "/" + WebScraper.food);
        writer.close();
    }

    public static void writeTotals() throws IOException{ // TO-DO: rename method, javadoc
        String username = LoginWindow.inputtedUsername;
        String date = FoodDiaryWindow.formattedDate;
    
        ArrayList<String> usernames = ReadCSV.readCol(0, "FoodIntake.csv", "/", 3);
        ArrayList<String> dates = ReadCSV.readCol(1, "FoodIntake.csv", "/", 3);
        ArrayList<String> foodNames = ReadCSV.readCol(2, "FoodIntake.csv", "/", 3);

        ArrayList<Integer> usernameNums = new ArrayList<Integer>();
        ArrayList<Integer> dateNums = new ArrayList<Integer>();
        ArrayList<String> curatedFoodNames = new ArrayList<String>();

        System.out.println("Usernames: ");
        int i = 0;
        for(String element: usernames){
            if(element.equals(username)){
                usernameNums.add(i);
            }
            System.out.println(element);
            i++;
        }

        System.out.println("Dates: ");
        int j = 0;
        for(String element: dates){
            if(element.equals(date)){
                dateNums.add(j);
            }
            System.out.println(element);
            j++;
        }

        System.out.println("Date data from today: ");
        for(int element: dateNums){
            System.out.println(element);
        }
        
        System.out.println("Username data from today: ");
        for(int element: usernameNums){
            System.out.println(element);
            if(dateNums.contains(element)){
                curatedFoodNames.add(foodNames.get(element));
            }
        }
        
        System.out.println("Data with correct username and date: ");
        for(String element: curatedFoodNames){
            System.out.println(element);
        }

        System.out.println("Done");
        
        ArrayList<String> foodNames2 = ReadCSV.readCol(0, "FoodData.csv", "/", 4);
        
        ArrayList<Integer> foodNums = new ArrayList<Integer>();

        int k = 0;
        for(String element: curatedFoodNames){
            for(String foodName: foodNames2){
                if(foodName.equals(element)){
                    foodNums.add(k);
                }
                k++;
            }
            k = 0;
        }

        System.out.println("Food nums: ");
        for(int element: foodNums){
            System.out.println(element);
        }

        ArrayList<String> calorieData = ReadCSV.readCol(1, "FoodData.csv", "/", 4);
        ArrayList<String> fatData = ReadCSV.readCol(2, "FoodData.csv", "/", 4);
        ArrayList<String> proteinData = ReadCSV.readCol(3, "FoodData.csv", "/", 4);

        System.out.println("Calorie Data: ");
        for(String element: calorieData){
            System.out.println(element);
        }

        System.out.println("Fat Data: ");
        for(String element: fatData){
            System.out.println(element);
        }

        System.out.println("Protein Data: ");
        for(String element: proteinData){
            System.out.println(element);
        }

        Double calorieTotal = 0.0;
        Double fatTotal = 0.0;
        Double proteinTotal = 0.0;        
        for(int element: foodNums){
            calorieTotal = calorieTotal + Double.parseDouble(calorieData.get(element));
            fatTotal = fatTotal + Double.parseDouble(fatData.get(element));
            proteinTotal = proteinTotal + Double.parseDouble(proteinData.get(element));            
        }

        if(calorieTotal != 0){
            PrintWriter writer = new PrintWriter(new FileWriter("DailyTotals.csv", true));
            writer.println(username + "/" + date + "/" + df.format(calorieTotal) + "/" + df.format(fatTotal) + "/" + df.format(proteinTotal));
            writer.close();
        }
    }
}
