import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class ProteinGoalTrackerWindow extends WindowConstructor implements ActionListener {
    
    // Creates the labels, buttons, and ProgressBar and assigns it to a variable
    private JLabel proteinGoalTrackerText = new JLabel("Weekly Protein Data", SwingConstants.CENTER);
    private JProgressBar userProteinDay1 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userProteinDay2 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userProteinDay3 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userProteinDay4 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userProteinDay5 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userProteinDay6 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userProteinDay7 = new JProgressBar(SwingConstants.VERTICAL);
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
    public void createProteinGoalTrackerWindow() {
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
        proteinGoalTrackerText.setBounds(330,60,500,60);
        returnToFoodDiaryButton.setBounds(450,580,190,30);
        day1.setBounds(150, 500, 70,30);
        day2.setBounds(270, 500, 70,30);
        day3.setBounds(390, 500, 70,30);
        day4.setBounds(510, 500, 70,30);
        day5.setBounds(630, 500, 70,30);
        day6.setBounds(750, 500, 70,30);
        day7.setBounds(870, 500, 70,30);
        
        // The font and size of each label
        header1(proteinGoalTrackerText);
        header5(returnToFoodDiaryButton);
        
        // Adds the components to the window
        add(proteinGoalTrackerText);
        add(returnToFoodDiaryButton);
        
        // Sets the default value of progress bars to 0

        userProteinDay1.setValue(0);
        userProteinDay1.setStringPainted(true);

        userProteinDay2.setValue(0);
        userProteinDay2.setStringPainted(true);

        userProteinDay3.setValue(0);
        userProteinDay3.setStringPainted(true);

        userProteinDay3.setValue(0);
        userProteinDay3.setStringPainted(true);

        userProteinDay4.setValue(0);
        userProteinDay4.setStringPainted(true);

        userProteinDay5.setValue(0);
        userProteinDay5.setStringPainted(true);

        userProteinDay6.setValue(0);
        userProteinDay6.setStringPainted(true);

        userProteinDay7.setValue(0);
        userProteinDay7.setStringPainted(true);
        
        // Set the positions and sizes of the progress bars

        userProteinDay1.setBounds(150,200,50,300);

        userProteinDay2.setBounds(270,200,50,300);
;
        userProteinDay3.setBounds(390,200,50,300);

        userProteinDay4.setBounds(510,200,50,300);

        userProteinDay5.setBounds(630,200,50,300);

        userProteinDay6.setBounds(750,200,50,300);

        userProteinDay7.setBounds(870,200,50,300);
        
        // Add the progress bars to the window

        add(userProteinDay1);

        add(userProteinDay2);

        add(userProteinDay3);

        add(userProteinDay4);

        add(userProteinDay5);

        add(userProteinDay6);

        add(userProteinDay7);

        add(day1);
        add(day2);
        add(day3);
        add(day4);
        add(day5);
        add(day6);
        add(day7);

        // Fills the bar with a thread/color
        new Thread(this::protienActualGoalProgressBarValue).start();
    }

    // This is for USER'S ACTUAL Protein INTAKE FOR EACH DAY/WEEK
    public void protienActualGoalProgressBarValue() {
        ProgressCalc.progressDates();
        
        String formattedDate = FoodDiaryWindow.formattedDate;
        ProgressCalc.getTotal();
        ProgressCalc.getGoal();
        ProgressCalc.findProgress();
        ArrayList<Double> proProgressList = ProgressCalc.proProgressList;
        ProgressCalc.baseArrays();
        ProgressCalc.addArray();
        
        double proProgress1 = proProgressList.get(0);
        double proProgress2 = proProgressList.get(1);
        double proProgress3 = proProgressList.get(2);
        double proProgress4 = proProgressList.get(3);
        double proProgress5 = proProgressList.get(4);
        double proProgress6 = proProgressList.get(5);
        double proProgress7 = proProgressList.get(6);
        double proGoal = ProgressCalc.proGoal;

        if (proProgress1 < 100 && formattedDate.equals(ProgressCalc.d1)) {
            // Use the 'progress' value for updating the progress bars and strings
            userProteinDay1.setValue((int) proProgress1);
            userProteinDay1.setString("Your Progress: " + (int) proProgress1 + "%");
        }
        // If the user has reached their protien goal for the day
        else if (proProgress1 >= 100 && formattedDate.equals(ProgressCalc.d1)) {
            userProteinDay1.setString("You reached your " + proGoal + " protien goal! :)");
        }
        else if (proProgress2 < 100 && formattedDate.equals(ProgressCalc.d2)) {
            // Use the 'progress' value for updating the progress bars and strings
            userProteinDay1.setValue((int) proProgress1);
            userProteinDay1.setString("Your Progress: " + (int) proProgress1 + "%");
            userProteinDay2.setValue((int) proProgress2);
            userProteinDay2.setString("Your Progress: " + (int) proProgress2 + "%");
        }
        // If the user has reached their protien goal for the day
        else if (proProgress2 >= 100 && formattedDate.equals(ProgressCalc.d2)) {
            userProteinDay2.setString("You reached your " + proGoal + " protien goal! :)");
        }
        else if (proProgress3 < 100 && formattedDate.equals(ProgressCalc.d3)) {
            // Use the 'progress' value for updating the progress bars and strings
            userProteinDay1.setValue((int) proProgress1);
            userProteinDay1.setString("Your Progress: " + (int) proProgress1 + "%");
            userProteinDay2.setValue((int) proProgress2);
            userProteinDay2.setString("Your Progress: " + (int) proProgress2 + "%");
            userProteinDay3.setValue((int) proProgress3);
            userProteinDay3.setString("Your Progress: " + (int) proProgress3 + "%");
        }
        // If the user has reached their protien goal for the day
        else if (proProgress3 >= 100 && formattedDate.equals(ProgressCalc.d3)) {
            userProteinDay3.setString("You reached your " + proGoal + " protien goal! :)");
        }
        else if (proProgress4 < 100 && formattedDate.equals(ProgressCalc.d4)) {
            // Use the 'progress' value for updating the progress bars and strings
            userProteinDay1.setValue((int) proProgress1);
            userProteinDay1.setString("Your Progress: " + (int) proProgress1 + "%");
            userProteinDay2.setValue((int) proProgress2);
            userProteinDay2.setString("Your Progress: " + (int) proProgress2 + "%");
            userProteinDay3.setValue((int) proProgress3);
            userProteinDay3.setString("Your Progress: " + (int) proProgress3 + "%");
            userProteinDay4.setValue((int) proProgress4);
            userProteinDay4.setString("Your Progress: " + (int) proProgress4 + "%");
        }
        // If the user has reached their protien goal for the day
        else if (proProgress4 >= 100 && formattedDate.equals(ProgressCalc.d4)) {
            userProteinDay4.setString("You reached your " + proGoal + " protien goal! :)");
        }
        else if (proProgress5 < 100 && formattedDate.equals(ProgressCalc.d5)) {
            // Use the 'progress' value for updating the progress bars and strings
            userProteinDay1.setValue((int) proProgress1);
            userProteinDay1.setString("Your Progress: " + (int) proProgress1 + "%");
            userProteinDay2.setValue((int) proProgress2);
            userProteinDay2.setString("Your Progress: " + (int) proProgress2 + "%");
            userProteinDay3.setValue((int) proProgress3);
            userProteinDay3.setString("Your Progress: " + (int) proProgress3 + "%");
            userProteinDay4.setValue((int) proProgress4);
            userProteinDay4.setString("Your Progress: " + (int) proProgress4 + "%");
            userProteinDay5.setValue((int) proProgress5);
            userProteinDay5.setString("Your Progress: " + (int) proProgress5 + "%");
        }
        // If the user has reached their protien goal for the day
        else if (proProgress5 >= 100 && formattedDate.equals(ProgressCalc.d5)) {
            userProteinDay5.setString("You reached your " + proGoal + " protien goal! :)");
        }
        else if (proProgress6 < 100 && formattedDate.equals(ProgressCalc.d6)) {
            // Use the 'progress' value for updating the progress bars and strings
            userProteinDay1.setValue((int) proProgress1);
            userProteinDay1.setString("Your Progress: " + (int) proProgress1 + "%");
            userProteinDay2.setValue((int) proProgress2);
            userProteinDay2.setString("Your Progress: " + (int) proProgress2 + "%");
            userProteinDay3.setValue((int) proProgress3);
            userProteinDay3.setString("Your Progress: " + (int) proProgress3 + "%");
            userProteinDay4.setValue((int) proProgress4);
            userProteinDay4.setString("Your Progress: " + (int) proProgress4 + "%");
            userProteinDay5.setValue((int) proProgress5);
            userProteinDay5.setString("Your Progress: " + (int) proProgress5 + "%");
            userProteinDay6.setValue((int) proProgress6);
            userProteinDay6.setString("Your Progress: " + (int) proProgress6 + "%");
        }
        // If the user has reached their protien goal for the day
        else if (proProgress6 >= 100 && formattedDate.equals(ProgressCalc.d6)) {
            userProteinDay6.setString("You reached your " + proGoal + " protien goal! :)");
        }
        else if (proProgress7 < 100 && formattedDate.equals(ProgressCalc.d7)) {
            // Use the 'progress' value for updating the progress bars and strings
            userProteinDay1.setValue((int) proProgress1);
            userProteinDay1.setString("Your Progress: " + (int) proProgress1 + "%");
            userProteinDay2.setValue((int) proProgress2);
            userProteinDay2.setString("Your Progress: " + (int) proProgress2 + "%");
            userProteinDay3.setValue((int) proProgress3);
            userProteinDay3.setString("Your Progress: " + (int) proProgress3 + "%");
            userProteinDay4.setValue((int) proProgress4);
            userProteinDay4.setString("Your Progress: " + (int) proProgress4 + "%");
            userProteinDay5.setValue((int) proProgress5);
            userProteinDay5.setString("Your Progress: " + (int) proProgress5 + "%");
            userProteinDay6.setValue((int) proProgress6);
            userProteinDay6.setString("Your Progress: " + (int) proProgress6 + "%");
            userProteinDay7.setValue((int) proProgress7);
            userProteinDay7.setString("Your Progress: " + (int) proProgress7 + "%");
        }
        // If the user has reached their protien goal for the day
        else if (proProgress7 >= 100 && formattedDate.equals(ProgressCalc.d7)) {
            userProteinDay7.setString("You reached your " + proGoal + " protien goal! :)");
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
