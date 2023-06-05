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
            try{
                // Prints out all of the data in the variables into the terminal to check if it is storing the value correctly
                // *DELETE PRINT STATEMENTS LATER
                int inputtedAge = Integer.parseInt(getInputAgeTextField().getText());
                System.out.println("Valid age: " + inputtedAge);
                
                String createdUsername = getCreateUsernameTextField().getText();
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
                
                UserInfo.storeUserInfo(); // Store the username in the csv file
    
                JOptionPane.showMessageDialog(null, "Successfully created account");
                dispose();
                createUsernameTextField.setText("");
                LoginWindow loginWindow = new LoginWindow();
                loginWindow.createLoginWindow();
                
            } catch (NumberFormatException o) {
                JOptionPane.showMessageDialog(null, "Not a valid input");
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
