import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignUpWindow extends WindowConstructor implements ActionListener{
    
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

    String[] gender = {"Male", "Female"};
    public JComboBox genderComboBox = new JComboBox(gender);

    // Don't know how to get the Dialog box in the signUpWindow
    //private JDialog invalidInputAlert = new JTextField(signUpWindow, "Not a valid input");
    
    public void createSignUpWindow() {
        // Set the positions and sizes of the labels, buttons, and TextFields
        applicationNameText.setBounds(490, 55, 200, 30);
        createAccountText.setBounds(480, 70, 150, 30);
        enterGenderText.setBounds(150,250,150,30);
        //inputGenderTextField.setBounds(130,290,150,30);
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
        
        genderComboBox.setBounds(130,290,150,30);
        
        // Initializes the action events for the buttons & combobox
        createUserAccount.addActionListener(this);
        backButton.addActionListener(this);
        genderComboBox.addActionListener(this);
        
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

        add(genderComboBox);
    }

    @Override
    // Btw, cannot have multiple actionPerformed action event methods.
    public void actionPerformed(ActionEvent e) {
        // * Since both of these buttons lead to the same window, we need to add code to save the data
        // when the createAccount buttons is pressed and not save any data when the back button is pressed
        // IGNORE THIS STATEMENT
        
        // Idk how this works tbh
        if (e.getSource() == backButton){
            dispose();
            createUsernameTextField.setText("");
            LoginWindow loginWindow = new LoginWindow();
            loginWindow.createLoginWindow();
        }

        // Also have the condition that the user has to input all 5 of these componenets, else a pop-up comes up (dialog box)
        // This also records the values, as you can see in the terminal
        else if (e.getSource() == createUserAccount){
            String createdUsername = createUsernameTextField.getText();
            String inputtedGender = inputGenderTextField.getText(); // Maybe use a dropdown menu instead (so it only has m and f as an option)
            int inputtedAge = Integer.parseInt(inputAgeTextField.getText());
            int inputtedWeight = Integer.parseInt(inputAgeTextField.getText());
            int inputtedHeight = Integer.parseInt(inputAgeTextField.getText());
            String selectedGender = (String) genderComboBox.getSelectedItem();
            
            System.out.println("username: " + createdUsername);
            //System.out.println("gender: " + inputtedGender);
            System.out.println("gender: " + selectedGender);
            System.out.println("age: " + inputtedAge);
            System.out.println("weight: " + inputtedWeight);
            System.out.println("height: " + inputtedHeight);
            
            dispose();
            createUsernameTextField.setText("");
            LoginWindow loginWindow = new LoginWindow();
            loginWindow.createLoginWindow();
        }

        else if (e.getSource() == genderComboBox){
            System.out.println(genderComboBox.getSelectedItem());
        }
    }
}

