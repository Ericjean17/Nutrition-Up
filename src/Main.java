public class Main {
    public static void main(String[] args) throws Exception {
        // Creates the window
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.createLoginWindow();
        //System.out.println(loginWindow.getUsername());
        Validate validate = new Validate();
        validate.validateUsername("Samuel");
        validate.validateGender("m");
        validate.validateAge("17");
        validate.validateWeight("120");
        validate.validateHeight("65");
        validate.validateCalorieGoal("3000");
        validate.validateFoodName("Big Mac");
    }
}
