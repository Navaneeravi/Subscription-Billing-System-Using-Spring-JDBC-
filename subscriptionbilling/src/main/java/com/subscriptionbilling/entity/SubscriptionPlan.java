package com.subscriptionbilling.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;

public class SubscriptionPlan {
    private int id;
    
    @NotNull
    @NotEmpty
    private String name;
    private double price;
    private String description;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

    
}
