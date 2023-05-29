import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

// Constuctor method for the windows
public class WindowConstructor extends JFrame {

    private JLabel label;
    private JButton button;
    private JTextField textField;

    public WindowConstructor() {
        setTitle("Nutrition Up"); // Sets the title of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        setResizable(true); // prevent frame from being resized
        //setSize(1000, 700); // sets the x-dimensions, and y-dimension of the window
        setLayout(null); // Set layout manager to null for custom component placement
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(false);

        label = new JLabel();
        button = new JButton();
        textField = new JTextField(10);

        setVisible(true); // Make window visible
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
}
