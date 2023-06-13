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
        ProgressCalc.getTotal();
        ProgressCalc.getGoal();
        ProgressCalc.findProgress();
        double proProgress = ProgressCalc.proProgress;
        double proGoal = ProgressCalc.proGoal;
        System.out.println(proProgress);

        if (proProgress < 100) {
            // Use the 'progress' value for updating the progress bars and strings
            userProteinDay2.setValue((int) proProgress);
            userProteinDay2.setString("Your Progress: " + (int) proProgress + "%");
        }
        // If the user has reached their protein goal for the day
        else if (proProgress >= 100) {
            userProteinDay1.setString("You reached your " + proGoal + "g protein goal! :)");
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
