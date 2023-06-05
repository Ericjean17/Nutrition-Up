import java.io.IOException;

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


    public WebScraper(){
        food = "";
        keyword = "";
        foodSearchPageURL = "";
        foodDataPageURL = "";
        validInput = false;
    }

    public static void addKeywordDelimiters(){
        String temp = "";
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

    public static void setFoodDataPageURL() throws IOException{
        foodSearchPageURL = "https://www.myfitnesspal.com/nutrition-facts-calories/" + keyword;
        
        try {
            validInput = false;
            
            Document doc2 = Jsoup.connect(foodSearchPageURL).get();
            System.out.println(foodSearchPageURL); // remove when done

            Elements elements = doc2.getElementsByAttributeValue("class", "MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineNone css-1k8z5lp");
            
            elements.remove(0);

            foodDataPageURL = "https://www.myfitnesspal.com" + elements.first().attr("href");        
            System.out.println(foodDataPageURL); // remove when done
            
            validInput = true;
        } 
        catch (Exception e) {
            
        }        
    }

    public static void getCalorieData() throws IOException{
        Document doc = Jsoup.connect(foodDataPageURL).get();

        Element element = doc.getElementsByAttributeValue("class", "MuiTypography-root MuiTypography-body1 css-ezyk0s").first();
        System.out.println("Calories: " + element.text());
    }

    public static void getFatData() throws IOException{
        Document doc = Jsoup.connect(foodDataPageURL).get();

        Elements elements = doc.getElementsByAttributeValue("class", "MuiTypography-root MuiTypography-Heading/Bold/MD css-elwe1n");

        elements.remove(0);

        System.out.println("Fat: " + elements.first().text());
    }

    public static void getProteinData() throws IOException{
        Document doc = Jsoup.connect(foodDataPageURL).get();

        Elements elements = doc.getElementsByAttributeValue("class", "MuiTypography-root MuiTypography-Heading/Bold/MD css-elwe1n");

        elements.remove(0);
        elements.remove(0);
        
        System.out.println("Protein: " + elements.first().text());
    }

    // TO-DO: ADD COMMENTS & RENAME VARIABLES
}