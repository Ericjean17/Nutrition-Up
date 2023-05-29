import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Frame;

public class SignUpWindow extends WindowConstructor {
    
    // Create the label, button, and TextField, and assign it to a variable
    private JLabel applicationNameText = new JLabel("Nutrition Up!");
    private JLabel createAccountText = new JLabel("Create an account");
    private JLabel createUsernameText = new JLabel("Enter a username");
    private JTextField createUsernameTextField = new JTextField(10);
    private JLabel enterGenderText = new JLabel("Enter your gender (m/f)");
    private JTextField inputGenderTextField = new JTextField(10);
    private JLabel enterAgeText = new JLabel("Enter your age");
    private JTextField inputAgeTextField = new JTextField(10);
    private JLabel enterWeightText = new JLabel("Enter your weight");
    private JTextField inputWeightTextField = new JTextField(10);
    private JLabel enterHeightText = new JLabel("Enter your height in metres");
    private JTextField inputHeightTextField = new JTextField(10);
    private JButton backButton = new JButton("Back");
    private JButton createUserAccount = new JButton("Create Account");

    // Don't know how to get the Dialog box in the signUpWindow
    //private JDialog invalidInputAlert = new JTextField(signUpWindow, "Not a valid input");
    
    public void createLoginWindow() {
        
        // Set the positions and sizes of the label, button, and TextField
        
        
        
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
}

