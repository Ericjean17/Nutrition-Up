import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GoalTrackerWindow extends WindowConstructor implements ActionListener {
    
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
    public void createGoalTrackerWindow() {
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
        int counter = 0;
        while (counter <= 100) {
            final int value = counter;
                userCaloriesDay1.setValue(value);
                userCaloriesDay1.setString("Your Progress: " + value + "%");
                userCaloriesDay2.setValue(value);
                userCaloriesDay2.setString("Your Progress: " + value + "%");
                userCaloriesDay3.setValue(value);
                userCaloriesDay3.setString("Your Progress: " + value + "%");
                userCaloriesDay4.setValue(value);
                userCaloriesDay4.setString("Your Progress: " + value + "%");
                userCaloriesDay5.setValue(value);
                userCaloriesDay5.setString("Your Progress: " + value + "%");
                userCaloriesDay6.setValue(value);
                userCaloriesDay6.setString("Your Progress: " + value + "%");
                userCaloriesDay7.setValue(value);
                userCaloriesDay7.setString("Your Progress: " + value + "%");
                
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;

            // Updates the text inside the progress bar after the user reaches their goal
            // Change ___ into user inputted calorie goal
            userCaloriesDay1.setString("You reached your ____ goal! :)");
            userCaloriesDay2.setString("You reached your ____ goal! :)");
            userCaloriesDay3.setString("You reached your ____ goal! :)");
            userCaloriesDay4.setString("You reached your ____ goal! :)");
            userCaloriesDay5.setString("You reached your ____ goal! :)");
            userCaloriesDay6.setString("You reached your ____ goal! :)");
            userCaloriesDay7.setString("You reached your ____ goal! :)");
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
