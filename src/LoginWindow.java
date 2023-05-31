import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends WindowConstructor implements ActionListener {
    
    // Create the labels, buttons, and TextFields, and assign it to a variable
    private JLabel applicationNameText = new JLabel("Nutrition Up!");
    private JLabel loginText = new JLabel("Login");
    private JLabel noAccountText = new JLabel("Don't have an account?");
    private JLabel usernameText = new JLabel("Enter your username");
    private JButton loginButton = new JButton("Login Button");
    private JTextField inputUsernameTextField = new JTextField(10);
    public JButton signUpButton = new JButton("Sign up");
        
    // Don't know how to get the Diaglog to pop up in the login window
    //public JDialog invalidInputDialogBox = new JDialog(loginWindow, "It is not a username");
    
    String inputtedUsername = "";

    public void createLoginWindow() {
        
        // Initializes the action events for the buttons & TextFields
        loginButton.addActionListener(this);
        signUpButton.addActionListener(this);
        inputUsernameTextField.addActionListener(this);
    
        // Set the positions and sizes of the labels, buttons, and TextFields
        applicationNameText.setBounds(490, 55, 200, 30);
        loginButton.setBounds(455, 315, 150, 50);
        usernameText.setBounds(470,205,150,50);
        inputUsernameTextField.setBounds(435, 265, 230, 30);
        loginText.setBounds(505, 100, 100, 30);
        noAccountText.setBounds(475,555,200,30);
        signUpButton.setBounds(480, 590, 100, 30);
        //invalidInputDialogBox.setBounds(500,500,100,30);
        
        // Add the components to the window
        add(applicationNameText);
        add(loginButton);
        add(inputUsernameTextField);
        add(usernameText);
        add(loginText);
        add(noAccountText);
        add(signUpButton);
        //add(invalidInputDialogBox);
    }

    // When pressing the buttons, it creates a new window, and does other stuff like getting data from textfields
    @Override
    public void actionPerformed(ActionEvent e) {

        // When the user presses the login button, gets the String from the TextField, deletes this window, and creates the food diary window
        // Can use e.getActionCommand().equals("input username here");
        if (e.getSource() == loginButton){
            //inputtedUsername = inputUsernameTextField.getText();
            String inputtedUsername = getInputUsernameTextField().getText();
            
            // Here we can use the controller (an if statement) to see if the username recorded is in (a file of user accounts?)
            System.out.println("Username inputted is : " + inputtedUsername);
            dispose();
            inputUsernameTextField.setText(""); // Clears the text field after saving the values??
            FoodDiaryWindow foodDiaryWindow = new FoodDiaryWindow();
            foodDiaryWindow.createFoodDiaryWindow();
        }

        else if (e.getSource() == signUpButton){
            dispose();
            SignUpWindow signUpWindow = new SignUpWindow();
            signUpWindow.createSignUpWindow();
        }
    }

    // Testing out how to return the username that the user inputted (NOT WORKING RN)
    public String getUsername(){
        return inputtedUsername;
    }

    public JTextField getInputUsernameTextField(){
        return inputUsernameTextField;
    }
}
