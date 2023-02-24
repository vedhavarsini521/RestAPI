package com.example.demo.Day1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorGame {
	private String yourFavColor="Black";
	
	@RequestMapping("/color")
	public String getMyFav() {
		return "Your favorite color is "+yourFavColor+"!!!";
	}
}