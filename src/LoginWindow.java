import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends WindowConstructor implements ActionListener {
    // Create the label, button, and TextField, and assign it to a variable

    private JLabel applicationNameText = new JLabel("Nutrition Up!");
    private JLabel loginText = new JLabel("Login");
    private JLabel noAccountText = new JLabel("Don't have an account?");
    private JLabel usernameText = new JLabel("Enter your username");
    private JButton loginButton = new JButton("Login Button");
    private JTextField inputUsernameTextField = new JTextField(10);
    public JButton signUpButton = new JButton("Sign up");
    
    //LoginWindow loginWindow = new LoginWindow();
    
    // Don't know how to get the Diaglog to pop up in the login window
    // public JDialog invalidInputDialogBox = new JDialog(loginWindow, "It is not a username");
    
    public void createLoginWindow() {
        //loginWindow.setVisibility(true);
        //loginWindow.createLoginWindow();
        
        
        loginButton.addActionListener(this);
        signUpButton.addActionListener(this);
    
        // Set the positions and sizes of the label, button, and TextField
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

    // When pressing the buttons, it creates a new window
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton){
            dispose();
            FoodDiaryWindow foodDiaryWindow = new FoodDiaryWindow();
            foodDiaryWindow.createFoodDiaryWindow();
            dispose();
        }
        else if (e.getSource() == signUpButton){
            dispose();
            SignUpWindow signUpWindow = new SignUpWindow();
            signUpWindow.createSignUpWindow();
        }
    }
}
