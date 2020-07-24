package com.bala.corejava.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.bala.corejava.common.Utils;
import com.bala.corejava.lamdaexp.beans.Product;

public class StreamTest {

	List<Product> productList = genarateTestData();
	
	public static void main(String[] args) {
		
		StreamTest streamTest = new StreamTest();
		
		streamTest.filterProduct(300);
		
		streamTest.filterPriceofProduct(500.0f);
		
		streamTest.calculateSumOfPrice();
		
		streamTest.convertIntoMap();

	}
	private void filterPriceofProduct(double price) {
		
		/*
		 * Using streams filter data and collect it and putting in another list
		 */
		
		Utils.printLineSeperator();
		System.out.println("Display orginal values");
		productList.forEach(p -> p.description());
		
		
		List<Double> filterProducts = productList.stream().filter(product -> product.getPrice() > price)
				 .map(product -> product.getPrice())
				.collect(Collectors.toList());

		Utils.printLineSeperator();
		
		System.out.printf("Filter the price %s greater than products and get only price in the list", price);
		
		filterProducts.forEach(p -> System.out.println("Price :: "+ p));
		
	}
	public void filterProduct(double price) {
		/*
		 * Using streams filter data and collect it and putting in another list
		 */
		List<Product> filterProducts = productList.stream().filter(product -> product.getPrice() > price)
				.collect(Collectors.toList());

		Utils.printLineSeperator();

		System.out.printf("Filter the price %s greater than products ", price);
		filterProducts.stream().forEach(p -> p.description());
	}
	public List<Product> genarateTestData() {
		
		Utils.printLineSeperator();
		
		Product p1 = new Product("Samsung j7");
		Product p2 = new Product("Samsung j1");
		Product p3 = new Product("iPhone j7");
		Product p4 = new Product("iPad j7");

		List<Product> productList = new ArrayList<Product>();
		productList.add(p1);
		productList.add(p2);
		productList.add(p3);
		productList.add(p4);

		Utils.printLineSeperator();
		productList.stream().forEach(p -> p.description());
		
		return productList;
	}
	public void calculateSumOfPrice() {
		
		Utils.printLineSeperator();
		
		
		Double totalPrice = productList.stream().map(p -> p.getPrice()).reduce(0.0, (sum, price)-> sum+price);
		
		
		System.out.println(totalPrice);  
		
		System.out.println("-------- Aggregation function ------");
		
		// More precise code   
        double totalPrice2 = productList.stream()  
                .map(product->product.getPrice())  
                .reduce((double) 0.0f,Double::sum);   // accumulating price, by referring method of Float class  
        System.out.printf("Double::sum :: Sum of all the product price List: %.2f", totalPrice2);  
		
        
     // More precise code   
        double maxPrice = productList.stream()  
                .map(product->product.getPrice())  
                .reduce((double) 0.0f,Double::max);   // accumulating price, by referring method of Float class  
        System.out.printf("\nDouble::max :: Maximum product price:: %.2f", maxPrice); 
        
     // More precise code   
        Optional<Double> minPrice = productList.stream()  
                .map(product->product.getPrice())  
                .reduce(Double::min);   // accumulating price, by referring method of Float class  
        System.out.printf("\nDouble::min :: Minim product price:: %.2f", minPrice.get().doubleValue()); 
        
        
        double totalPrice3 = productList.stream().collect(Collectors.summingDouble(p->p.getPrice()));
        System.out.printf("\n Using Collectors calculating summ:: %.2f", totalPrice3);
        
        
	}
	public void convertIntoMap() {
		Utils.printLineSeperator();
		
		Map<Integer, String> toMapProduct = productList.stream().collect(Collectors.toMap(Product::getId, Product::getName));
		toMapProduct.entrySet().stream().forEach(p -> System.out.printf("\n Id:: %d product:: %s", p.getKey(), p.getValue() ));
		
	}

}
