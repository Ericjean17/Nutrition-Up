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
    // check if it is alphabetical and if it is less than or equal to 15 characters
    public static boolean validateUsername(){
        if(isString(username)){
            if(username.length() <= 15){
                return true;
            }
            else{
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    // method to validate age
    // check if it is a number and if it is between 1 and 100
    public static boolean validateAge(){
        if (isInt(age)){
            if(Integer.parseInt(age)>=0 && Integer.parseInt(age)<=100){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    // method to validate weight
    // check if it is a number and if it is between 2 and 500
    public static boolean validateWeight(){
        if (isInt(weight)){
            if(Integer.parseInt(weight)>=2 && Integer.parseInt(weight)<=500){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    // method to validate height
    // check if it is a number and if it is between 1 and 215
    public static boolean validateHeight(){
        if (isInt(height)){
            if(Integer.parseInt(height)>=1 && Integer.parseInt(height)<=215){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    // method to validate calorie goal
    // check if it is a number and if it is between 1500 and 10000
    public static boolean validateCalorieGoal(){
        if (isInt(calorieGoal)){
            if(Integer.parseInt(calorieGoal)>=1500 && Integer.parseInt(calorieGoal)<=10000){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    
    // method to validate food name
    // check if it is alphabetical and if it is less than or equal to 20
    public static boolean validateFoodName(){
        if(isString(foodName)){
            if(foodName.length() <= 20){
                return true;
            }
            else{
                return false;
            }
        }
        else {
            return false;
        }
    }
}