import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//import org.jsoup.*; (maybe imports all of jsoup classes)
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

        String fullUrl = start + trueUrl;
        System.out.println(fullUrl);
        System.out.println();

        Document doc2 = Jsoup.connect(fullUrl).get();
        Element element2 = doc2.select("h2").first();
        System.out.println(element2.text()); // calories
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