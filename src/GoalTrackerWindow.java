import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class GoalTrackerWindow extends WindowConstructor {
    // Create the progress bar and assign it to a variable
    // Create the label, button, and TextField, and assign it to a variable

    public JProgressBar bar;

    public void createGoalTrackerWindow() {

        // Initialize action events for the buttons

        // Set the positions and sizes of the label, button, and TextField

        // Add the components to the window

        // SAMPLE CODE FOR THE PROGRESS BARS
        SwingUtilities.invokeLater(() -> {
            bar = new JProgressBar();
            bar.setValue(0);
            bar.setStringPainted(true);

            // Set the position and size of the progress bar
            bar.setBounds(300, 300, 420, 50);

            // Add the progress bar to the window
            add(bar);

            // Start the progress update in a separate thread
            new Thread(this::fill).start();
        });
    }

    // Method to simulate the progress of the bar
    public void fill() {
        int counter = 0;
        while (counter <= 100) {
            final int value = counter;
            SwingUtilities.invokeLater(() -> {
                bar.setValue(value);
                bar.setString("Your Progress: " + value + "%");
            });
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
        }
        // Update the text of the progress bar after the loop completes
        SwingUtilities.invokeLater(() -> {
            bar.setString("You reached your ____ goal! :)");
        });
    }
    /*
    // When pressing the buttons, it creates a new window
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnToFoodDiaryButton){
            dispose();
            FoodDiaryWindow foodDiaryWindow = new FoodDiaryWindow();
            foodDiaryWindow.createFoodDiaryWindow();
        }
    }
    */
}
