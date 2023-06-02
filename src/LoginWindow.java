import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginWindow extends WindowConstructor implements ActionListener {
    
    // Create the labels, buttons, and TextFields, and assign it to a variable
    private JLabel applicationNameText = new JLabel("Nutrition Up!");
    private JLabel loginText = new JLabel("Login");
    private JLabel noAccountText = new JLabel("Don't have an account?");
    private JLabel usernameText = new JLabel("Enter your username");
    private JButton loginButton = new JButton("Login!");
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
        applicationNameText.setBounds(390, 55, 350, 60);
        loginButton.setBounds(485, 315, 100, 50);
        usernameText.setBounds(450,205,200,50);
        inputUsernameTextField.setBounds(435, 265, 230, 30);
        loginText.setBounds(495, 130, 150, 45);
        noAccountText.setBounds(430,500,250,30);
        signUpButton.setBounds(480, 540, 100, 30);
    
        // The font and size of each label
        header1(applicationNameText);
        header2(loginText);
        header3(usernameText);
        header3(noAccountText);
        header4(loginButton);
        header4(signUpButton);

        // Add the components to the window
        add(applicationNameText);
        add(loginButton);
        add(inputUsernameTextField);
        add(usernameText);
        add(loginText);
        add(noAccountText);
        add(signUpButton);
    }

    // When pressing the buttons, it creates a new window, and does other stuff like getting data from textfields
    @Override
    public void actionPerformed(ActionEvent e) {

        // When the user presses the login button, gets the String from the TextField, deletes this window, and creates the food diary window
        // Can use e.getActionCommand().equals("input username here");
        if (e.getSource() == loginButton){
            //inputtedUsername = inputUsernameTextField.getText();
            String inputtedUsername = getInputUsernameTextField().getText();
            
            try { 
                UserInfo.username = inputtedUsername;
                UserInfo.storeUsername();
            }
            catch(IOException e5) {
                e5.printStackTrace();
            }

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
