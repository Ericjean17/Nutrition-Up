import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GoalTrackerWindow extends WindowConstructor implements ActionListener {
    
    // Creates the labels, buttons, and ProgressBar and assigns it to a variable
    private JLabel goalTrackerText = new JLabel("Goal Tracker", SwingConstants.CENTER);
    private JLabel calorieGoalTrackerText = new JLabel("You have consumed x calories of you goal of y calories");
    public JProgressBar calorieProgressBar;
    private JLabel proteinGoalTrackerText = new JLabel("You have consumed x grams of protein of your recommended y grams of protein");
    public JProgressBar proteinProgressBar;
    private JLabel fatGoalTrackerText = new JLabel("You have consumed x grams of fat of your recommended y grams of fat");
    public JProgressBar fatProgressBar;
    public JButton returnToFoodDiaryButton = new JButton("Return to Food Diary");

    public void createGoalTrackerWindow() {
        // Initializes the action events for the buttons
        returnToFoodDiaryButton.addActionListener(this);
        
        // Set the positions and sizes of the label, button, and TextField
        goalTrackerText.setBounds(350,60,400,50);
        calorieGoalTrackerText.setBounds(310, 185, 500, 30);
        proteinGoalTrackerText.setBounds(310,285,700, 30);
        fatGoalTrackerText.setBounds(310,385,700,30);
        returnToFoodDiaryButton.setBounds(405,580,190,30);
        
        // The font and size of each label
        header1(goalTrackerText);
        header4(calorieGoalTrackerText);
        header4(proteinGoalTrackerText);
        header4(fatGoalTrackerText);
        header5(returnToFoodDiaryButton);
        
        // Adds the components to the window
        add(goalTrackerText);
        add(calorieGoalTrackerText);
        add(proteinGoalTrackerText);
        add(fatGoalTrackerText);
        add(returnToFoodDiaryButton);
        
        // Creates the progress bars
        calorieProgressBar = new JProgressBar();
        proteinProgressBar = new JProgressBar();
        fatProgressBar = new JProgressBar();
        
        // Sets the default value of progress bars to 0
        calorieProgressBar.setValue(0);
        calorieProgressBar.setStringPainted(true);
        proteinProgressBar.setValue(0);
        proteinProgressBar.setStringPainted(true);
        fatProgressBar.setValue(0);
        fatProgressBar.setStringPainted(true);

        // Set the positions and sizes of the progress bars
        calorieProgressBar.setBounds(300, 215, 420, 30);
        proteinProgressBar.setBounds(300, 325, 420, 30);
        fatProgressBar.setBounds(300, 415, 420, 30);

        // Add the progress bars to the window
        add(calorieProgressBar);
        add(proteinProgressBar);
        add(fatProgressBar);

        // Fills the bar with a thread/color
        new Thread(this::fill).start();
    }

    // Method to simulate the progress of the bar (input user calories, protein, and fat later)
    // NEED TO CHANGE THIS ACCORDING TO USER INPUT VALUES FROM CONTROLLER
    public void fill() {
        int counter = 0;
        while (counter <= 100) {
            final int value = counter;
                calorieProgressBar.setValue(value);
                calorieProgressBar.setString("Your Progress: " + value + "%");
                proteinProgressBar.setValue(value);
                proteinProgressBar.setString("Your Progress: " + value + "%");
                fatProgressBar.setValue(value);
                fatProgressBar.setString("Your Progress: " + value + "%");
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
        }

        // Updates the text inside the progress bar after the user reaches their goal
        calorieProgressBar.setString("You reached your ____ goal! :)");
        proteinProgressBar.setString("You reached your ____ goal! :)");
        fatProgressBar.setString("You reached your ____ goal! :)");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // User will go back to the food diary window after pressing the back button
        if (e.getSource() == returnToFoodDiaryButton){
            dispose();
            FoodDiaryWindow foodDiaryWindow = new FoodDiaryWindow();
            foodDiaryWindow.createFoodDiaryWindow();
        }
    }
    // *Since there are 3 progress bars and it contains a lot of code to make, maybe resort to having a constructor 
    // method or something for the progress bars so this class looks neater and isn't that long?
}
