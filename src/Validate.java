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
    public static boolean isInt(String input){
        return input!= null && !input.isEmpty() && input.matches("^-?\\d+$");
    }

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
    // method to validate age
    public static boolean validateAge(){
        if (isInt(age)){
            if(Integer.parseInt(age)>=0 && Integer.parseInt(age)<=100){
                System.out.println("Valid Age: " + age);
                return true;
            }
            else{
                System.out.println("Invalid Age! Please input an age from '0-100'");
                return false;
            }
        }
        else{
            System.out.println("Invalid Age! Please Try Again.");
            return false;
        }
    }
    // method to validate weight
    public static boolean validateWeight(){
        if (isInt(weight)){
            if(Integer.parseInt(weight)>=2 && Integer.parseInt(weight)<=500){
                System.out.println("Valid Weight: " + weight);
                return true;
            }
            else{
                System.out.println("Invalid Weight! Please input a weight from '2-500'");
                return false;
            }
        }
        else{
            System.out.println("Invalid Weight! Please Try Again.");
            return false;
        }
    }
    // method to validate height
    public static boolean validateHeight(){
        if (isInt(height)){
            if(Integer.parseInt(height)>=1 && Integer.parseInt(height)<=215){
                System.out.println("Valid Height: " + height);
                return true;
            }
            else{
                System.out.println("Invalid Height! Please input a height from '1-215'");
                return false;
            }
        }
        else{
            System.out.println("Invalid Height! Please Try Again.");
            return false;
        }
    }
    // method to validate calorie goal
    public static boolean validateCalorieGoal(){
        if (isInt(calorieGoal)){
            if(Integer.parseInt(calorieGoal)>=1500 && Integer.parseInt(calorieGoal)<=10000){
                System.out.println("Valid Calorie Goal: " + calorieGoal);
                return true;
            }
            else{
                System.out.println("Invalid Calorie Goal! Please input a Calorie Goal from '1500-10000'");
                return false;
            }
        }
        else{
            System.out.println("Invalid Calorie Goal! Please Try Again.");
            return false;
        }
    }
    // method to validate food name
    public static boolean validateFoodName(){
        if(isString(foodName)){
            if(foodName.length() <= 20){
                System.out.println("Valid Food Name: " + foodName);
                return true;
            }
            else{
                System.out.println("Invalid food name. Food name cannot exceed 20 characters");
                return false;
            }
        }
        else {
            System.out.println("Invalid food name. Please Try Again!");
            return false;
        }
    }
}