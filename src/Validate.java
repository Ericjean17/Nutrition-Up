public class Validate {
    public static String username;
    public static String gender;
    public static String age;
    public static String weight;
    public static String height;
    public static String calorieGoal;
    public static String foodName;
    // method to check if input is a String that contains alphabetical letters
    public static boolean isString(String input){
        return input != null && !input.isEmpty() && input.matches("^[a-zA-Z\\s]*$");
    }
    // method to check if input is a String that contains numbers
    public boolean isInt(String input){
        return input!= null && !input.isEmpty() && input.matches("^-?\\d+$");
    }

    // IMPLEMENT THESE METHODS WITH THE OTHER CLASSES
    // ie. validateUsername --> if the username is invalid, shouldn't be able to advance to next window

    // method to validate username
    public static boolean validateUsername(){
        if(isString(username)){
            if(username.length() <= 15){
                System.out.println("Valid username: " + username);
                return true;
            }
            else{
                System.out.println("Invalid username. Username cannot exceed 15 characters");
                return false;
            }
        }
        else {
            System.out.println("Invalid username. Please Try Again!");
            return false;
        }
    }
    // method to validate gender
    public void validateGender(String inputtedGender){
        if(inputtedGender.equals("m") || inputtedGender.equals("f")){
            System.out.println("Valid Gender: " + inputtedGender);
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
    // method to validate weight
    public void validateWeight(String inputtedWeight){
        if (isInt(inputtedWeight)){
            if(Integer.parseInt(inputtedWeight)>=2 && Integer.parseInt(inputtedWeight)<=500){
                System.out.println("Valid Weight: " + inputtedWeight);
            }
            else{
                System.out.println("Invalid Weight! Please input a weight from '2-500'");
            }
        }
        else{
            System.out.println("Invalid Weight! Please Try Again.");
        }
    }
    // method to validate height
    public void validateHeight(String inputtedHeight){
        if (isInt(inputtedHeight)){
            if(Integer.parseInt(inputtedHeight)>=1 && Integer.parseInt(inputtedHeight)<=215){
                System.out.println("Valid Height: " + inputtedHeight);
            }
            else{
                System.out.println("Invalid Height! Please input a height from '1-215'");
            }
        }
        else{
            System.out.println("Invalid Height! Please Try Again.");
        }
    }
    // method to validate calorie goal
    public void validateCalorieGoal(String inputtedCalorieGoal){
        if (isInt(inputtedCalorieGoal)){
            if(Integer.parseInt(inputtedCalorieGoal)>=1500 && Integer.parseInt(inputtedCalorieGoal)<=10000){
                System.out.println("Valid Calorie Goal: " + inputtedCalorieGoal);
            }
            else{
                System.out.println("Invalid Calorie Goal! Please input a Calorie Goal from '1500-10000'");
            }
        }
        else{
            System.out.println("Invalid Calorie Goal! Please Try Again.");
        }
    }
    // method to validate food name
    public void validateFoodName(String inputtedFoodName){
        if(isString(inputtedFoodName)){
            if(inputtedFoodName.length() <= 20){
                System.out.println("Valid Food Name: " + inputtedFoodName);
            }
            else{
                System.out.println("Invalid food name. Food name cannot exceed 20 characters");
            }
        }
        else {
            System.out.println("Invalid food name. Please Try Again!");
        }
    }
}