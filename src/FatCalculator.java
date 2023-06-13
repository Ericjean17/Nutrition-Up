import java.io.*;
import java.text.DecimalFormat;

public class FatCalculator {

    public static void Recfat() {

        String username = UserInfo.username;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("UserInfo.csv"));
            StringBuilder fileContent = new StringBuilder();

            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("/");

                // Check if the current line matches the username
                if (fields.length > 0 && fields[0].equalsIgnoreCase(username)) {
                    UserInfo.retrieveUsercalorie(username);
                    UserInfo.displayInformation();
                    // Set the fat goal as 30% of the calorie result
                    double FatGoal = UserInfo.CalorieGoal;
                    
                    FatGoal = FatGoal * 0.3 / 9;

                    // Round the fat goal to 2 decimal places
                    DecimalFormat decimalFormat = new DecimalFormat("#.00");
                    String roundedFatGoal = decimalFormat.format(FatGoal);

                    // Append the rounded fat goal to the line
                    line += "/" + roundedFatGoal;
                }

                // Append the line to the file content
                fileContent.append(line).append(System.lineSeparator());
            }

            reader.close();

            // Write the updated content back to the file
            PrintWriter writer = new PrintWriter(new FileWriter("UserInfo.csv"));
            writer.print(fileContent.toString());
            writer.close();

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}