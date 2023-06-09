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
    private JLabel recommendedCalorieGoalText = new JLabel("Recommended goal: ");
    private JTextField enterCalorieInputTextField = new JTextField(10);
    private JButton enterCalorieGoalButton = new JButton("Enter");
    private JLabel addFoodText = new JLabel("Add a food to your diary");
    private JButton nextDayButton = new JButton("Next day");
    private JScrollPane diaryScrollPane;
    private JTextField inputFoodNameTextField = new JTextField(20);
    private JButton enterFoodNameButton = new JButton("Enter");
    public JTextArea diaryTextArea = new JTextArea();
    private JLabel dateText = new JLabel("");
    private static LocalDate currentDay;
    private static LocalDate startDate;
    private static LocalDate currentDate;
    private static SimpleDateFormat dateFormat;
    private JLabel dayOfWeekText = new JLabel("");
    private JLabel dailyCalorieGoal = new JLabel("");
    public static String diaryText = "";
    public static String userCalories = "";
    public static String formattedDate = "";

    Font font = new Font("Hervetica", Font.BOLD, 16);
    boolean isCalorieGoalEntered = false;

    private JButton calorieGoalProgressButton = new JButton("Calorie goal progress");
    private JButton proteinGoalProgressButton = new JButton("Protein goal progress");
    private JButton fatGoalProgressButton = new JButton("Fat goal progress");

    /** 
     * This method creates, positions, and adds Java Swing objects into the food diary window
     * along with inheriting properties from the constructor class
     */
 public void createFoodDiaryWindow() {
        // The layout to print the date today on this window
        int months = 1;
        if(formattedDate.equals("")){
            startDate = LocalDate.now();
            currentDate = startDate;
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            // Gets the day of the week today
            currentDay = LocalDate.now();
        }
        
        dayOfWeekText.setText("  - " + currentDate.getDayOfWeek().toString());

        // Sets the dateText Label
        for (int i = 0; i < months; i++) {
            formattedDate = dateFormat.format(java.sql.Date.valueOf(currentDate));
            dateText.setText(formattedDate);
        }

        diaryTextArea.setEditable(false);
        diaryTextArea.setLineWrap(true);
        diaryTextArea.setWrapStyleWord(true);
        diaryTextArea.setFont(font);

        // Set the JTextArea as the view of the scroll pane
        diaryScrollPane = new JScrollPane(diaryTextArea);

        // Makes the scroll bar always appear
        diaryScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 

        // Centers the button to the middle of the window
        calorieGoalProgressButton.setHorizontalAlignment(SwingConstants.CENTER);

        // Initializes the action events for the buttons
        enterFoodNameButton.addActionListener(this);
        calorieGoalProgressButton.addActionListener(this);
        nextDayButton.addActionListener(this);
        enterCalorieGoalButton.addActionListener(this);
        proteinGoalProgressButton.addActionListener(this);
        fatGoalProgressButton.addActionListener(this);


        // Sets the positions and sizes of the label, button, and TextField (1100x680)
        applicationNameText.setBounds(375, 55, 350, 60);
        foodDiaryText.setBounds(800, 110, 200, 30);
        enterCalorieGoalText.setBounds(150, 180, 350, 30);
        recommendedCalorieGoalText.setBounds(190, 210, 250, 30);
        enterCalorieInputTextField.setBounds(185, 245, 150, 30);
        enterCalorieGoalButton.setBounds(350,245, 80, 30);
        addFoodText.setBounds(180, 350, 250, 30);
        inputFoodNameTextField.setBounds(185,385,150,30);
        enterFoodNameButton.setBounds(350, 385, 80, 30);
        dateText.setBounds(50,25,120,30);
        dayOfWeekText.setBounds(130,25,150,30);
        diaryScrollPane.setBounds(700,150,300,400);
        nextDayButton.setBounds(950,580,100,30);
        dailyCalorieGoal.setBounds(360, 210, 200, 30);
        calorieGoalProgressButton.setBounds(120,580,220,30);
        proteinGoalProgressButton.setBounds(390,580,220,30);
        fatGoalProgressButton.setBounds(660,580,180,30);
        
        // The font and size of each label and button
        header1(applicationNameText);
        header3(foodDiaryText);
        header3(enterCalorieGoalText);
        header4(recommendedCalorieGoalText);
        header3(addFoodText);
        header4(dateText);
        header4(dayOfWeekText);
        header5(calorieGoalProgressButton);
        header5(proteinGoalProgressButton);
        header5(fatGoalProgressButton);
        header5(nextDayButton);
        header4(dailyCalorieGoal);

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
        add(nextDayButton);
        add(diaryScrollPane);
        add(dateText);
        add(dayOfWeekText);
        add(dailyCalorieGoal);
        add(calorieGoalProgressButton);
        add(proteinGoalProgressButton);
        add(fatGoalProgressButton);

        diaryTextArea.append(diaryText);
        if(userCalories != ""){
            enterCalorieGoalButton.setVisible(false);
            isCalorieGoalEntered = true;
            dailyCalorieGoal.setText("Calorie goal : " + userCalories + "g");
        }
    }

    /** 
     * Dictates what happens when each button is pressed
     * 
     * @param e The event when a button is clicked occurs
     * 
     * This method finds and gets the event when a button is clicked. If the calorie button is clicked,
     * then it will store the int value into DailyTotals.csv file and dissapears until the next day button is clicked.
     * When the user enters a food and clicks the enter food button, it will pop up onto the diary and record the amount of
     * protein, fat, and calories of the food and stores it into a csv file. The goal progress button will dispose the current window
     * and create the goal progress window.
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterCalorieGoalButton){
            // Gets the text inside the calorie text field when the use presses the 'enter' button
            userCalories = enterCalorieInputTextField.getText();
            Validate.calorieGoal = userCalories;
            // If the calorie goal is valid display the users calorie goal
            if (Validate.validateCalorieGoal()==true){
                // Hides the 'enter' button so the user cannot change their calorie goal
                enterCalorieGoalButton.setVisible(false);
                enterCalorieInputTextField.setText(""); // Why do we need this?
                isCalorieGoalEntered = true;
                dailyCalorieGoal.setText("Calorie goal : " + userCalories + "g");
            }
            // If the calorie goal is invalid, display an error message
            else{
                enterCalorieInputTextField.setText("");
                JOptionPane.showMessageDialog(null, "Error. Invalid Calorie Goal, Enter a Number (1500-10000).");
            }             
        }
        else if (e.getSource() == enterFoodNameButton){
            String food = inputFoodNameTextField.getText();
            Validate.foodName = food;

            // Displays error message if calorie goal is not entered
            if (isCalorieGoalEntered == false){
                JOptionPane.showMessageDialog(null, "Enter your calorie goal first!");
                inputFoodNameTextField.setText("");
            }

            // If the user doesn't write anything down / does not enter a String and presses the 'enter' button, an error message pops up
            else if (Validate.validateFoodName() == false){
                JOptionPane.showMessageDialog(null, "Error. Please Enter a Food Name (A-Z)");
                inputFoodNameTextField.setText("");
            }

            // If there is a valid String inside the text field, the webscraper fetches it and sees if the food is in their database
            else{
                WebScraper.food = food;
                Boolean foodExists = false;
                
                // Checks if food data already exists in FoodData.csv before web scraping
                for(String element: ReadCSV.readCol(0, "FoodData.csv", "/", 4)){
                    if(food.equals(element)){
                        foodExists = true;
                        WebScraper.validInput = true;
                    }
                }

                // If food data doesn't exist, runs web scraper
                if(foodExists == false){
                    try {
                    WebScraper.addKeywordDelimiters();
                    WebScraper.setFoodDataPageURL();

                    WebScraper.getCalorieData();
                    WebScraper.getFatData();
                    WebScraper.getProteinData();

                    WebScraper.writeData();
                    }
                    catch (Exception e2) {

                    }
                }

                // It the web scraper found a valid food item (did not return "Page Not Found" error), display in food diary
                if(WebScraper.validInput == true){
                    diaryTextArea.append(food + "\n");
                    diaryTextArea.append(WebScraper.displayScrollPaneText() + "\n");
                    diaryTextArea.append("_______________________________\n");
                    inputFoodNameTextField.setText("");

                    // Reset validInput to false default to prevent next inputted food from skipping validation
                    WebScraper.validInput = false;

                    try {
                        WriteCSV.writeIntake();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid food name");
                }
            }            
        }

        // Goes to the calorie goal progress window
        else if (e.getSource() == calorieGoalProgressButton){
            if (isCalorieGoalEntered == false){
                JOptionPane.showMessageDialog(null, "Enter your calorie goal first!");
                inputFoodNameTextField.setText("");
            }
            else{
                diaryText = diaryTextArea.getText();

                dispose();
                CalorieGoalTrackerWindow calorieGoalTrackerWindow = new CalorieGoalTrackerWindow();
                calorieGoalTrackerWindow.createCalorieGoalTrackerWindow();
            }
        }
                // Goes to the protein goal progress window
        else if (e.getSource() == proteinGoalProgressButton){
            if (isCalorieGoalEntered == false){
                JOptionPane.showMessageDialog(null, "Enter your calorie goal first!");
                inputFoodNameTextField.setText("");
            }
            else{
                diaryText = diaryTextArea.getText();

                dispose();
                ProteinGoalTrackerWindow proteinGoalTrackerWindow = new ProteinGoalTrackerWindow();
                proteinGoalTrackerWindow.createProteinGoalTrackerWindow();
            }
        }

        // Goes to the fat goal progress window
        else if (e.getSource() == fatGoalProgressButton){
            if (isCalorieGoalEntered == false){
                JOptionPane.showMessageDialog(null, "Enter your calorie goal first!");
                inputFoodNameTextField.setText("");
            }
            else{
                diaryText = diaryTextArea.getText();

                dispose();
                FatGoalTrackerWindow fatGoalTrackerWindow = new FatGoalTrackerWindow();
                fatGoalTrackerWindow.createFatGoalTrackerWindow();
            }
        }

        // When the next day button is pressed, it changes the date and day
        else if (e.getSource() == nextDayButton){
            // Writes the daily totals to DailyTotals.csv
            try {
                WriteCSV.writeTotals();
            } catch (IOException e1) {
                e1.printStackTrace();
            } 

            // Parses the current date from the label text
            currentDate = LocalDate.parse(dateText.getText());

            // Increments the current date by 1 day when the next day button is pressed
            currentDate = currentDate.plusDays(1); 

             // Convert the updated date back to a string since labels only accept a String as text
            formattedDate = currentDate.toString();

            // Set the updated date as the text of the label
            dateText.setText(formattedDate); 

            // Displays the next day of the week (increments it by 1)
            currentDay = currentDay.plusDays(1);
            dayOfWeekText.setText("  - " + currentDate.getDayOfWeek().toString());

            // The enter calorie goal button will reappear since it is the next day
            enterCalorieGoalButton.setVisible(true);

            // Resets values related to the previous day
            isCalorieGoalEntered = false;
            userCalories = "";
            dailyCalorieGoal.setText("");
            enterCalorieInputTextField.setText("");
            inputFoodNameTextField.setText("");
            diaryTextArea.setText("");
            dailyCalorieGoal.setText("");
        }
    }
}