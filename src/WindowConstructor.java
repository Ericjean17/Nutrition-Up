import java.awt.*;
import javax.swing.*;

// Constuctor method for the windows
public class WindowConstructor extends JFrame {

    private JLabel label;
    private JButton button;
    private JTextField textField;

    public WindowConstructor() {
        setTitle("Nutrition Up"); // Sets the title of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true); // prevent window from being resized
        setSize(1100, 680); // sets the x-dimensions, and y-dimension of the window
        setLocationRelativeTo(null); // Centers the window
        setLayout(null); // Set layout manager to null for custom component placement
        //setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(false);
        ImageIcon logo = new ImageIcon("NutritionUpLogo.png");
        setIconImage(logo.getImage());

        //setVisible(true); // If you put this before creating the label, button, and textField variable,
        // all the labels, buttons, and TextFields from the LoginWindow won't pop up unless you resize the window

        label = new JLabel();
        button = new JButton();
        textField = new JTextField(10);

        setVisible(true); // Make window visible // I think we should make the window visible in their respective classes
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public JButton getButton() {
        return button;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JTextField getTextField() {
        return textField;
    }

    /*
    // Still don't know how to set the windows to be visible or not visible when pressing a login, creating account or back button
    public void setVisibility(boolean visible){
        this.setVisible(visible);
    }
    */
}
