package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Gadgets {

	@Id
	@GeneratedValue
	private int id;
	private String brand;
	@JsonProperty("Desp")
	private String description;
	private int price;
	private int rating;
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Gadgets [id=" + id + ", brand=" + brand + ", description=" + description + ", price=" + price
				+ ", rating=" + rating + "]";
	}

	
	
	
}
