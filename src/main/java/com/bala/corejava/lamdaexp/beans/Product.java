package com.bala.corejava.lamdaexp.beans;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Product {

	private static final AtomicInteger count = new AtomicInteger(0); 
	private int id;
	private String name;
	private double price;

	public Product(String name) {
		this.id = count.getAndIncrement();
		this.name = name;
		this.price = new Random().nextDouble()*1000;
	}
	public Product(String name, double price) {
		this.id = count.getAndIncrement();
		this.name = name;
		this.price = price;
	}

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
	
	public void description() {
		System.out.printf("\n Product Details : id: %d, Name: %s, Price: %.2f \n " , this.id, this.name, this.price);
	}

}
