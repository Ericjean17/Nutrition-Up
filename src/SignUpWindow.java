import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class SignUpWindow extends WindowConstructor implements ActionListener{
    
    // Creates the labels, buttons, and TextFields, and ComboBox and assigns it to a variable
    private JLabel applicationNameText = new JLabel("Nutrition Up!", SwingConstants.CENTER);
    private JLabel createAccountText = new JLabel("Create an account", SwingConstants.CENTER);
    private JLabel createUsernameText = new JLabel("Enter a username", SwingConstants.CENTER);
    private JTextField createUsernameTextField = new JTextField(10);
    private JLabel enterGenderText = new JLabel("Enter your gender");
    private JLabel enterAgeText = new JLabel("Enter your age");
    private JTextField inputAgeTextField = new JTextField(10);
    private JLabel enterWeightText = new JLabel("Enter your weight");
    private JTextField inputWeightTextField = new JTextField(10);
    private JLabel enterHeightText = new JLabel("Enter your height");
    private JTextField inputHeightTextField = new JTextField(10);
    private JButton backButton = new JButton("Back");
    private JButton createUserAccount = new JButton("Create Account");
    String[] gender = {"Male", "Female"};
    public JComboBox genderComboBox = new JComboBox(gender);
    
    public void createSignUpWindow() {
        
        // Set the positions and sizes of the labels, buttons, and TextFields, and ComboBox in this wind
        applicationNameText.setBounds(375, 55, 350, 60);
        createAccountText.setBounds(375, 130, 350, 45);
        enterGenderText.setBounds(135,250,150,30);
        createUsernameText.setBounds(475,250,150,30);
        createUsernameTextField.setBounds(475,290,150,30);
        enterAgeText.setBounds(795,250,150,30);
        inputAgeTextField.setBounds(780,290,150,30);
        enterWeightText.setBounds(237,365,150,30);
        inputWeightTextField.setBounds(232,405, 150, 30);
        enterHeightText.setBounds(675,365,200,30);
        inputHeightTextField.setBounds(670,405,150,30);
        backButton.setBounds(30,30,70,30);
        createUserAccount.setBounds(475,580,150,30);
        genderComboBox.setBounds(130,290,150,30);
        
        // Initializes the action events for the buttons & ComboBox
        createUserAccount.addActionListener(this);
        backButton.addActionListener(this);
        genderComboBox.addActionListener(this);

        // The font and size of each label and button
        header1(applicationNameText);
        header2(createAccountText);
        header5(backButton);
        header5(createUserAccount);
        header4(enterGenderText);
        header4(createUsernameText);
        header4(enterAgeText);
        header4(enterWeightText);
        header4(enterHeightText);
        
        // Adds the components to the window
        add(applicationNameText);
        add(createAccountText);
        add(createUsernameText);
        add(createUsernameTextField);
        add(enterGenderText);
        add(enterAgeText);
        add(inputAgeTextField);
        add(enterWeightText);
        add(inputWeightTextField);
        add(enterHeightText);
        add(inputHeightTextField);
        add(backButton);
        add(createUserAccount);
        add(genderComboBox);
    }

    // If the user hits the back button, deletes the current window and goes to the login window
    @Override
    public void actionPerformed(ActionEvent e) {     
        if (e.getSource() == backButton){
            dispose();
            createUsernameTextField.setText("");
            LoginWindow loginWindow = new LoginWindow();
            loginWindow.createLoginWindow();
        }

        // If the user presses the create account button, they need to put in valid values to create an account.
        // Then it goes back to the login window.
        else if (e.getSource() == createUserAccount){
            // TESTING ERROR POP-UP
            String createdUsername = getCreateUsernameTextField().getText();
            String createdAge = getInputAgeTextField().getText();
            String createdWeight = getInputWeightTextField().getText();
            String createdHeight = getInputHeightTextField().getText();

            // Validate the user's inputs
            // First check if the username the user has inputted already exists
            if (UserInfo.isUsernameExists(createdUsername) == false){
                Validate.username = createdUsername;
                Validate.age = createdAge;
                Validate.weight = createdWeight;
                Validate.height = createdHeight;
                // Only allow user to continue if the conditions are met
                // If conditions are met, deletes the sign up window and opens login window
                if (Validate.validateUsername() == true && Validate.validateAge() == true && Validate.validateWeight() == true && Validate.validateHeight() == true){
                    JOptionPane.showMessageDialog(null, "Hello! " + createdUsername);
                    createUsernameTextField.setText(""); // Clears the text field after saving the values??
                    dispose();
                    createUsernameTextField.setText("");
                    LoginWindow loginWindow = new LoginWindow();
                    loginWindow.createLoginWindow();
                    JOptionPane.showMessageDialog(null, "Successfully created account");
                }
                // If the inputted username is not alphabetical, display error message
                else if (Validate.validateUsername() == false){
                    JOptionPane.showMessageDialog(null, "Error. Invalid Username, Enter a Letter (A-Z).");
                    createUsernameTextField.setText(""); // Clears the text field after saving the values??
                }
                // If the inputted age is not numerical, display error message
                else if (Validate.validateAge() == false){
                    JOptionPane.showMessageDialog(null, "Error. Invalid Age, Enter a Number (0-100).");
                    inputAgeTextField.setText(""); // Clears the text field after saving the values??
                }
                // If the inputted weight is not numerical, display error message
                else if (Validate.validateWeight() == false){
                    JOptionPane.showMessageDialog(null, "Error. Invalid Weight, Enter a Number (2-500).");
                    inputWeightTextField.setText(""); // Clears the text field after saving the values??
                }
                // If the inputted height is not numerical, display error message
                else if (Validate.validateHeight() == false){
                    JOptionPane.showMessageDialog(null, "Error. Invalid Height, Enter a Number (1-215).");
                    inputHeightTextField.setText(""); // Clears the text field after saving the values??
                }
            }
            // If the username already exists, display error message
            else{
                JOptionPane.showMessageDialog(null, "Error. Username Is Taken!");
                createUsernameTextField.setText(""); // Clears the text field after saving the values??
            }

            try{
                // Prints out all of the data in the variables into the terminal to check if it is storing the value correctly
                // *DELETE PRINT STATEMENTS LATER
                int inputtedAge = Integer.parseInt(getInputAgeTextField().getText());
                System.out.println("Valid age: " + inputtedAge);
                
                System.out.println("username: " + createdUsername);
                
                String selectedGender = (String) getGenderInputComboBox().getSelectedItem();
                System.out.println("gender: " + selectedGender);

                int inputtedWeight = Integer.parseInt(getInputWeightTextField().getText());
                System.out.println("weight: " + inputtedWeight);

                int inputtedHeight = Integer.parseInt(getInputHeightTextField().getText());
                System.out.println("height: " + inputtedHeight);

                UserInfo.username = createdUsername;
                UserInfo.age = inputtedAge;
                UserInfo.gender = selectedGender;
                UserInfo.weight = inputtedWeight;
                UserInfo.height = inputtedHeight;
                UserInfo.goal = 0; // Set default goal to 0 because we don't know user's calorie goal
    
                UserInfo.displayInformation();
                
                UserInfo.storeUserInfo(); // Store the username in the file
                
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        // Gets the item (man or female) in the drop down box
        else if (e.getSource() == genderComboBox){
            System.out.println(genderComboBox.getSelectedItem());
        }
    }

    public JTextField getCreateUsernameTextField() {
        return createUsernameTextField;
    }
    
    public JTextField getInputAgeTextField() {
        return inputAgeTextField;
    }
    
    public JTextField getInputWeightTextField() {
        return inputWeightTextField;
    }
    
    public JTextField getInputHeightTextField() {
        return inputHeightTextField;
    }

    public JComboBox getGenderInputComboBox(){
        return genderComboBox;
    }
}
