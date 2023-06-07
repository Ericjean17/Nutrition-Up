import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends WindowConstructor implements ActionListener {
    
    // Create the labels, buttons, and TextFields, and assigns it to a variable
    private JLabel applicationNameText = new JLabel("Nutrition Up!", SwingConstants.CENTER);
    private JLabel loginText = new JLabel("Login", SwingConstants.CENTER);
    private JLabel noAccountText = new JLabel("Don't have an account?", SwingConstants.CENTER);
    private JLabel usernameText = new JLabel("Enter your username", SwingConstants.CENTER);
    private JButton loginButton = new JButton("Login!");
    private JTextField inputUsernameTextField = new JTextField(10);
    private JButton signUpButton = new JButton("Sign up");
    public String inputtedUsername = "";
    
    public void createLoginWindow() {
        
        // Initializes the action events for the buttons & TextFields
        loginButton.addActionListener(this);
        signUpButton.addActionListener(this);
        inputUsernameTextField.addActionListener(this);

        // Center buttons and TextFields
        loginButton.setHorizontalAlignment(SwingConstants.CENTER);
        signUpButton.setHorizontalAlignment(SwingConstants.CENTER);
        inputUsernameTextField.setHorizontalAlignment(SwingConstants.CENTER);
    
        // Sets the positions and sizes of the labels, buttons, and TextFields
        applicationNameText.setBounds(375, 55, 350, 60); // (width of window - width of object)/2 to center it
        loginButton.setBounds(500, 315, 100, 40);
        usernameText.setBounds(450,205,200,50);
        inputUsernameTextField.setBounds(435, 265, 230, 30);
        loginText.setBounds(475, 130, 150, 45);
        noAccountText.setBounds(425,500,250,30);
        signUpButton.setBounds(500, 540, 100, 30);
    
        // The font and size of each label and button
        header1(applicationNameText);
        header2(loginText);
        header3(usernameText);
        header3(noAccountText);
        header5(loginButton);
        header5(signUpButton);

        // Adds the components to the window
        add(applicationNameText);
        add(loginButton);
        add(inputUsernameTextField);
        add(usernameText);
        add(loginText);
        add(noAccountText);
        add(signUpButton);
    }

    // This method is to create any actions or events that occurs from user input
    @Override
    public void actionPerformed(ActionEvent e) {

        // When the user presses the login button, it gets the String from the TextField and validates the username
        if (e.getSource() == loginButton){
            String inputtedUsername = getInputUsernameTextField().getText();
            // If the username is in the library, deletes the current window and changes to the food diary window
            if (UserInfo.isUsernameExists(inputtedUsername) == true){
                System.out.println("Username inputted is : " + inputtedUsername);
                JOptionPane.showMessageDialog(null, "Hello! " + inputtedUsername);
                inputUsernameTextField.setText(""); // Clears the text field after saving the values??
                dispose();
                FoodDiaryWindow foodDiaryWindow = new FoodDiaryWindow();
                foodDiaryWindow.createFoodDiaryWindow();
            }
            else{
                // Displays an error message if the username is not validated or not in the user info csv file
                JOptionPane.showMessageDialog(null, "Error. Please Input An Existing Username.");

                // Clears the text field after saving the values
                inputUsernameTextField.setText("");
            }    
        }

        // Creates a new sign up window if the user presses the sign up button
        else if (e.getSource() == signUpButton){
            setVisible(false);
            SignUpWindow signUpWindow = new SignUpWindow();
            signUpWindow.createSignUpWindow();
        }
    }

    // Gets the input from the username TextField
    public JTextField getInputUsernameTextField(){
        return inputUsernameTextField;
    }
}
