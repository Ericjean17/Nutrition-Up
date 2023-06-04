import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class WebScraper2 {
     
    // TO-DO: MAKE BASED ON USER INPUT
    public static String keyword = "";
    public static String foodDataPageURL = "";
    
    public WebScraper2(){

    }

    public static void setFoodDataPageURL() throws IOException{
        String foodSearchPageURL = "https://www.nutritionvalue.org/search.php?food_query=" + keyword;
        
        Document doc = Jsoup.connect(foodSearchPageURL).get(); // TO-DO: RENAME VARIABLES
        Element element = doc.select("a[title]").first(); // TO-DO: RENAME VARIABLES
        String end = element.attr("href");

        foodDataPageURL = "https://www.nutritionvalue.org" + end;
        System.out.println(foodDataPageURL);
    }

    public static void getNutritionData() throws IOException{
        System.out.println(foodDataPageURL);

        Document doc2 = Jsoup.connect("foodDataPageURL").get(); // gonna have to find different website, or fetch all data
        // Element element2 = doc2.select("h2").first();
        // System.out.println("The calories in a " + keyword + " is " + element2.text()); // calories
        // System.out.println();

        Elements elements2 = doc2.getElementsByTag("td");

        for(Element element: elements2){
            System.out.println(element);
        }

        int j = 0;
        for(Element element: elements2){
            if(j == 0 || j == 3){
                System.out.println(element.text());
            }
            j++;
        }
    }
}