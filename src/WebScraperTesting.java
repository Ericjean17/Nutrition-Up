import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class WebScraperTesting {
    public static void main(String[] args) throws IOException{

        String start = "https://www.calorieking.com";
        String mid = "/us/en/foods/search?keywords=";
        String keyword = "apple"; // will be made based on user input
        String url = start + mid + keyword;

        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select("a");
        
        String trueUrl = "";
        int i = 0;
        for(Element element: elements){
            if(i == 11){
                trueUrl = element.attr("href");
                System.out.println(trueUrl);
            }
            i++;
        }

        System.out.println(start + trueUrl);
    }
}