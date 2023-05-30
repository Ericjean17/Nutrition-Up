import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FoodDiaryWindow extends WindowConstructor implements ActionListener {
    
    // Idk if the TextFields should be public or private. We need to somehow know how the controller
    // will gather the data using the TextField and button variables 
    
    // Create the label, button, and TextField, and assign it to a variable
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

    public void createFoodDiaryWindow() {
        // Create the diary panel
        diaryScrollPane = new JScrollPane();
        setPreferredSize(new Dimension(200,450));
        
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
    }

    // Creates a new window or gathers data when the buttons are clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterCalorieGoalButton){
            // I assume we get the method from the controller to contain or add the data (String)
        }
        else if (e.getSource() == enterFoodNameButton){
            // I assume we get the method from the controller to contain or add the data (String)
        }
        else if (e.getSource() == goalProgressButton){
            dispose();
            GoalTrackerWindow goalTrackerWindow = new GoalTrackerWindow();
            goalTrackerWindow.createGoalTrackerWindow();
        }
        else if (e.getSource() == nextDayButton){
            // Idk what to do here yet
        }
    }

    // Is the button functionality built into these windows or the controller?
}

