package com.kali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.kali.response.Product;
import com.kali.service.ProductService;

@Controller
public class ProductsController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/")
	public String index(@ModelAttribute("p") Product p, Model model) {
		//service.getQuotations();
		return "index";
	}
	
	@GetMapping("/product")
	public String getProduct(@RequestParam("pid") String pid, Model model) {
		Product product = service.getProduct(pid);
		model.addAttribute("p",product);
		return "index";
	}
    
}
