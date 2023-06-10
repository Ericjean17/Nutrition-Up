import java.awt.Font;
import javax.swing.*;

public class WindowConstructor extends JFrame {

    private JLabel label;
    private JButton button;
    private JTextField textField;

    // Constructor method for all of the windows
    public WindowConstructor() {
        
        // Sets the title of the all of the windows
        setTitle("Nutrition Up");

        // Exits out of application when pressing the 'x' button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        // Prevents the window from being resized by the user
        setResizable(true); 

        // Sets the x-dimensions, and y-dimensions of all of the windows
        setSize(1100, 680);

        // Centers all of the windows to the middle of the screen
        setLocationRelativeTo(null);

        // Set layout manager to null for custom component placement
        setLayout(null);

        // Changes the image at the top left of the window from the java cup logo to our logo
        ImageIcon logo = new ImageIcon("NutritionUpLogo.png"); 
        setIconImage(logo.getImage());

        // Changes the backgrund of all of the windows to a png image
        setContentPane(new JLabel(new ImageIcon(("NutritionUpBackground.png"))));

        // Initializes labels, buttons, and TextFields for all windows
        label = new JLabel();
        button = new JButton();
        textField = new JTextField(10);

        // Makes all the windows INITIALLY visible (we can use dispose() to close them)
        setVisible(true);
    }

    
    /** 
     * @param label Changes the font of the label to Helvetica and size of the label to 50
     */
    public void header1(JLabel label){
        label.setFont(new Font("Helvetica", Font.BOLD,50));
    }

    /** 
     * @param label Changes the font of the label to Helvetica and size of the label to 30
     */
    public void header2(JLabel label){
        label.setFont(new Font("Helvetica", Font.BOLD,30));
    }

    /** 
     * @param label Changes the font of the label to Helvetica and size of the label to 20
     */
    public void header3(JLabel label){
        label.setFont(new Font("Helvetica", Font.BOLD,20));
    }
    
    /** 
     * @param label Changes the font of the label to Helvetica and size of the label to 17
     */
    public void header4(JLabel label){
        label.setFont(new Font("Helvetica", Font.BOLD,17));
    }

    /** 
     * @param label Changes the font of the button to Helvetica and size of the button to 15
     */
    public void header5(JButton button){
        button.setFont(new Font("Helvetica", Font.BOLD,15));
    }

    /** 
     * @param label Changes the font of the button to Helvetica and size of the button to 13
     */
    public void header6(JButton button){
        button.setFont(new Font("Helvetica", Font.BOLD,13));
    }
}
