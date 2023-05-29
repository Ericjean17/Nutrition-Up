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
    private JLabel clickLabel = new JLabel("# of clicks:  0");
    private JLabel applicationNameText = new JLabel("Nutrition Up!");
    private JLabel loginText = new JLabel("Login");
    private JLabel noAccountText = new JLabel("Don't have an account?");
    private JLabel usernameText = new JLabel("Enter your username");
    private JButton loginButton = new JButton("Login Button");
    private JTextField inputUsernameTextField = new JTextField(10);
    public JButton signUpButton = new JButton("Sign up");

    public void createLoginWindow() {

        loginButton.addActionListener(this);
        
        // Set the positions and sizes of the label, button, and TextField
        applicationNameText.setBounds(490, 55, 200, 30);
        loginButton.setBounds(455, 315, 150, 50);
        usernameText.setBounds(470,205,150,50);
        inputUsernameTextField.setBounds(435, 265, 230, 30);
        loginText.setBounds(505, 100, 100, 30);
        noAccountText.setBounds(475,570,200,30);
        clickLabel.setBounds(200, 100, 100, 30); // Delete later
        signUpButton.setBounds(480, 610, 100, 30);

        // Add the components to the window
        add(applicationNameText);
        add(loginButton);
        add(inputUsernameTextField);
        add(clickLabel);
        add(usernameText);
        add(loginText);
        add(noAccountText);
        add(signUpButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clicks++;
        clickLabel.setText("# of clicks:  " + clicks);
    }
}
