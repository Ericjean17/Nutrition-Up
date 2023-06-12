import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    public void createProteinGoalTrackerWindow() {
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
        
        // *CHANGE HEIGHT OF USER Protein BAR DEPENDING ON THEIR PROGRESS WITH CALCULATIONS
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
        new Thread(this::calorieActualGoalProgressBarValue).start();
    }

    // This is for USER'S ACTUAL Protein INTAKE FOR EACH DAY/WEEK
    // *Tweak this so it keeps on updating depending on user inputted food
    public void calorieActualGoalProgressBarValue() {
        int counter = 0;
        while (counter <= 100) {
            final int value = counter;     
                userProteinDay1.setValue(value);
                userProteinDay1.setString("Your Progress: " + value + "%");
                userProteinDay2.setValue(value);
                userProteinDay2.setString("Your Progress: " + value + "%");
                userProteinDay3.setValue(value);
                userProteinDay3.setString("Your Progress: " + value + "%");
                userProteinDay4.setValue(value);
                userProteinDay4.setString("Your Progress: " + value + "%");
                userProteinDay5.setValue(value);
                userProteinDay5.setString("Your Progress: " + value + "%");
                userProteinDay6.setValue(value);
                userProteinDay6.setString("Your Progress: " + value + "%");
                userProteinDay7.setValue(value);
                userProteinDay7.setString("Your Progress: " + value + "%");
                
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;

            // Updates the text inside the progress bar after the user reaches their goal
            // Change ___ into user inputted calorie goal
            userProteinDay1.setString("You reached your ____ goal! :)");
            userProteinDay2.setString("You reached your ____ goal! :)");
            userProteinDay3.setString("You reached your ____ goal! :)");
            userProteinDay4.setString("You reached your ____ goal! :)");
            userProteinDay5.setString("You reached your ____ goal! :)");
            userProteinDay6.setString("You reached your ____ goal! :)");
            userProteinDay7.setString("You reached your ____ goal! :)");
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
