import java.awt.*;
import javax.swing.*;
import javax.swing.text.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;
import java.text.SimpleDateFormat;

public class FoodDiaryWindow extends WindowConstructor implements ActionListener {
    
    // Idk if the TextFields should be public or private. We need to somehow know how the controller
    // will gather the data using the TextField and button variables 
    
    // Create the label, button, and TextField, ScrollPane and assigns it to a variable
    private JLabel applicationNameText = new JLabel("Nutrition Up!");
    private JLabel foodDiaryText = new JLabel("Food Diary");
    private JLabel enterCalorieGoalText = new JLabel("Enter your calorie goal for the day.");
    public JLabel recommendedCalorieGoalText = new JLabel("Recommended goal:");
    public JTextField enterCalorieInputTextField = new JTextField(10);
    public JButton enterCalorieGoalButton = new JButton("Enter");
    //private JDialog invalidInputAlert = new JTextField(foodDiaryWindow, "Not a valid input");
    private JLabel addFoodText = new JLabel("Add a food to your diary");
    public JTextField inputFoodNameTextField = new JTextField(10);
    public JButton enterFoodNameButton = new JButton("Enter");
    public JButton goalProgressButton = new JButton("See goal progress");
    public JButton nextDayButton = new JButton("Next day");
    public JScrollPane diaryScrollPane;

    // We need a panel to make it so the user can scroll down with the ScrollPane
    private JPanel diaryPanel;

    //private WebScraperTesting webScraper;

    //private boolean nextDay = true;

    // The text for displaying the current date and day of the week
    public JLabel dateText = new JLabel("");
    public JLabel dayOfWeekText = new JLabel("");
    
    public void createFoodDiaryWindow() {

        // The logic to print the date on this window
        LocalDate startDate = LocalDate.of(2023, Month.MAY, 31);
        int months = 1;
        LocalDate currentDate = startDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // The line of code to get the day of the week today
        LocalDate today = LocalDate.now();
        DayOfWeek dayOfWeek = today.getDayOfWeek();

        for (int i = 0; i < months; i++) {
            String formattedDate = dateFormat.format(java.sql.Date.valueOf(currentDate));
            dateText.setText(formattedDate);
            currentDate = currentDate.plusMonths(1);
            String formattedDayOfWeek = dateFormat.format(java.sql.Date.valueOf(dayOfWeek));

            dayOfWeekText.setText((DayOfWeek) dayOfWeek);
        }

        /* Not working
        // Make the button still invisible if it was previously invisible
        if (nextDay == false) {
            enterCalorieGoalButton.setVisible(false);
        }
        */

        diaryScrollPane = new JScrollPane();
        setPreferredSize(new Dimension(200,450));
        
        //Initializing the WebScraper tool for the user inputted food
       // webScraper = new WebScraperTesting();

        // Create the diary panel
        /*
        diaryPanel = new JPanel();
        diaryPanel.setLayout(new BoxLayout(diaryPanel, 450)); // Need to change the dimensions
        
        // Something we can do in the controller (refer to the UML diagram)
        ArrayList<String> foodItems = new ArrayList<String>();
        foodItems.add("Food item #1");
        foodItems.add("Food item #2");
        foodItems.add("Food item #3");
        

        // Add each food item as a separate component to the foodPanel
        for(String foodItem: foodItems){
            JLabel userFoodLabel = new JLabel(foodItem);
            foodPanel.add(foodLabel);
        }

        // Create the scrollPane and set the preferred size of the foodPanel
        diaryScrollPane = new JScrollPane(foodPanel);
        diaryScroll.setPreferredSize(new Dimension(400, 300)); // Can adjust the size as needed
        */

        // Initializes the action events for the buttons
        enterCalorieGoalButton.addActionListener(this);
        enterFoodNameButton.addActionListener(this);
        goalProgressButton.addActionListener(this);
        nextDayButton.addActionListener(this);
        
        // Set the positions and sizes of the label, button, and TextField (1100x680)
        applicationNameText.setBounds(490, 55, 200, 30);
        foodDiaryText.setBounds(490, 80, 100, 30);
        enterCalorieGoalText.setBounds(155, 110, 200, 30);
        recommendedCalorieGoalText.setBounds(180, 135, 150, 30);
        enterCalorieInputTextField.setBounds(140, 165, 150, 30);
        enterCalorieGoalButton.setBounds(300,165, 80, 30);
        addFoodText.setBounds(180, 250, 150, 30);
        inputFoodNameTextField.setBounds(140,280,150,30);
        enterFoodNameButton.setBounds(300, 280, 80, 30);
        dateText.setBounds(75,50,120,30);
        dayOfWeekText.setBounds(100,50,100,30);
        
        // Idk how the scroll panel will work yet (how to put each food onto the lines)
        diaryScrollPane.setBounds(600,120,300,400);
        
        goalProgressButton.setBounds(440,570,150,30);
        nextDayButton.setBounds(960,580,100,30);

        // Add the components to the window
        add(applicationNameText);
        add(foodDiaryText);
        add(enterCalorieGoalText);
        add(enterCalorieInputTextField);
        add(recommendedCalorieGoalText);
        add(enterCalorieGoalButton);
        //add(invalidInputAlert);
        add(addFoodText);
        add(inputFoodNameTextField);
        add(enterFoodNameButton);
        add(goalProgressButton);
        add(nextDayButton);
        add(diaryScrollPane, BorderLayout.EAST);
        // add(scrollPanel);
        add(dateText);
        add(dayOfWeekText);
    }

    // Creates a new window or gathers data when the buttons are clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterCalorieGoalButton){
            // I assume we get the method from the controller to contain or add the data (String)
            int userCalories = Integer.parseInt(enterCalorieInputTextField.getText());
            System.out.println("User wants to eat " + userCalories + "g of calories today");

             // Hides the enter button from the user on click, so they can't mess it up.
             // We can make it appear after pressing the nextDayButton
             // We need an if statement before this happens to make sure they inputted an integer in the TextField

             // Also, whenever we press the progress bar button, it becomes visible again. Need to somehow make it still invisible
             // Until the user pressed the next day button.
            enterCalorieGoalButton.setVisible(false);
            //nextDay = false;
            
            // Resets the text inside the TextField, so the user doesn't have to manually delete what they typed previously
            // More professional
            enterCalorieInputTextField.setText("");
        }
        else if (e.getSource() == enterFoodNameButton){
            // I assume we get the method from the controller to contain or add the data (String)
            String food = inputFoodNameTextField.getText();
            System.out.println("User ate this " + food);
            inputFoodNameTextField.setText("");
        }
        else if (e.getSource() == goalProgressButton){
            dispose();
            GoalTrackerWindow goalTrackerWindow = new GoalTrackerWindow();
            goalTrackerWindow.createGoalTrackerWindow();
        }

        // Idk what to do here yet
        else if (e.getSource() == nextDayButton){

            LocalDate currentDate = LocalDate.parse(dateText.getText()); // Parse the current date from the label text
            currentDate = currentDate.plusDays(1); // Increment the current date by 1 day when the next day button is pressed
            String formattedDate = currentDate.toString(); // Convert the updated date back to a string
            dateText.setText(formattedDate); // Set the updated date as the text of the label (dateText only takes a String)


            System.out.println("- " + dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault()));
            // Display the next day of the week

            enterCalorieGoalButton.setVisible(true);
            //nextDay = true;
            enterCalorieInputTextField.setText("");
            inputFoodNameTextField.setText("");

            // Maybe here we reset the diary??
        }
    }
    // Is the button functionality built into these windows or the controller?
}

