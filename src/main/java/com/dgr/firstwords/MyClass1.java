package com.dgr.firstwords;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MyClass1 {

	public static void main(String[] args) {
		System.out.println(FindImage("кролик", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"));

	}
	
	public static String FindImage(String question, String ua) {
        String finRes = "";

try {
        String googleUrl = "https://www.google.com/search?tbm=isch&q=" + question.replace(",", "");
        Document doc1 = Jsoup.connect(googleUrl).userAgent(ua).timeout(10 * 1000).get();
        Element media = doc1.select("[data-src]").first();
        String finUrl = media.attr("abs:data-src"); 

        finRes= "<a href=\"http://images.google.com/search?tbm=isch&q=" + question + "\"><img src=\"" + finUrl.replace("&quot", "") + "\" border=1/></a>";

    } catch (Exception e) {
        System.out.println(e);
    }

    return finRes;
}

}
