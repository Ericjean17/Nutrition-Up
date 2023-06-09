import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class WebScraper {
    
    public static String food;
    public static String keyword;
    public static String foodSearchPageURL;
    public static String foodDataPageURL;
    public static Boolean validInput;
    public static String foodCalories;
    public static String foodFat;
    public static String foodProtein;

    // Constructor method to set initial values
    public WebScraper(){
        food = "";
        keyword = "";
        foodSearchPageURL = "";
        foodDataPageURL = "";
        validInput = false;
    }

    /**
     * Replaces spaces in user input
     * 
     * MyFitnessPal search pages replace spaces with the characters "%20"
     * This method formats the keyword as it is in the URL 
     */
    public static void addKeywordDelimiters(){
        String temp = "";

        // Loop through every character in the String, replaces spaces
        for(int i = 0; i < food.length(); i++){
            if(String.valueOf(food.charAt(i)).equals(" ")){
                temp = temp + "%20";
            }
            else{
                temp = temp + String.valueOf(food.charAt(i));
            }
        }

        keyword = temp;
    }

    /**
     * Scrapes the food data page URL
     * 
     * Scrapes the MyFitnessPal food search page, then finds the URL for the food data page
     * @throws IOException
     */
    public static void setFoodDataPageURL() throws IOException{
        foodSearchPageURL = "https://www.myfitnesspal.com/nutrition-facts-calories/" + keyword;
        
        // If the try block fails (due to the inputted food not being found on the website),
        // validInput will remain false, preventing the program from continuing
        try {
            validInput = false;
            
            Document doc2 = Jsoup.connect(foodSearchPageURL).get();
            System.out.println(foodSearchPageURL); // TO-DO: remove when done

            Elements elements = doc2.getElementsByAttributeValue("class", "MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineNone css-1k8z5lp");
            
            elements.remove(0);

            foodDataPageURL = "https://www.myfitnesspal.com" + elements.first().attr("href");        
            System.out.println(foodDataPageURL); // TO-DO: remove when done
            
            validInput = true;
        } 
        catch (Exception e) {
            
        }        
    }

    /**
     * Scrapes the amount of calories in the food
     * 
     * @throws IOException
     */
    public static void getCalorieData() throws IOException{
        Document doc = Jsoup.connect(foodDataPageURL).get();

        Element element = doc.getElementsByAttributeValue("class", "MuiTypography-root MuiTypography-body1 css-ezyk0s").first();
        
        foodCalories = element.text();
    }

    /**
     * Scrapes the amount of fat in the food
     * 
     * @throws IOException
     */
    public static void getFatData() throws IOException{
        Document doc = Jsoup.connect(foodDataPageURL).get();

        Elements elements = doc.getElementsByAttributeValue("class", "MuiTypography-root MuiTypography-Heading/Bold/MD css-elwe1n");

        elements.remove(0);

        foodFat = elements.first().text();
    }

    /**
     * Scrapes the amount of protein in the food
     * 
     * @throws IOException
     */
    public static void getProteinData() throws IOException{
        Document doc = Jsoup.connect(foodDataPageURL).get();

        Elements elements = doc.getElementsByAttributeValue("class", "MuiTypography-root MuiTypography-Heading/Bold/MD css-elwe1n");

        elements.remove(0);
        elements.remove(0);
        
        foodProtein = elements.first().text();
    }

    public static void writeData() throws IOException{ // TO-DO: rename method, javadoc
    
        // TO-DO: check if food already exists (make into separate method)

        try { 
            PrintWriter writer = new PrintWriter(new FileWriter("FooData.csv", true));
            writer.println(food + "/" + foodCalories + "/" + foodFat + "/" + foodProtein);
            writer.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    // TO-DO: ADD COMMENTS & RENAME VARIABLES
}