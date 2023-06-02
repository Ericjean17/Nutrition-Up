public class Validate {
    public boolean isString(String input){
        return input != null && !input.isEmpty() && input.matches("^[a-zA-Z]*$");
    }

    public boolean isInt(String input){
        return input!= null && !input.isEmpty() && input.matches("^-?\\d+$");
    }

    // IMPLEMENT THESE METHODS WITH THE OTHER CLASSES
    // ie. validateUsername --> if the username is invalid, shouldn't be able to advance to next window

    // method to validate username
    public void validateUsername(String inputtedUsername){
        if(isString(inputtedUsername)){
            if(inputtedUsername.length() <= 15){
                System.out.println("Valid username: " + inputtedUsername);
            }
            else{
                System.out.println("Invalid username. Username cannot exceed 15 characters");
            }
        }
        else {
            System.out.println("Invalid username. Please Try Again!");
        }
    }
    // method to validate gender
    public void validateGender(String inputtedGender){
        if(inputtedGender.equals("m") || inputtedGender.equals("f")){
            System.out.println("Valid Gender");
        }
        else{
            System.out.println("Invalid Gender! Please input 'm' or 'f'");
        }
    }
    // method to validate age
    public void validateAge(String inputtedAge){
        if (isInt(inputtedAge)){
            if(Integer.parseInt(inputtedAge)>=0 && Integer.parseInt(inputtedAge)<=100){
                System.out.println("Valid Age: " + inputtedAge);
            }
            else{
                System.out.println("Invalid Age! Please input an age from '0-100'");
            }
        }
        else{
            System.out.println("Invalid Age! Please Try Again.");
        }
    }
}