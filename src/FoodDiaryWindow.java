import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.text.SimpleDateFormat;

public class FoodDiaryWindow extends WindowConstructor implements ActionListener {
    
    
    // Create the labels, buttons, and TextFields, ScrollPanes and TextArea, and assigns it to a variable
    private JLabel applicationNameText = new JLabel("Nutrition Up!", SwingConstants.CENTER);
    private JLabel foodDiaryText = new JLabel("Food Diary");
    private JLabel enterCalorieGoalText = new JLabel("Enter your calorie goal for the day.");
    private JLabel recommendedCalorieGoalText = new JLabel("Recommended goal:");
    private JTextField enterCalorieInputTextField = new JTextField(10);
    private JButton enterCalorieGoalButton = new JButton("Enter");
    private JLabel addFoodText = new JLabel("Add a food to your diary");
    private JButton goalProgressButton = new JButton("See goal progress");
    private JButton nextDayButton = new JButton("Next day");
    private JScrollPane diaryScrollPane;
    private JTextField inputFoodNameTextField = new JTextField(20);
    private JButton enterFoodNameButton = new JButton("Enter");
    private JTextArea diaryTextArea = new JTextArea();
    private JLabel dateText = new JLabel("");
    private LocalDate currentDay;
    private LocalDate startDate;
    private JLabel dayOfWeekText = new JLabel("");

    Font font = new Font("Hervetica", Font.BOLD, 16);

    public void createFoodDiaryWindow() {

        // The layout to print the date today on this window
        startDate = LocalDate.now();
        int months = 1;
        LocalDate currentDate = startDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Gets the day of the week today
        currentDay = LocalDate.now();
        dayOfWeekText.setText("  - " + currentDate.getDayOfWeek().toString());

        // Depending on the amount of days in each month, the month value goes up by 1 after 30/31 days
        for (int i = 0; i < months; i++) {
            String formattedDate = dateFormat.format(java.sql.Date.valueOf(currentDate));
            dateText.setText(formattedDate);
            currentDate = currentDate.plusMonths(1);
        }

        diaryTextArea.setEditable(false);
        diaryTextArea.setLineWrap(true);
        diaryTextArea.setWrapStyleWord(true);
        diaryTextArea.setFont(font);

        // Set the JTextArea as the view of the scroll pane
        diaryScrollPane = new JScrollPane(diaryTextArea);

        // Makes the scroll bar always appear
        diaryScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        
        /*
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
        */

        // Centers the button to the middle of the window
        goalProgressButton.setHorizontalAlignment(SwingConstants.CENTER);

        // Initializes the action events for the buttons
        enterCalorieGoalButton.addActionListener(this);
        enterFoodNameButton.addActionListener(this);
        goalProgressButton.addActionListener(this);
        nextDayButton.addActionListener(this);
        
        // Sets the positions and sizes of the label, button, and TextField (1100x680)
        applicationNameText.setBounds(375, 55, 350, 60);
        foodDiaryText.setBounds(800, 110, 200, 30);
        enterCalorieGoalText.setBounds(150, 180, 350, 30);
        recommendedCalorieGoalText.setBounds(215, 210, 250, 30);
        enterCalorieInputTextField.setBounds(185, 245, 150, 30);
        enterCalorieGoalButton.setBounds(350,245, 80, 30);
        addFoodText.setBounds(180, 350, 250, 30);
        inputFoodNameTextField.setBounds(185,385,150,30);
        enterFoodNameButton.setBounds(350, 385, 80, 30);
        dateText.setBounds(50,25,120,30);
        dayOfWeekText.setBounds(130,25,150,30);
        diaryScrollPane.setBounds(700,150,300,400);
        goalProgressButton.setBounds(460,580,180,30);
        nextDayButton.setBounds(950,580,100,30);
        
        // The font and size of each label and button
        header1(applicationNameText);
        header3(foodDiaryText);
        header3(enterCalorieGoalText);
        header4(recommendedCalorieGoalText);
        header3(addFoodText);
        header4(dateText);
        header4(dayOfWeekText);
        header5(goalProgressButton);
        header5(nextDayButton);

        // Adds the components to the window
        add(applicationNameText);
        add(foodDiaryText);
        add(enterCalorieGoalText);
        add(enterCalorieInputTextField);
        add(recommendedCalorieGoalText);
        add(enterCalorieGoalButton);
        add(addFoodText);
        add(inputFoodNameTextField);
        add(enterFoodNameButton);
        add(goalProgressButton);
        add(nextDayButton);
        add(diaryScrollPane);
        add(dateText);
        add(dayOfWeekText);
    }

    
    /** 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterCalorieGoalButton){
            // Gets the text inside the calorie text field when the use presses the 'enter' button
            String userCalories = enterCalorieInputTextField.getText();
            Validate.calorieGoal = userCalories;
            // If the calorie goal is valid display the users calorie goal
            if (Validate.validateCalorieGoal()==true){
                // Hides the 'enter' button so the user cannot change their calorie goal
                enterCalorieGoalButton.setVisible(false);
                enterCalorieInputTextField.setText(Validate.calorieGoal); // Why do we need this?
            }
            // If the calorie goal is invalid, display an error message
            else{
                enterCalorieInputTextField.setText("");
                JOptionPane.showMessageDialog(null, "Error. Invalid Calorie Goal, Enter a Number (15000-10000).");
            }

            System.out.println("User wants to eat " + userCalories + "g of calories today");

             // *Also, whenever we press the progress bar button, it becomes visible again. Need to somehow make it still invisible
             // Until the user pressed the next day button.
             
        }
        else if (e.getSource() == enterFoodNameButton){
            // Gets the text from the food text field
            String food = inputFoodNameTextField.getText();
            Validate.foodName = food;

            // If the user doesn't write anything down / does not enter a String and presses the 'enter' button, an error message pops up
            if (Validate.validateFoodName()==false){
                JOptionPane.showMessageDialog(null, "Error. Please Enter a Food Name (A-Z)");
                inputFoodNameTextField.setText("");
            }

            // If there is a String inside the text field, the webscraper fetches it and sees if the food is in their database
            else{
                try {
                    WebScraper.food = food;
                    WebScraper.addKeywordDelimiters();
                    WebScraper.setFoodDataPageURL();

                    // consider moving these out of the try, or combining this try-catch with the if-else below?
                    WebScraper.getCalorieData();
                    WebScraper.getFatData();
                    WebScraper.getProteinData();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                if(WebScraper.validInput == true){
                    System.out.println("User ate this " + food);
                    diaryTextArea.append(food + "\n");
                    diaryTextArea.append("_______________________________\n");
                    inputFoodNameTextField.setText("");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid food name");
                }
            }            
        }

        // Goes to the goal progress window
        else if (e.getSource() == goalProgressButton){
            dispose();
            GoalTrackerWindow goalTrackerWindow = new GoalTrackerWindow();
            goalTrackerWindow.createGoalTrackerWindow();
        }

        // When the next day button is pressed, it changes the date and day
        else if (e.getSource() == nextDayButton){
            
            // Parses the current date from the label text
            LocalDate currentDate = LocalDate.parse(dateText.getText());

            // Increments the current date by 1 day when the next day button is pressed
            currentDate = currentDate.plusDays(1); 

             // Convert the updated date back to a string since labels only accept a String as text
            String formattedDate = currentDate.toString();

            // Set the updated date as the text of the label
            dateText.setText(formattedDate); 

            // Displays the next day of the week (increments it by 1)
            currentDay = currentDay.plusDays(1);
            dayOfWeekText.setText("  - " + currentDate.getDayOfWeek().toString());

            // The enter calorie goal button will reappear since it is the next day
            enterCalorieGoalButton.setVisible(true);
            
            enterCalorieInputTextField.setText("");
            inputFoodNameTextField.setText("");
            diaryTextArea.setText("");
        }
    }
}