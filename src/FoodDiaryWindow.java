import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Frame;

public class FoodDiaryWindow extends WindowConstructor {
    
    // Idk if the TextFields should be public or private. We need to somehow know how the controller
    // will gather the data using the TextField and button variables 
    
    // Create the label, button, and TextField, and assign it to a variable
    private JLabel applicationNameText = new JLabel("Nutrition Up!");
    public JTextField inputHeightTextField = new JTextField(10);
    public JButton backButton = new JButton("Back");

    // Don't know how to get the Dialog box in the signUpWindow
    //private JDialog invalidInputAlert = new JTextField(signUpWindow, "Not a valid input");
    
    public void createSignUpWindow() {
        // Window is 1100x680
        // Set the positions and sizes of the label, button, and TextField

        
        // Add the components to the window

    }

    // Is the button functionality built into these windows or the controller?
}

