import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

class WriteCSV {
    private static final DecimalFormat df = new DecimalFormat("0.00");  

    /**
     * Writes the food name of a food that a user ate on a certain date to FoodIntake.csv 
     * 
     * @throws IOException
     */
    public static void writeIntake() throws IOException{
        PrintWriter writer = new PrintWriter(new FileWriter("FoodIntake.csv", true));
        writer.println(LoginWindow.inputtedUsername + "/" + FoodDiaryWindow.formattedDate + "/" + WebScraper.food);
        writer.close();
    }

    /**
     * Writes the username's nutrient totals for a given day
     * 
     * @throws IOException
     */
    public static void writeTotals() throws IOException{
        // Sets the active username and date
        String username = LoginWindow.inputtedUsername;
        String date = FoodDiaryWindow.formattedDate;
    
        ArrayList<String> usernames = ReadCSV.readCol(0, "FoodIntake.csv", "/", 3);
        ArrayList<String> dates = ReadCSV.readCol(1, "FoodIntake.csv", "/", 3);
        ArrayList<String> foodNames = ReadCSV.readCol(2, "FoodIntake.csv", "/", 3);

        ArrayList<Integer> usernameNums = new ArrayList<Integer>();
        ArrayList<Integer> dateNums = new ArrayList<Integer>();
        ArrayList<String> curatedFoodNames = new ArrayList<String>();

        // Stores indexes of matching usernames in an array
        int i = 0;
        for(String element: usernames){
            if(element.equals(username)){
                usernameNums.add(i);
            }
            i++;
        }

        // Stores indexes of matching dates in an array
        int j = 0;
        for(String element: dates){
            if(element.equals(date)){
                dateNums.add(j);
            }
            j++;
        }

        // If username and date indexes are the same, get the food name associated with that CSV entry
        for(int element: usernameNums){
            if(dateNums.contains(element)){
                curatedFoodNames.add(foodNames.get(element));
            }
        }
        
        ArrayList<String> foodNames2 = ReadCSV.readCol(0, "FoodData.csv", "/", 4);
        
        ArrayList<Integer> foodNums = new ArrayList<Integer>();

        // Search for the food name in FoodData.csv, get the index of the entry
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

        // Loads nutrient data into ArrayLists
        ArrayList<String> calorieData = ReadCSV.readCol(1, "FoodData.csv", "/", 4);
        ArrayList<String> fatData = ReadCSV.readCol(2, "FoodData.csv", "/", 4);
        ArrayList<String> proteinData = ReadCSV.readCol(3, "FoodData.csv", "/", 4);

        Double calorieTotal = 0.0;
        Double fatTotal = 0.0;
        Double proteinTotal = 0.0;        

        // Use the indexes to get the data from the column
        for(int element: foodNums){
            calorieTotal = calorieTotal + Double.parseDouble(calorieData.get(element));
            fatTotal = fatTotal + Double.parseDouble(fatData.get(element));
            proteinTotal = proteinTotal + Double.parseDouble(proteinData.get(element));            
        }

        // If the user ate at least one food item during the day, write the user's daily totals to DailyTotals.csv
        if(calorieTotal != 0){
            PrintWriter writer = new PrintWriter(new FileWriter("DailyTotals.csv", true));
            writer.println(username + "/" + date + "/" + df.format(calorieTotal) + "/" + df.format(fatTotal) + "/" + df.format(proteinTotal));
            writer.close();
        }
    }
}