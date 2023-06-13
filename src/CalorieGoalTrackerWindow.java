import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private JLabel day1;
    private JLabel day2;
    private JLabel day3;
    private JLabel day4;
    private JLabel day5;
    private JLabel day6;
    private JLabel day7;
        
    private JButton returnToFoodDiaryButton = new JButton("Return to Food Diary");
    
    /** 
     * This method creates, positions, and adds Java Swing objects into the goal tracker window
     * along with inheriting properties from the constructor class
     */
    public void createCalorieGoalTrackerWindow() {
        // To set the dates
        ProgressCalc.progressDates();

        day1 = new JLabel(ProgressCalc.d1);
        day2 = new JLabel(ProgressCalc.d2);
        day3 = new JLabel(ProgressCalc.d3);
        day4 = new JLabel(ProgressCalc.d4);
        day5 = new JLabel(ProgressCalc.d5);
        day6 = new JLabel(ProgressCalc.d6);
        day7 = new JLabel(ProgressCalc.d7);

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

    // This is for USER'S ACTUAL CALORIES INTAKE FOR EACH DAY/ THROUGHOUT THE WEEK
    public void calorieActualGoalProgressBarValue() {
        ProgressCalc.progressDates();
        
        String formattedDate = FoodDiaryWindow.formattedDate;
        ProgressCalc.getTotal();
        ProgressCalc.getGoal();
        double calGoal = ProgressCalc.calGoal;
        ProgressCalc.findProgress();
        ArrayList<Double> calProgressList = ProgressCalc.calProgressList;
        ProgressCalc.baseArrays();
        ProgressCalc.addArray();
        
        double calProgress1 = calProgressList.get(0);
        double calProgress2 = calProgressList.get(1);
        double calProgress3 = calProgressList.get(2);
        double calProgress4 = calProgressList.get(3);
        double calProgress5 = calProgressList.get(4);
        double calProgress6 = calProgressList.get(5);
        double calProgress7 = calProgressList.get(6);

        if (calProgress1 < 100 && formattedDate.equals(ProgressCalc.d1)) {
            // Use the 'progress' value for updating the progress bars and strings
            userCaloriesDay1.setValue((int) calProgress1);
            userCaloriesDay1.setString("Your Progress: " + (int) calProgress1 + "%");
        }
        // If the user has reached their calorie goal for the day
        else if (calProgress1 >= 100 && formattedDate.equals(ProgressCalc.d1)) {
            userCaloriesDay1.setString("You reached your " + calGoal + " calorie goal! :)");
        }
        else if (calProgress2 < 100 && formattedDate.equals(ProgressCalc.d2)) {
            // Use the 'progress' value for updating the progress bars and strings
            userCaloriesDay1.setValue((int) calProgress1);
            userCaloriesDay1.setString("Your Progress: " + (int) calProgress1 + "%");
            userCaloriesDay2.setValue((int) calProgress2);
            userCaloriesDay2.setString("Your Progress: " + (int) calProgress2 + "%");
        }
        // If the user has reached their calorie goal for the day
        else if (calProgress2 >= 100 && formattedDate.equals(ProgressCalc.d2)) {
            userCaloriesDay2.setString("You reached your " + calGoal + " calorie goal! :)");
        }
        else if (calProgress3 < 100 && formattedDate.equals(ProgressCalc.d3)) {
            // Use the 'progress' value for updating the progress bars and strings
            userCaloriesDay1.setValue((int) calProgress1);
            userCaloriesDay1.setString("Your Progress: " + (int) calProgress1 + "%");
            userCaloriesDay2.setValue((int) calProgress2);
            userCaloriesDay2.setString("Your Progress: " + (int) calProgress2 + "%");
            userCaloriesDay3.setValue((int) calProgress3);
            userCaloriesDay3.setString("Your Progress: " + (int) calProgress3 + "%");
        }
        // If the user has reached their calorie goal for the day
        else if (calProgress3 >= 100 && formattedDate.equals(ProgressCalc.d3)) {
            userCaloriesDay3.setString("You reached your " + calGoal + " calorie goal! :)");
        }
        else if (calProgress4 < 100 && formattedDate.equals(ProgressCalc.d4)) {
            // Use the 'progress' value for updating the progress bars and strings
            userCaloriesDay1.setValue((int) calProgress1);
            userCaloriesDay1.setString("Your Progress: " + (int) calProgress1 + "%");
            userCaloriesDay2.setValue((int) calProgress2);
            userCaloriesDay2.setString("Your Progress: " + (int) calProgress2 + "%");
            userCaloriesDay3.setValue((int) calProgress3);
            userCaloriesDay3.setString("Your Progress: " + (int) calProgress3 + "%");
            userCaloriesDay4.setValue((int) calProgress4);
            userCaloriesDay4.setString("Your Progress: " + (int) calProgress4 + "%");
        }
        // If the user has reached their calorie goal for the day
        else if (calProgress4 >= 100 && formattedDate.equals(ProgressCalc.d4)) {
            userCaloriesDay4.setString("You reached your " + calGoal + " calorie goal! :)");
        }
        else if (calProgress5 < 100 && formattedDate.equals(ProgressCalc.d5)) {
            // Use the 'progress' value for updating the progress bars and strings
            userCaloriesDay1.setValue((int) calProgress1);
            userCaloriesDay1.setString("Your Progress: " + (int) calProgress1 + "%");
            userCaloriesDay2.setValue((int) calProgress2);
            userCaloriesDay2.setString("Your Progress: " + (int) calProgress2 + "%");
            userCaloriesDay3.setValue((int) calProgress3);
            userCaloriesDay3.setString("Your Progress: " + (int) calProgress3 + "%");
            userCaloriesDay4.setValue((int) calProgress4);
            userCaloriesDay4.setString("Your Progress: " + (int) calProgress4 + "%");
            userCaloriesDay5.setValue((int) calProgress5);
            userCaloriesDay5.setString("Your Progress: " + (int) calProgress5 + "%");
        }
        // If the user has reached their calorie goal for the day
        else if (calProgress5 >= 100 && formattedDate.equals(ProgressCalc.d5)) {
            userCaloriesDay5.setString("You reached your " + calGoal + " calorie goal! :)");
        }
        else if (calProgress6 < 100 && formattedDate.equals(ProgressCalc.d6)) {
            // Use the 'progress' value for updating the progress bars and strings
            userCaloriesDay1.setValue((int) calProgress1);
            userCaloriesDay1.setString("Your Progress: " + (int) calProgress1 + "%");
            userCaloriesDay2.setValue((int) calProgress2);
            userCaloriesDay2.setString("Your Progress: " + (int) calProgress2 + "%");
            userCaloriesDay3.setValue((int) calProgress3);
            userCaloriesDay3.setString("Your Progress: " + (int) calProgress3 + "%");
            userCaloriesDay4.setValue((int) calProgress4);
            userCaloriesDay4.setString("Your Progress: " + (int) calProgress4 + "%");
            userCaloriesDay5.setValue((int) calProgress5);
            userCaloriesDay5.setString("Your Progress: " + (int) calProgress5 + "%");
            userCaloriesDay6.setValue((int) calProgress6);
            userCaloriesDay6.setString("Your Progress: " + (int) calProgress6 + "%");
        }
        // If the user has reached their calorie goal for the day
        else if (calProgress6 >= 100 && formattedDate.equals(ProgressCalc.d6)) {
            userCaloriesDay6.setString("You reached your " + calGoal + " calorie goal! :)");
        }
        else if (calProgress7 < 100 && formattedDate.equals(ProgressCalc.d7)) {
            // Use the 'progress' value for updating the progress bars and strings
            userCaloriesDay1.setValue((int) calProgress1);
            userCaloriesDay1.setString("Your Progress: " + (int) calProgress1 + "%");
            userCaloriesDay2.setValue((int) calProgress2);
            userCaloriesDay2.setString("Your Progress: " + (int) calProgress2 + "%");
            userCaloriesDay3.setValue((int) calProgress3);
            userCaloriesDay3.setString("Your Progress: " + (int) calProgress3 + "%");
            userCaloriesDay4.setValue((int) calProgress4);
            userCaloriesDay4.setString("Your Progress: " + (int) calProgress4 + "%");
            userCaloriesDay5.setValue((int) calProgress5);
            userCaloriesDay5.setString("Your Progress: " + (int) calProgress5 + "%");
            userCaloriesDay6.setValue((int) calProgress6);
            userCaloriesDay6.setString("Your Progress: " + (int) calProgress6 + "%");
            userCaloriesDay7.setValue((int) calProgress7);
            userCaloriesDay7.setString("Your Progress: " + (int) calProgress7 + "%");
        }
        // If the user has reached their calorie goal for the day
        else if (calProgress7 >= 100 && formattedDate.equals(ProgressCalc.d7)) {
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
