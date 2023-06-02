import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class WebScraper {
     
    // TO-DO: MAKE BASED ON USER INPUT
    public static String keyword = "";
    public static String foodDataPageURL = "";
    
    public WebScraper(){

    }

    public static void setFoodDataPageURL() throws IOException{
        String foodSearchPageURL = "https://www.calorieking.com/us/en/foods/search?keywords=" + keyword;
        
        Document doc = Jsoup.connect(foodSearchPageURL).get(); // TO-DO: RENAME VARIABLES
        Elements elements = doc.select("a"); // TO-DO: RENAME VARIABLES
        
        String foodDataPageURL = "";

        int i = 0;
        for(Element element: elements){
            if(i == 11){
                foodDataPageURL = "https://www.calorieking.com" + element.attr("href");
                System.out.println(foodDataPageURL); // TO-DO: REMOVE (ONLY FOR TESTING)
                WebScraper.foodDataPageURL = foodDataPageURL;
            }
            i++;
        }
    }

    public static void getNutritionData() throws IOException{
        Document doc2 = Jsoup.connect(foodDataPageURL).get();
        Element element2 = doc2.select("h2").first();
        System.out.println("The calories in a " + keyword + " is " + element2.text()); // calories
        System.out.println();

        Elements elements2 = doc2.getElementsByTag("td");
        int j = 0;
        for(Element element: elements2){
            if(j == 0 || j == 3){
                System.out.println(element.text());
            }
            j++;
        }
    }
}