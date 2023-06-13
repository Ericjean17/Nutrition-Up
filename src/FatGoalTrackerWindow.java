import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class FatGoalTrackerWindow extends WindowConstructor implements ActionListener {
    
    // Creates the labels, buttons, and ProgressBar and assigns it to a variable
    private JLabel fatGoalTrackerText = new JLabel("Weekly Fat Data", SwingConstants.CENTER);
    private JProgressBar userFatDay1 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userFatDay2 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userFatDay3 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userFatDay4 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userFatDay5 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userFatDay6 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userFatDay7 = new JProgressBar(SwingConstants.VERTICAL);
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
    public void createFatGoalTrackerWindow() {
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
        fatGoalTrackerText.setBounds(330,60,500,60);
        returnToFoodDiaryButton.setBounds(450,580,190,30);
        day1.setBounds(150, 500, 70,30);
        day2.setBounds(270, 500, 70,30);
        day3.setBounds(390, 500, 70,30);
        day4.setBounds(510, 500, 70,30);
        day5.setBounds(630, 500, 70,30);
        day6.setBounds(750, 500, 70,30);
        day7.setBounds(870, 500, 70,30);
        
        // The font and size of each label
        header1(fatGoalTrackerText);
        header5(returnToFoodDiaryButton);
        
        // Adds the components to the window
        add(fatGoalTrackerText);
        add(returnToFoodDiaryButton);
        
        // Sets the default value of progress bars to 0

        userFatDay1.setValue(0);
        userFatDay1.setStringPainted(true);

        userFatDay2.setValue(0);
        userFatDay2.setStringPainted(true);

        userFatDay3.setValue(0);
        userFatDay3.setStringPainted(true);

        userFatDay3.setValue(0);
        userFatDay3.setStringPainted(true);

        userFatDay4.setValue(0);
        userFatDay4.setStringPainted(true);

        userFatDay5.setValue(0);
        userFatDay5.setStringPainted(true);

        userFatDay6.setValue(0);
        userFatDay6.setStringPainted(true);

        userFatDay7.setValue(0);
        userFatDay7.setStringPainted(true);
        
        // *CHANGE HEIGHT OF USER Fats BAR DEPENDING ON THEIR PROGRESS WITH CALCULATIONS
        // Set the positions and sizes of the progress bars

        userFatDay1.setBounds(150,200,50,300);

        userFatDay2.setBounds(270,200,50,300);
;
        userFatDay3.setBounds(390,200,50,300);

        userFatDay4.setBounds(510,200,50,300);

        userFatDay5.setBounds(630,200,50,300);

        userFatDay6.setBounds(750,200,50,300);

        userFatDay7.setBounds(870,200,50,300);
        
        // Add the progress bars to the window

        add(userFatDay1);

        add(userFatDay2);

        add(userFatDay3);

        add(userFatDay4);

        add(userFatDay5);

        add(userFatDay6);

        add(userFatDay7);

        add(day1);
        add(day2);
        add(day3);
        add(day4);
        add(day5);
        add(day6);
        add(day7);

        // Fills the bar with a thread/color
        new Thread(this::fatActualGoalProgressBarValue).start();
    }

    // This is for USER'S ACTUAL Fats INTAKE FOR EACH DAY/WEEK
    // *Tweak this so it keeps on updating depending on user inputted food
    public void fatActualGoalProgressBarValue() {
        ProgressCalc.progressDates();
        
        String formattedDate = FoodDiaryWindow.formattedDate;
        ProgressCalc.getTotal();
        ProgressCalc.getGoal();
        ProgressCalc.findProgress();
        ArrayList<Double> fatProgressList = ProgressCalc.fatProgressList;
        ProgressCalc.baseArrays();
        ProgressCalc.addArray();
       
        double fatProgress1 = fatProgressList.get(0);
        double fatProgress2 = fatProgressList.get(1);
        double fatProgress3 = fatProgressList.get(2);
        double fatProgress4 = fatProgressList.get(3);
        double fatProgress5 = fatProgressList.get(4);
        double fatProgress6 = fatProgressList.get(5);
        double fatProgress7 = fatProgressList.get(6);
        double fatGoal = ProgressCalc.fatGoal;

        if (fatProgress1 < 100 && formattedDate.equals(ProgressCalc.d1)) {
            // Use the 'progress' value for updating the progress bars and strings
            userFatDay1.setValue((int) fatProgress1);
            userFatDay1.setString("Your Progress: " + (int) fatProgress1 + "%");
        }
        // If the user has reached their calorie goal for the day
        else if (fatProgress1 >= 100 && formattedDate.equals(ProgressCalc.d1)) {
            userFatDay1.setString("You reached your " + fatGoal + " calorie goal! :)");
        }
        else if (fatProgress2 < 100 && formattedDate.equals(ProgressCalc.d2)) {
            // Use the 'progress' value for updating the progress bars and strings
            userFatDay1.setValue((int) fatProgress1);
            userFatDay1.setString("Your Progress: " + (int) fatProgress1 + "%");
            userFatDay2.setValue((int) fatProgress2);
            userFatDay2.setString("Your Progress: " + (int) fatProgress2 + "%");
        }
        // If the user has reached their calorie goal for the day
        else if (fatProgress2 >= 100 && formattedDate.equals(ProgressCalc.d2)) {
            userFatDay2.setString("You reached your " + fatGoal + " calorie goal! :)");
        }
        else if (fatProgress3 < 100 && formattedDate.equals(ProgressCalc.d3)) {
            // Use the 'progress' value for updating the progress bars and strings
            userFatDay1.setValue((int) fatProgress1);
            userFatDay1.setString("Your Progress: " + (int) fatProgress1 + "%");
            userFatDay2.setValue((int) fatProgress2);
            userFatDay2.setString("Your Progress: " + (int) fatProgress2 + "%");
            userFatDay3.setValue((int) fatProgress3);
            userFatDay3.setString("Your Progress: " + (int) fatProgress3 + "%");
        }
        // If the user has reached their calorie goal for the day
        else if (fatProgress3 >= 100 && formattedDate.equals(ProgressCalc.d3)) {
            userFatDay3.setString("You reached your " + fatGoal + " calorie goal! :)");
        }
        else if (fatProgress4 < 100 && formattedDate.equals(ProgressCalc.d4)) {
            // Use the 'progress' value for updating the progress bars and strings
            userFatDay1.setValue((int) fatProgress1);
            userFatDay1.setString("Your Progress: " + (int) fatProgress1 + "%");
            userFatDay2.setValue((int) fatProgress2);
            userFatDay2.setString("Your Progress: " + (int) fatProgress2 + "%");
            userFatDay3.setValue((int) fatProgress3);
            userFatDay3.setString("Your Progress: " + (int) fatProgress3 + "%");
            userFatDay4.setValue((int) fatProgress4);
            userFatDay4.setString("Your Progress: " + (int) fatProgress4 + "%");
        }
        // If the user has reached their calorie goal for the day
        else if (fatProgress4 >= 100 && formattedDate.equals(ProgressCalc.d4)) {
            userFatDay4.setString("You reached your " + fatGoal + " calorie goal! :)");
        }
        else if (fatProgress5 < 100 && formattedDate.equals(ProgressCalc.d5)) {
            // Use the 'progress' value for updating the progress bars and strings
            userFatDay1.setValue((int) fatProgress1);
            userFatDay1.setString("Your Progress: " + (int) fatProgress1 + "%");
            userFatDay2.setValue((int) fatProgress2);
            userFatDay2.setString("Your Progress: " + (int) fatProgress2 + "%");
            userFatDay3.setValue((int) fatProgress3);
            userFatDay3.setString("Your Progress: " + (int) fatProgress3 + "%");
            userFatDay4.setValue((int) fatProgress4);
            userFatDay4.setString("Your Progress: " + (int) fatProgress4 + "%");
            userFatDay5.setValue((int) fatProgress5);
            userFatDay5.setString("Your Progress: " + (int) fatProgress5 + "%");
        }
        // If the user has reached their calorie goal for the day
        else if (fatProgress5 >= 100 && formattedDate.equals(ProgressCalc.d5)) {
            userFatDay5.setString("You reached your " + fatGoal + " calorie goal! :)");
        }
        else if (fatProgress6 < 100 && formattedDate.equals(ProgressCalc.d6)) {
            // Use the 'progress' value for updating the progress bars and strings
            userFatDay1.setValue((int) fatProgress1);
            userFatDay1.setString("Your Progress: " + (int) fatProgress1 + "%");
            userFatDay2.setValue((int) fatProgress2);
            userFatDay2.setString("Your Progress: " + (int) fatProgress2 + "%");
            userFatDay3.setValue((int) fatProgress3);
            userFatDay3.setString("Your Progress: " + (int) fatProgress3 + "%");
            userFatDay4.setValue((int) fatProgress4);
            userFatDay4.setString("Your Progress: " + (int) fatProgress4 + "%");
            userFatDay5.setValue((int) fatProgress5);
            userFatDay5.setString("Your Progress: " + (int) fatProgress5 + "%");
            userFatDay6.setValue((int) fatProgress6);
            userFatDay6.setString("Your Progress: " + (int) fatProgress6 + "%");
        }
        // If the user has reached their calorie goal for the day
        else if (fatProgress6 >= 100 && formattedDate.equals(ProgressCalc.d6)) {
            userFatDay6.setString("You reached your " + fatGoal + " calorie goal! :)");
        }
        else if (fatProgress7 < 100 && formattedDate.equals(ProgressCalc.d7)) {
            // Use the 'progress' value for updating the progress bars and strings
            userFatDay1.setValue((int) fatProgress1);
            userFatDay1.setString("Your Progress: " + (int) fatProgress1 + "%");
            userFatDay2.setValue((int) fatProgress2);
            userFatDay2.setString("Your Progress: " + (int) fatProgress2 + "%");
            userFatDay3.setValue((int) fatProgress3);
            userFatDay3.setString("Your Progress: " + (int) fatProgress3 + "%");
            userFatDay4.setValue((int) fatProgress4);
            userFatDay4.setString("Your Progress: " + (int) fatProgress4 + "%");
            userFatDay5.setValue((int) fatProgress5);
            userFatDay5.setString("Your Progress: " + (int) fatProgress5 + "%");
            userFatDay6.setValue((int) fatProgress6);
            userFatDay6.setString("Your Progress: " + (int) fatProgress6 + "%");
            userFatDay7.setValue((int) fatProgress7);
            userFatDay7.setString("Your Progress: " + (int) fatProgress7 + "%");
        }
        // If the user has reached their calorie goal for the day
        else if (fatProgress7 >= 100 && formattedDate.equals(ProgressCalc.d7)) {
            userFatDay7.setString("You reached your " + fatGoal + " calorie goal! :)");
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
