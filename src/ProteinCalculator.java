import java.io.*;

public class ProteinCalculator {
    
     public static void RecProtein(){
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
                    double proteinGoal = UserInfo.CalorieGoal;
                    System.out.println(UserInfo.CalorieGoal);
                    proteinGoal = proteinGoal * 0.25;
                    // Append the protein goal to the line
                    line += "/" + proteinGoal;
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