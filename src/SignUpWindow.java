import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Frame;

public class SignUpWindow extends WindowConstructor {
    
    // Idk if the TextFields should be public or private. We need to somehow know how the controller
    // will gather the data using the TextField and button variables 
    
    // Create the label, button, and TextField, and assign it to a variable
    private JLabel applicationNameText = new JLabel("Nutrition Up!");
    private JLabel createAccountText = new JLabel("Create an account");
    private JLabel createUsernameText = new JLabel("Enter a username");
    public JTextField createUsernameTextField = new JTextField(10);
    private JLabel enterGenderText = new JLabel("Enter your gender (m/f)");
    public JTextField inputGenderTextField = new JTextField(10);
    private JLabel enterAgeText = new JLabel("Enter your age");
    public JTextField inputAgeTextField = new JTextField(10);
    private JLabel enterWeightText = new JLabel("Enter your weight");
    public JTextField inputWeightTextField = new JTextField(10);
    private JLabel enterHeightText = new JLabel("Enter your height in metres");
    public JTextField inputHeightTextField = new JTextField(10);
    public JButton backButton = new JButton("Back");
    public JButton createUserAccount = new JButton("Create Account");

    // Don't know how to get the Dialog box in the signUpWindow
    //private JDialog invalidInputAlert = new JTextField(signUpWindow, "Not a valid input");
    
    public void createSignUpWindow() {
        // Window is 1100x680
        // Set the positions and sizes of the label, button, and TextField
        applicationNameText.setBounds(490, 55, 200, 30);
        createAccountText.setBounds(480, 70, 150, 30);
        enterGenderText.setBounds(150,250,150,30);
        inputGenderTextField.setBounds(130,290,150,30);
        createUsernameText.setBounds(475,250,150,30);
        createUsernameTextField.setBounds(455,290,150,30);
        enterAgeText.setBounds(800,250,150,30);
        inputAgeTextField.setBounds(780,290,150,30);
        enterWeightText.setBounds(220,350,150,30);
        inputWeightTextField.setBounds(200,390, 150, 30);
        enterHeightText.setBounds(720,350,200,30);
        inputHeightTextField.setBounds(730,390,150,30);
        backButton.setBounds(430,580,80,30);
        createUserAccount.setBounds(550,580,125,30);
        
        // Add the components to the window
        add(applicationNameText);
        add(createAccountText);
        add(createUsernameText);
        add(createUsernameTextField);
        add(enterGenderText);
        add(inputGenderTextField);
        add(enterAgeText);
        add(inputAgeTextField);
        add(enterWeightText);
        add(inputWeightTextField);
        add(enterHeightText);
        add(inputHeightTextField);
        add(backButton);
        add(createUserAccount);
        //add(invalidInputAlert);
    }

    // Is the button functionality built into these windows or the controller?
}

