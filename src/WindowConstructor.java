import javax.swing.*;
import java.awt.*;

// Constuctor method for the windows
public class WindowConstructor extends JFrame {

    private JLabel label;
    private JButton button;
    private JTextField textField;

    public WindowConstructor() {
        setTitle("Nutrition Up"); // Sets the title of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits out of application
        setResizable(true); // Prevents the window from being resized
        setSize(1100, 680); // Sets the x-dimensions, and y-dimensions of all of the windows
        setLocationRelativeTo(null); // Centers all of the windows
        setLayout(null); // Set layout manager to null for custom component placement
        //setExtendedState(JFrame.MAXIMIZED_BOTH); This automatically sets the window to full screen, however we don't want that (alex has a chromebook)
        setUndecorated(false); // Adds the functionality of not closing the windowing without alt+f4 (we don't want that)
        
        ImageIcon logo = new ImageIcon("NutritionUpLogo.png"); // Changes the image at the top left of the window from the java cup logo to our logo
        setIconImage(logo.getImage());

        //setVisible(true); // If you put this before creating the label, button, and textField variable,
        // all the labels, buttons, and TextFields from the LoginWindow won't pop up unless you resize the window

        label = new JLabel();
        button = new JButton();
        textField = new JTextField(10);

        setVisible(true); // Makes all the windows INITIALLY visible (can use dispose() to close them)
    }

    // Don't know if we need this.
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
}
