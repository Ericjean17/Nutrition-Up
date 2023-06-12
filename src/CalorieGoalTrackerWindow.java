import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

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
    String formattedDate = FoodDiaryWindow.formattedDate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate currentDate = LocalDate.parse(formattedDate, formatter);
    String d1 = currentDate.minusDays(1).toString();
    String d2 = currentDate.toString();
    String d3 = currentDate.plusDays(1).toString();
    String d4 = currentDate.plusDays(2).toString();
    String d5 = currentDate.plusDays(3).toString();
    String d6 = currentDate.plusDays(4).toString();
    String d7 = currentDate.plusDays(5).toString();
    private JLabel day1 = new JLabel(d1);
    private JLabel day2 = new JLabel(d2);
    private JLabel day3 = new JLabel(d3);
    private JLabel day4 = new JLabel(d4);
    private JLabel day5 = new JLabel(d5);
    private JLabel day6 = new JLabel(d6);
    private JLabel day7 = new JLabel(d7);
        
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
    public void calorieActualGoalProgressBarValue() {
        System.out.println(FoodDiaryWindow.formattedDate);
        ProgressCalc.getTotal();
        ProgressCalc.getGoal();
        ProgressCalc.findProgress();
        double calProgress = ProgressCalc.calProgress;
        double calGoal = ProgressCalc.calGoal;
        System.out.println(calProgress);

        if (calProgress < 100 && formattedDate.equals(d1)) {
            // Use the 'progress' value for updating the progress bars and strings
            userCaloriesDay1.setValue((int) calProgress);
            userCaloriesDay1.setString("Your Progress: " + (int) calProgress + "%");
        }
        // If the user has reached their calorie goal for the day
        else if (calProgress >= 100 && formattedDate.equals(d1)) {
            userCaloriesDay1.setString("You reached your " + calGoal + " calorie goal! :)");
        }
        else if (calProgress < 100 && formattedDate.equals(d2)) {
            // Use the 'progress' value for updating the progress bars and strings
            userCaloriesDay2.setValue((int) calProgress);
            userCaloriesDay2.setString("Your Progress: " + (int) calProgress + "%");
        }
        // If the user has reached their calorie goal for the day
        else if (calProgress >= 100 && formattedDate.equals(d2)) {
            userCaloriesDay2.setString("You reached your " + calGoal + " calorie goal! :)");
        }
        else if (calProgress < 100 && formattedDate.equals(d3)) {
            // Use the 'progress' value for updating the progress bars and strings
            userCaloriesDay3.setValue((int) calProgress);
            userCaloriesDay3.setString("Your Progress: " + (int) calProgress + "%");
        }
        // If the user has reached their calorie goal for the day
        else if (calProgress >= 100 && formattedDate.equals(d3)) {
            userCaloriesDay3.setString("You reached your " + calGoal + " calorie goal! :)");
        }
        else if (calProgress < 100 && formattedDate.equals(d4)) {
            // Use the 'progress' value for updating the progress bars and strings
            userCaloriesDay4.setValue((int) calProgress);
            userCaloriesDay4.setString("Your Progress: " + (int) calProgress + "%");
        }
        // If the user has reached their calorie goal for the day
        else if (calProgress >= 100 && formattedDate.equals(d4)) {
            userCaloriesDay4.setString("You reached your " + calGoal + " calorie goal! :)");
        }
        else if (calProgress < 100 && formattedDate.equals(d5)) {
            // Use the 'progress' value for updating the progress bars and strings
            userCaloriesDay5.setValue((int) calProgress);
            userCaloriesDay5.setString("Your Progress: " + (int) calProgress + "%");
        }
        // If the user has reached their calorie goal for the day
        else if (calProgress >= 100 && formattedDate.equals(d5)) {
            userCaloriesDay5.setString("You reached your " + calGoal + " calorie goal! :)");
        }
        else if (calProgress < 100 && formattedDate.equals(d6)) {
            // Use the 'progress' value for updating the progress bars and strings
            userCaloriesDay6.setValue((int) calProgress);
            userCaloriesDay6.setString("Your Progress: " + (int) calProgress + "%");
        }
        // If the user has reached their calorie goal for the day
        else if (calProgress >= 100 && formattedDate.equals(d6)) {
            userCaloriesDay6.setString("You reached your " + calGoal + " calorie goal! :)");
        }
        else if (calProgress < 100 && formattedDate.equals(d7)) {
            // Use the 'progress' value for updating the progress bars and strings
            userCaloriesDay7.setValue((int) calProgress);
            userCaloriesDay7.setString("Your Progress: " + (int) calProgress + "%");
        }
        // If the user has reached their calorie goal for the day
        else if (calProgress >= 100 && formattedDate.equals(d7)) {
            userCaloriesDay7.setString("You reached your " + calGoal + " calorie goal! :)");
        }
        
        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
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
