package by;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.lang3.ObjectUtils;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class app {
    public static void main(String[] args){
        System.err.close();
        System.setErr(System.out);
        List<kino> pokaz = new ArrayList<kino>();
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        try {
            String searchUrl = "https://afisha.tut.by/film-mogilev/";
            HtmlPage page = client.getPage(searchUrl);
            List<HtmlElement> items = (List<HtmlElement>) page.getByXPath("//*[@id='events-block']/ul[@class='b-lists list_afisha col-5']/li[@class='lists__li ']" );
            if(items.isEmpty()){
                System.out.println("No items found !");
            }else {
                for (HtmlElement item : items) {
                    /*kino aa = new kino();*/
                    HtmlElement pic = (HtmlElement) item.getHtmlElementsByTagName("img").get(0);
                    String picsrc = pic.getAttribute("src");
                    String name = pic.getAttribute("alt");

                    HtmlElement rate = (HtmlElement) item.getHtmlElementsByTagName("span").get(1);
                    String rating = rate.asText().replace(",",".");
                    double rat;
                    try {
                        rat = Double.parseDouble(rating);

                    } catch (NumberFormatException e){
                       rat = 0;
                    }
                    HtmlAnchor itemAnchor = (HtmlAnchor) item.getFirstByXPath(".//a[@class='media']");
                    HtmlPage movie_page = client.getPage(itemAnchor.getHrefAttribute());

                    HtmlElement age = (HtmlElement) movie_page.getByXPath(".//td[@class='post b-event-post']/div[@class='sub_title m-margin-bottom tag-place']").get(0);
                    System.out.println(age.asText());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
