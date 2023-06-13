import java.io.*;
import java.text.DecimalFormat;

public class ProteinCalculator {

    public static void RecProtein() {
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
                    // Set the protein goal as 25% of the calorie result
                    double proteinGoal = UserInfo.weight;
                    System.out.println(UserInfo.CalorieGoal);
                    proteinGoal = proteinGoal * 0.8;

                    // Round the protein goal to 2 decimal places
                    DecimalFormat decimalFormat = new DecimalFormat("#.00");
                    String roundedProteinGoal = decimalFormat.format(proteinGoal);

                    // Append the rounded protein goal to the line
                    line += "/" + roundedProteinGoal;
                }

                // Append the line to the file content
                fileContent.append(line).append(System.lineSeparator());
            }

            reader.close();

            // Write the updated content back to the file
            PrintWriter writer = new PrintWriter(new FileWriter("UserInfo.csv"));
            writer.print(fileContent.toString());
            writer.close();

            System.out.println("Protein goal appended to UserInfo.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}