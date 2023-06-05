import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class WebScraper3 {
     
    // TO-DO: MAKE BASED ON USER INPUT
    public static String keyword = "";
    public static String foodDataPageURL = "https://www.mynetdiary.com/foodSearch.do";

    public static void getNutritionData() throws IOException{
        Document doc2 = Jsoup.connect(foodDataPageURL).get(); // gonna have to find different website, or fetch all data
        // Element element2 = doc2.select("h2").first();
        // System.out.println("The calories in a " + keyword + " is " + element2.text()); // calories
        // System.out.println();

        System.out.println(foodDataPageURL);

        // Elements elements2 = doc2.getAllElements().getClass();
        
        // System.out.println(doc2.select("div[input]").first().attr("class"));

        // Elements elements2 = doc2.getElementsByTag("input");//.attr("value", "apple");

        // Element element = doc2.select("input").first();
        // System.out.println(element.className());


        // for(Element element: elements2){
        //     // element.attr("value", "apple");
        //     System.out.println(element);
        // }

        // int j = 0;
        // for(Element element: elements2){
        //     if(j == 0 || j == 3){
        //         System.out.println(element.text());
        //     }
        //     j++;
        // }
    }
}