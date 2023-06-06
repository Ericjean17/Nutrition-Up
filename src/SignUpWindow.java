import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class SignUpWindow extends WindowConstructor implements ActionListener{
    
    // Idk if the TextFields should be public or private.
    // Should the controller gather the data using the TextField and button variables in this class?
    
    // Creates the labels, buttons, and TextFields, and ComboBox assign it to a variable
    private JLabel applicationNameText = new JLabel("Nutrition Up!");
    private JLabel createAccountText = new JLabel("Create an account");
    private JLabel createUsernameText = new JLabel("Enter a username");
    public JTextField createUsernameTextField = new JTextField(10);
    private JLabel enterGenderText = new JLabel("Enter your gender");
    private JLabel enterAgeText = new JLabel("Enter your age");
    public JTextField inputAgeTextField = new JTextField(10);
    private JLabel enterWeightText = new JLabel("Enter your weight");
    public JTextField inputWeightTextField = new JTextField(10);
    private JLabel enterHeightText = new JLabel("Enter your height");
    public JTextField inputHeightTextField = new JTextField(10);
    public JButton backButton = new JButton("Back");
    public JButton createUserAccount = new JButton("Create Account");

    String[] gender = {"Male", "Female"};
    public JComboBox genderComboBox = new JComboBox(gender);
    
    public void createSignUpWindow() {
        
        // Set the positions and sizes of the labels, buttons, and TextFields, and ComboBox in this wind
        applicationNameText.setBounds(390, 55, 350, 60);
        createAccountText.setBounds(420, 130, 350, 45);
        enterGenderText.setBounds(135,250,150,30);
        createUsernameText.setBounds(475,250,150,30);
        createUsernameTextField.setBounds(455,290,150,30);
        enterAgeText.setBounds(800,250,150,30);
        inputAgeTextField.setBounds(780,290,150,30);
        enterWeightText.setBounds(220,350,150,30);
        inputWeightTextField.setBounds(200,390, 150, 30);
        enterHeightText.setBounds(720,350,200,30);
        inputHeightTextField.setBounds(730,390,150,30);
        backButton.setBounds(430,580,75,30);
        createUserAccount.setBounds(550,580,150,30);
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
        
        // Add the components to the window
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

    @Override
    // *Cannot have multiple actionPerformed action event methods.
    public void actionPerformed(ActionEvent e) {     
        if (e.getSource() == backButton){
            dispose();
            createUsernameTextField.setText("");
            LoginWindow loginWindow = new LoginWindow();
            loginWindow.createLoginWindow();
        }

        // Also include a condition that the user has to input all 5 of these componenets, else a pop-up comes up (dialog box)
        // This also records the values, as you can see in the terminal
        else if (e.getSource() == createUserAccount){
            // TESTING ERROR POP-UP
            String createdUsername = getCreateUsernameTextField().getText();
            String createdAge = getInputAgeTextField().getText();
            String createdWeight = getInputWeightTextField().getText();
            String createdHeight = getInputHeightTextField().getText();

            // only allow user to continue if the conditions are met
            if (UserInfo.isUsernameExists(createdUsername) == false){
                Validate.username = createdUsername;
                Validate.age = createdAge;
                Validate.weight = createdWeight;
                Validate.height = createdHeight;
                if (Validate.validateUsername() == true && Validate.validateAge() == true && Validate.validateWeight() == true && Validate.validateHeight() == true){
                    JOptionPane.showMessageDialog(null, "Hello! " + createdUsername);
                    createUsernameTextField.setText(""); // Clears the text field after saving the values??
                    dispose();
                    createUsernameTextField.setText("");
                    LoginWindow loginWindow = new LoginWindow();
                    loginWindow.createLoginWindow();
                    JOptionPane.showMessageDialog(null, "Successfully created account");
                }
                else if (Validate.validateUsername() == false){
                    //display error message
                    JOptionPane.showMessageDialog(null, "Error. Invalid Username, Enter a Letter (A-Z).");
                    createUsernameTextField.setText(""); // Clears the text field after saving the values??
                }
                else if (Validate.validateAge() == false){
                    //display error message
                    JOptionPane.showMessageDialog(null, "Error. Invalid Age, Enter a Number (0-100).");
                    inputAgeTextField.setText(""); // Clears the text field after saving the values??
                }
                else if (Validate.validateWeight() == false){
                    //display error message
                    JOptionPane.showMessageDialog(null, "Error. Invalid Weight, Enter a Number (2-500).");
                    inputWeightTextField.setText(""); // Clears the text field after saving the values??
                }
                else if (Validate.validateHeight() == false){
                    //display error message
                    JOptionPane.showMessageDialog(null, "Error. Invalid Height, Enter a Number (1-215).");
                    inputHeightTextField.setText(""); // Clears the text field after saving the values??
                }
            }
            else{
                //display error message
                JOptionPane.showMessageDialog(null, "Error. Username Is Taken!");
                createUsernameTextField.setText(""); // Clears the text field after saving the values??
            }

            try{
                // Prints out all of the data in the variables into the terminal to check if it is storing the value correctly
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
                UserInfo.goal = 0; // Set default goal to 0 for now
    
                UserInfo.displayInformation();
                
                UserInfo.storeUserInfo(); // Store the username in the file
                
    
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
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
