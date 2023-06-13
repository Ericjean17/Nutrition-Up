public class CalorieCalculator {
    public static double CalorieResult = 0;
    

    public static void RecCalorie(){
        String username = UserInfo.username;  // Replace with the desired username
        
        
        if (UserInfo.isUsernameExists(username)) {
            // Username exists, perform login action
            UserInfo.retrieveUserInfo(username);
            UserInfo.displayInformation();
            
            double weightKg = UserInfo.weight;
            int hoursPerDay = 24;
            double bodyFatPercentage = 0;
           // double genderFactor = UserInfo.gender.equalsIgnoreCase(UserInfo.gender) ? 1.0 : 0.9;
            String genderM = UserInfo.gender;
            int ageM = UserInfo.age;
            double genderFactor = 0;
            
            
            if (genderM.equals("female")){
               genderFactor =  genderFactor + 0.9;
               if (2 <= ageM && ageM <= 18){
                bodyFatPercentage = bodyFatPercentage + 1.0;
               }
               else if (19 <= ageM && ageM <= 28){
                bodyFatPercentage = bodyFatPercentage + 0.95;
               }
               else if (29 <= ageM && ageM <= 38){
                bodyFatPercentage = bodyFatPercentage + 0.90;
               }
               else if (ageM > 38){
                bodyFatPercentage = bodyFatPercentage + 0.85;
               }

               }
        
            if (genderM.equals("male")){
                genderFactor = 1.0;
                if (2 <= ageM && ageM <= 14){
                    bodyFatPercentage = bodyFatPercentage + 1.0;
                   }
                   else if (15 <= ageM && ageM <= 20){
                    bodyFatPercentage = bodyFatPercentage + 0.95;
                   }
                   else if (21 <= ageM && ageM <= 28){
                    bodyFatPercentage = bodyFatPercentage + 0.90;
                   }
                   else if (ageM > 28){
                    bodyFatPercentage = bodyFatPercentage + 0.85;
                   }
            }
        
            
            // Calculate the result
            CalorieResult = weightKg * genderFactor * hoursPerDay * bodyFatPercentage;
            
    
            
            // Append the calories to the same line in the UserInfo.csv file
            UserInfo.appendCaloriesToUserInfo(username, CalorieResult);
        } 
        else {
            System.out.println("Username does not exist.");
        }
    }
}