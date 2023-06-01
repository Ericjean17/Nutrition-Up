public class Validate {
    public boolean isString(String input){
        return input != null && !input.isEmpty() && input.matches("^[a-zA-Z]*$");
    }
    // look at how to implement this into the login window
    // because the program shouldn't be able to advance to next windows if username is invalid
    public void validateString(String inputtedUsername){
        if(isString(inputtedUsername)){
            System.out.println("Valid username: " + inputtedUsername);
        }
        else {
            System.out.println("Invalid username. Please Try Again!");
        }
    }
}
