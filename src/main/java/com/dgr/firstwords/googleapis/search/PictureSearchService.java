package com.dgr.firstwords.googleapis.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dgr.firstwords.googleapis.search.model.Response;
import com.dgr.firstwords.service.PictureService;

//@Component
public class PictureSearchService //implements PictureService
{

	private static final String GOOGLE_PICTURE_SEARCH_URL = "https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=";

	//@Override
	public String retrievePictureUrl(String name) {
		RestTemplate restTemplate = new RestTemplate();
  	  	addJavascriptMediaTypeToJacksonConverter(restTemplate);
 
  	  	String url = null;
  	  	try {
  	  		Response data = restTemplate.getForObject(GOOGLE_PICTURE_SEARCH_URL + name, Response.class);
  	  		url = data.getResponseData().getResults()[0].getUnescapedUrl();
  	  	} catch (Exception e) {
  	  		
  	  	}
		return url;
	}

	private void addJavascriptMediaTypeToJacksonConverter(RestTemplate restTemplate) {
		for (HttpMessageConverter<?> myConverter : restTemplate.getMessageConverters ()) {
  		     if (myConverter instanceof MappingJackson2HttpMessageConverter) {
  		        List<MediaType> myMediaTypes = new ArrayList<MediaType> ();
  		        myMediaTypes.addAll (myConverter.getSupportedMediaTypes ());
  		        myMediaTypes.add (MediaType.parseMediaType ("text/javascript; charset=utf-8"));
  		        ((MappingJackson2HttpMessageConverter) myConverter).setSupportedMediaTypes (myMediaTypes);
  		     }
  		  }
	}

}
