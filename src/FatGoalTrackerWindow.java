import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FatGoalTrackerWindow extends WindowConstructor implements ActionListener {
    
    // Creates the labels, buttons, and ProgressBar and assigns it to a variable
    private JLabel fatGoalTrackerText = new JLabel("Weekly Fat Data", SwingConstants.CENTER);
    private JProgressBar userFatsDay1 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userFatsDay2 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userFatsDay3 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userFatsDay4 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userFatsDay5 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userFatsDay6 = new JProgressBar(SwingConstants.VERTICAL);
    private JProgressBar userFatsDay7 = new JProgressBar(SwingConstants.VERTICAL);
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

        userFatsDay1.setValue(0);
        userFatsDay1.setStringPainted(true);

        userFatsDay2.setValue(0);
        userFatsDay2.setStringPainted(true);

        userFatsDay3.setValue(0);
        userFatsDay3.setStringPainted(true);

        userFatsDay3.setValue(0);
        userFatsDay3.setStringPainted(true);

        userFatsDay4.setValue(0);
        userFatsDay4.setStringPainted(true);

        userFatsDay5.setValue(0);
        userFatsDay5.setStringPainted(true);

        userFatsDay6.setValue(0);
        userFatsDay6.setStringPainted(true);

        userFatsDay7.setValue(0);
        userFatsDay7.setStringPainted(true);
        
        // *CHANGE HEIGHT OF USER Fats BAR DEPENDING ON THEIR PROGRESS WITH CALCULATIONS
        // Set the positions and sizes of the progress bars

        userFatsDay1.setBounds(150,200,50,300);

        userFatsDay2.setBounds(270,200,50,300);
;
        userFatsDay3.setBounds(390,200,50,300);

        userFatsDay4.setBounds(510,200,50,300);

        userFatsDay5.setBounds(630,200,50,300);

        userFatsDay6.setBounds(750,200,50,300);

        userFatsDay7.setBounds(870,200,50,300);
        
        // Add the progress bars to the window

        add(userFatsDay1);

        add(userFatsDay2);

        add(userFatsDay3);

        add(userFatsDay4);

        add(userFatsDay5);

        add(userFatsDay6);

        add(userFatsDay7);

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
        ProgressCalc.getTotal();
        ProgressCalc.getGoal();
        ProgressCalc.findProgress();
        double fatProgress = ProgressCalc.fatProgress;
        double fatGoal = ProgressCalc.fatGoal;
        System.out.println(fatProgress);

        if (fatProgress < 100) {
            // Use the 'progress' value for updating the progress bars and strings
            userFatsDay2.setValue((int) fatProgress);
            userFatsDay2.setString("Your Progress: " + (int) fatProgress + "%");
        }
        // If the user has reached their fat goal for the day
        else if (fatProgress >= 100) {
            userFatsDay1.setString("You reached your " + fatGoal + "g fat goal! :)");
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
