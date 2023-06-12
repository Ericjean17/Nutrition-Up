import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CalorieGoalTrackerWindow extends WindowConstructor implements ActionListener {
    
    // Creates the labels, buttons, and ProgressBar and assigns it to a variable
    private JLabel calorieGoalTrackerText = new JLabel("Weekly Calorie Data", SwingConstants.CENTER);
    private JProgressBar userCaloriesDay1 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userCaloriesDay2 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userCaloriesDay3 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userCaloriesDay4 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userCaloriesDay5 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userCaloriesDay6 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userCaloriesDay7 = new JProgressBar(SwingConstants.VERTICAL);
    private JLabel day1 = new JLabel("6/11/2023");
    private JLabel day2 = new JLabel("6/12/2023");
    private JLabel day3 = new JLabel("6/13/2023");
    private JLabel day4 = new JLabel("6/14/2023");
    private JLabel day5 = new JLabel("6/15/2023");
    private JLabel day6 = new JLabel("6/16/2023");
    private JLabel day7 = new JLabel("6/17/2023");
        
    private JButton returnToFoodDiaryButton = new JButton("Return to Food Diary");
    
    /** 
     * This method creates, positions, and adds Java Swing objects into the goal tracker window
     * along with inheriting properties from the constructor class
     */
    public void createCalorieGoalTrackerWindow() {
        // Initializes the action events for the buttons
        returnToFoodDiaryButton.addActionListener(this);
        
        // Set the positions and sizes of the label, button, and TextField
        calorieGoalTrackerText.setBounds(330,60,500,60);
        returnToFoodDiaryButton.setBounds(450,580,190,30);
        day1.setBounds(150, 500, 70,30);
        day2.setBounds(270, 500, 70,30);
        day3.setBounds(390, 500, 70,30);
        day4.setBounds(510, 500, 70,30);
        day5.setBounds(630, 500, 70,30);
        day6.setBounds(750, 500, 70,30);
        day7.setBounds(870, 500, 70,30);
        
        // The font and size of each label
        header1(calorieGoalTrackerText);
        header5(returnToFoodDiaryButton);
        
        // Adds the components to the window
        add(calorieGoalTrackerText);
        add(returnToFoodDiaryButton);
        
        // Sets the default value of progress bars to 0

        userCaloriesDay1.setValue(0);
        userCaloriesDay1.setStringPainted(true);

        userCaloriesDay2.setValue(0);
        userCaloriesDay2.setStringPainted(true);

        userCaloriesDay3.setValue(0);
        userCaloriesDay3.setStringPainted(true);

        userCaloriesDay3.setValue(0);
        userCaloriesDay3.setStringPainted(true);

        userCaloriesDay4.setValue(0);
        userCaloriesDay4.setStringPainted(true);

        userCaloriesDay5.setValue(0);
        userCaloriesDay5.setStringPainted(true);

        userCaloriesDay6.setValue(0);
        userCaloriesDay6.setStringPainted(true);

        userCaloriesDay7.setValue(0);
        userCaloriesDay7.setStringPainted(true);
        
        // *CHANGE HEIGHT OF USER CALORIES BAR DEPENDING ON THEIR PROGRESS WITH CALCULATIONS
        // Set the positions and sizes of the progress bars

        userCaloriesDay1.setBounds(150,200,50,300);

        userCaloriesDay2.setBounds(270,200,50,300);
;
        userCaloriesDay3.setBounds(390,200,50,300);

        userCaloriesDay4.setBounds(510,200,50,300);

        userCaloriesDay5.setBounds(630,200,50,300);

        userCaloriesDay6.setBounds(750,200,50,300);

        userCaloriesDay7.setBounds(870,200,50,300);
        
        // Add the progress bars to the window

        add(userCaloriesDay1);

        add(userCaloriesDay2);

        add(userCaloriesDay3);

        add(userCaloriesDay4);

        add(userCaloriesDay5);

        add(userCaloriesDay6);

        add(userCaloriesDay7);

        add(day1);
        add(day2);
        add(day3);
        add(day4);
        add(day5);
        add(day6);
        add(day7);

        // Fills the bar with a thread/color
        new Thread(this::calorieActualGoalProgressBarValue).start();
    }

    // This is for USER'S ACTUAL CALORIES INTAKE FOR EACH DAY/WEEK
    // *Tweak this so it keeps on updating depending on user inputted food
    // **It can now retrieve the data from the "DailyTotals.csv"
    // **Still need to figure out for the other days of the week
    // **Still need to figure out how to match it so that it is only "value" is all the total calories of the correct person
    public void calorieActualGoalProgressBarValue() {
        String filePath = "DailyTotals.csv"; // Path to your CSV file
        int goal = Integer.parseInt(Validate.calorieGoal); // Assuming 'calorieGoal' is a valid integer value
        String username = Validate.username;

        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Change this so that we have an array for each row
                // Check the first column of each of those rows
                // If the first column of the row is equal to the current username
                // Then take the 3rd column of that row
                ArrayList<String> usernames = ReadCSV.readCol(0, "DailyTotals.csv", "/", 5);
                ArrayList<String> columns = new ArrayList<>(Arrays.asList(line.split("/")));
                for (String i : usernames){
                    System.out.println(i);
                }

                if (columns.size() >= 3) {
                    double value = Double.parseDouble(columns.get(2));
                    double progress = (value / goal) * 100;

                    // If the user hasn't reached their calorie goal for the day
                    if (value < goal) {
                        // Use the 'progress' value for updating the progress bars and strings
                        userCaloriesDay1.setValue((int) progress);
                        userCaloriesDay1.setString("Your Progress: " + (int) progress + "%");
                        // Update the remaining progress bars and strings in a similar manner   
                    } 
                    // If the user has reached their calorie goal for the day
                    else if (value >= goal) {
                        userCaloriesDay1.setString("You reached your " + goal + " calorie goal! :)");
                    }
                }

                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /** 
     * @param e The event when a button is clicked occurs
     * 
     * This method will simply dispose the current window and create the food diary window 
     * when the 'back' button is pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // User will go back to the food diary window after pressing the back button
        if (e.getSource() == returnToFoodDiaryButton){
            dispose();
            FoodDiaryWindow foodDiaryWindow = new FoodDiaryWindow();
            foodDiaryWindow.createFoodDiaryWindow();
        }
    }
}
