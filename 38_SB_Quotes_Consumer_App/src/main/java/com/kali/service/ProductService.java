package com.kali.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kali.response.Product;

@Service
public class ProductService {

	public void getQuotations() {
		//String apiUrl= "https://type.fit/api/quotes";
		String apiUrl= "https://api.restful-api.dev/objects";
		
		RestTemplate rt=new RestTemplate();
		               //url,  response
		//ResponseEntity<String> resEntity = rt.getForEntity(apiUrl, String.class);
		
		ResponseEntity<Product[]> resEntity = rt.getForEntity(apiUrl, Product[].class);
		
		int value = resEntity.getStatusCode().value();
		if(value==200) {
			//String body = resEntity.getBody();
			Product[] products = resEntity.getBody();
			
			for(Product p: products) {
				System.out.println(p);
			}
			
		}
	}
	
	public Product getProduct(String pid) {
		
		String apiUrl= "https://api.restful-api.dev/objects/"+pid;
		
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Product> resEntity = rt.getForEntity(apiUrl, Product.class);
		
		int status = resEntity.getStatusCode().value();
		if(status==200) {
			return resEntity.getBody();
		}
		return null;
		
	}
}
