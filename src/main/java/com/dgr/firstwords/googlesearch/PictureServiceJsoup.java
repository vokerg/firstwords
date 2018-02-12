package com.dgr.firstwords.googlesearch;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import com.dgr.firstwords.service.PictureService;

@Component
public class PictureServiceJsoup implements PictureService{

	@Override
	public String retrievePictureUrl(String name) {
		 String googleUrl = "https://www.google.com/search?tbm=isch&q=" + name.replace(",", "");
	     Document doc1 = null;
	     String finUrl = null;
		try {
			doc1 = Jsoup.connect(googleUrl).userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36").timeout(10 * 1000).get();
		     Element media = doc1.select("[data-src]").first();
		     finUrl = media.attr("abs:data-src");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return finUrl; 
	}

}
