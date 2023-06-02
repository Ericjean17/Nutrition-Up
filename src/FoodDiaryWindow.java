import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
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
    private JLabel addFoodText = new JLabel("Add a food to your diary");
    public JButton goalProgressButton = new JButton("See goal progress");
    public JButton nextDayButton = new JButton("Next day");

    // We need a panel to make it so the user can scroll down with the ScrollPane
    private JScrollPane diaryScrollPane = new JScrollPane();

    public JTextField inputFoodNameTextField = new JTextField(20);
    public JButton enterFoodNameButton = new JButton("Enter");

    // Displays what the user ate using a TextArea
    private JTextArea diaryTextArea = new JTextArea();

    // The text for displaying the current date and day of the week
    public JLabel dateText = new JLabel("");
    private LocalDate currentDay;
    private LocalDate startDate;
    public JLabel dayOfWeekText = new JLabel("");

    public void createFoodDiaryWindow() {

        // The logic to print the date on this window
        startDate = LocalDate.now();
        int months = 1;
        LocalDate currentDate = startDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // The code to get the day of the week today
        currentDay = LocalDate.now();
        dayOfWeekText.setText("  - " + currentDate.getDayOfWeek().toString());

        for (int i = 0; i < months; i++) {
            String formattedDate = dateFormat.format(java.sql.Date.valueOf(currentDate));
            dateText.setText(formattedDate);
            currentDate = currentDate.plusMonths(1);
        }

        diaryTextArea.setEditable(false); // Makes it so the diary is uneditable by the user
        diaryTextArea.setLineWrap(true);
        diaryTextArea.setWrapStyleWord(true);
        diaryScrollPane = new JScrollPane(diaryTextArea); // Set the JTextArea as the view of the scroll pane
        //diaryScrollPane.setViewportView(diaryTextArea);
        
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

        // Initializes the action events for the buttons
        enterCalorieGoalButton.addActionListener(this);
        enterFoodNameButton.addActionListener(this);
        goalProgressButton.addActionListener(this);
        nextDayButton.addActionListener(this);
        
        // Set the positions and sizes of the label, button, and TextField (1100x680)
        applicationNameText.setBounds(400, 55, 400, 55);
        foodDiaryText.setBounds(800, 80, 200, 30);
        enterCalorieGoalText.setBounds(155, 210, 350, 30);
        recommendedCalorieGoalText.setBounds(180, 235, 250, 30);
        enterCalorieInputTextField.setBounds(140, 265, 150, 30);
        enterCalorieGoalButton.setBounds(300,265, 80, 30);
        addFoodText.setBounds(180, 350, 250, 30);
        inputFoodNameTextField.setBounds(140,380,150,30);
        enterFoodNameButton.setBounds(300, 380, 80, 30);
        dateText.setBounds(50,25,120,30);
        dayOfWeekText.setBounds(130,25,150,30);

        diaryScrollPane.setBounds(700,120,300,400);
        
        goalProgressButton.setBounds(440,570,180,30);
        nextDayButton.setBounds(930,580,130,30);
        
        // The font and size of each label
        header1(applicationNameText);
        header3(foodDiaryText);
        header3(enterCalorieGoalText);
        header4(recommendedCalorieGoalText);
        header3(addFoodText);
        header4(dateText);
        header4(dayOfWeekText);
        header5(goalProgressButton);
        header5(nextDayButton);

        // Add the components to the window
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

            if (food.equals("")){
                JOptionPane.showMessageDialog(null, "Enter your food!");

            }
            /*
            else if(the keyword cannot fetch the food){
                JOptionPane.showMessageDialog(null, "This is not a valid food!");
            }
            */
            else{
                try {
                    WebScraper.keyword = food;
                    WebScraper.setFoodDataPageURL();
                    WebScraper.getNutritionData();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                System.out.println("User ate this " + food);
                diaryTextArea.append(food + "\n");
                diaryTextArea.append("----------------------------------------------------------------------\n");
                inputFoodNameTextField.setText("");
            }            
        }
        else if (e.getSource() == goalProgressButton){
            dispose();
            GoalTrackerWindow goalTrackerWindow = new GoalTrackerWindow();
            goalTrackerWindow.createGoalTrackerWindow();
        }

        else if (e.getSource() == nextDayButton){
            LocalDate currentDate = LocalDate.parse(dateText.getText()); // Parse the current date from the label text
            currentDate = currentDate.plusDays(1); // Increment the current date by 1 day when the next day button is pressed
            String formattedDate = currentDate.toString(); // Convert the updated date back to a string
            dateText.setText(formattedDate); // Set the updated date as the text of the label (dateText only takes a String)

            // Display the next day of the week
            currentDay = currentDay.plusDays(1);
            dayOfWeekText.setText("  - " + currentDate.getDayOfWeek().toString());

            enterCalorieGoalButton.setVisible(true);
            enterCalorieInputTextField.setText("");
            inputFoodNameTextField.setText("");
            diaryTextArea.setText("");
        }
    }
}