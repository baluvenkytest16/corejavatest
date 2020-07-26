package com.bala.corejava.lamdaexp.beans;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Product {

	private static Logger logger = LoggerFactory.getLogger(Product.class);
	private static final AtomicInteger count = new AtomicInteger(0); 
	private int id;
	private String name;
	private double price;

	public Product(String name) {
		this.id = count.getAndIncrement();
		this.name = name;
		this.price = Math.floor(new Random().nextDouble()*1000 * 100) / 100;;
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
	
	//Test equal, override equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
	public void description() {
		logger.info("Product Details : id: {}, Name: {}, Price: {}" , this.id, this.name, this.price);
	}

}
