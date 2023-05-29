import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends WindowConstructor implements ActionListener {
    // Create the label, button, and TextField, and assign it to a variable

    private int clicks = 0;
    private JLabel clickLabel = new JLabel("Number of clicks:  0     ");
    private JLabel applicationNameText = new JLabel("Example Label");
    private JButton loginButton = new JButton("Click Me");
    private JTextField inputUsernameTextField = new JTextField(10);

    public void createLoginWindow() {

        loginButton.addActionListener(this);
        
        // Set the positions and sizes of the label, button, and TextField
        applicationNameText.setBounds(300, 200, 200, 30);
        loginButton.setBounds(50, 100, 100, 30);
        inputUsernameTextField.setBounds(50, 150, 150, 30);
        clickLabel.setBounds(200, 100, 100, 30);


        // Add the components to the window
        add(applicationNameText);
        add(loginButton);
        add(inputUsernameTextField);
        add(clickLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clicks++;
        clickLabel.setText("# of clicks:  " + clicks);
    }
}
