import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class WebScraperTesting {
    public static void main(String[] args){
        try {
            Document doc = Jsoup.connect("https://www.calorieking.com/us/en/foods/search?keywords=big+mac").get();

            String title = doc.title();
            System.out.println("Title: " + title);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}