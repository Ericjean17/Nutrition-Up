import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GoalTrackerWindow extends WindowConstructor implements ActionListener {
    // Create the progress bar and assign it to a variable
    // Create the label, button, and TextField, and assign it to a variable

    private JLabel goalTrackerText = new JLabel("Goal Tracker");
    
    private JLabel calorieGoalTrackerText = new JLabel("You have consumed x calories of you goal of y calories");
    public JProgressBar calorieProgressBar;
    
    private JLabel proteinGoalTrackerText = new JLabel("You have consumed x grams of protein of your recommended y grams of protein");
    public JProgressBar proteinProgressBar;
    
    private JLabel fatGoalTrackerText = new JLabel("You have consumed x grams of fat of your recommended y grams of protein");
    public JProgressBar fatProgressBar;
    
    public JButton returnToFoodDiaryButton = new JButton("Return to Food Diary");

    public void createGoalTrackerWindow() {

        // Initialize action events for the buttons
        returnToFoodDiaryButton.addActionListener(this);
        
        // Set the positions and sizes of the label, button, and TextField
        goalTrackerText.setBounds(500,60,150,30);
        calorieGoalTrackerText.setBounds(125, 120, 400, 30);
        proteinGoalTrackerText.setBounds(125,230,400, 30);
        fatGoalTrackerText.setBounds(125,320,400,30);
        returnToFoodDiaryButton.setBounds(405,580,240,30);
        
        // Add the components to the window
        add(goalTrackerText);
        add(calorieGoalTrackerText);
        add(proteinGoalTrackerText);
        add(fatGoalTrackerText);
        add(returnToFoodDiaryButton);
        //* We have to use add(calorieBar) inside the SwingUtilities thing so it works like the following code
        
        // SAMPLE CODE FOR THE PROGRESS BARS
        SwingUtilities.invokeLater(() -> {
            calorieProgressBar = new JProgressBar();
            proteinProgressBar = new JProgressBar();
            fatProgressBar = new JProgressBar();
            
            calorieProgressBar.setValue(0);
            calorieProgressBar.setStringPainted(true);
            proteinProgressBar.setValue(0);
            proteinProgressBar.setStringPainted(true);
            fatProgressBar.setValue(0);
            fatProgressBar.setStringPainted(true);

            // Set the position and size of the progress bar
            calorieProgressBar.setBounds(125, 150, 420, 30);
            proteinProgressBar.setBounds(125, 260, 420, 30);
            fatProgressBar.setBounds(125, 350, 420, 30);

            // Add the progress bar to the window
            add(calorieProgressBar);
            add(proteinProgressBar);
            add(fatProgressBar);

            // Start the progress update in a separate thread
            new Thread(this::fill).start();
        });
    }

    // Method to simulate the progress of the bar
    public void fill() {
        int counter = 0;
        while (counter <= 100) {
            final int value = counter;
            SwingUtilities.invokeLater(() -> {
                calorieProgressBar.setValue(value);
                calorieProgressBar.setString("Your Progress: " + value + "%");
                proteinProgressBar.setValue(value);
                proteinProgressBar.setString("Your Progress: " + value + "%");
                fatProgressBar.setValue(value);
                fatProgressBar.setString("Your Progress: " + value + "%");
            });
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
        }
        // Update the text of the progress bar after the loop completes
        SwingUtilities.invokeLater(() -> {
            calorieProgressBar.setString("You reached your ____ goal! :)");
            proteinProgressBar.setString("You reached your ____ goal! :)");
            fatProgressBar.setString("You reached your ____ goal! :)");
        });
    }
    // When pressing the buttons, it creates a new window
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnToFoodDiaryButton){
            dispose();
            FoodDiaryWindow foodDiaryWindow = new FoodDiaryWindow();
            foodDiaryWindow.createFoodDiaryWindow();
        }
    }
    // *Since there are 3 progress bars and it contains a lot of code to make, maybe resort to having a constructor 
    // method or something for the progress bars so this class looks neater and isn't that long?
}
