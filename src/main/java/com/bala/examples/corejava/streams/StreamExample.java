package com.bala.examples.corejava.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bala.corejava.lamdaexp.beans.Product;
import com.bala.examples.corejava.common.Utils;

public class StreamExample {

	private static final Logger logger = LoggerFactory.getLogger(StreamExample.class);

	public static void main(String[] args) {

		StreamExample streamExample = new StreamExample();
		
		List<String> stringList = Arrays.asList("How", "To", "Do", "In", "Java");
		
		logger.info("After Joining :: {}", streamExample.joinerString(stringList));

		streamExample.callStreamExamples();
		Integer[] someArray = {10, 20 ,30 ,10 ,30, 40, 30, 20};
		
		Set<Integer> mySet = new HashSet<Integer>(Arrays.asList(someArray));
		mySet.stream().forEach(value -> System.out.println("" + value));
	}

	public void callStreamExamples()
	{
		
		Utils.printLineSeperator();

		List<Product> productList = genarateTestData();

		logger.info("Displyaing the orginal produlist ::");

		productList.forEach(p -> p.description());

		Utils.printLineSeperator();

		List<Product> filteredList = this.filterProduct(productList, 300);

		logger.info("Filter list greater then 300::");
		filteredList.forEach(p -> p.description());

		Utils.printLineSeperator();

		List<Double> filtered500List = this.filterPriceofProduct(productList, 500.0f);

		filtered500List.forEach(p -> logger.debug("Price :: {}", p));

		Utils.printLineSeperator();

		logger.info("-------- Aggregation function ------");

		double sum = this.calculateSum(productList);

		logger.info("Sum of all the products price list:: {}", sum);

		// Utils.printLineSeperator();

		double sum2 = this.calculateSum2(productList);

		logger.info("Sum of all the products price list:: {}", sum2);

		Utils.printLineSeperator();

		double maxValue = this.getMaximumValue(productList);

		logger.info("Maximum price in the product list:: {}", maxValue);

		Utils.printLineSeperator();

		Optional<Double> minValue = this.getMinimumValue(productList);

		logger.info("Minimum price in the product list:: {}", minValue.get().doubleValue());

		Utils.printLineSeperator();

		double total = this.getTotalValue(productList);

		logger.info("Totle price of all the products:: {}", total);

		Utils.printLineSeperator();

		Map<Integer, String> convertedMap = this.convertIntoMap(productList);
		convertedMap.entrySet().stream().forEach(p -> logger.info(" Id:: {} product:: {}", p.getKey(), p.getValue()));

		Utils.printLineSeperator();
	}

	private String joinerString(List<String> stringList) {

		String delimeter = ", ";
		String prefix = "[";
		String suffix = "]";
		String joinedString = stringList.stream().collect(Collectors.joining(delimeter, prefix, suffix));

		logger.debug(joinedString);
		return joinedString;

	}

	private List<Double> filterPriceofProduct(List<Product> productList, double price) {

		/*
		 * Using streams filter data and collect it and putting in another list
		 */

		logger.debug("Filter the price {} greater than products and get only price in the list", price);

		List<Double> filterProducts = productList.stream().filter(product -> product.getPrice() > price)
				.map(product -> product.getPrice()).collect(Collectors.toList());

		return filterProducts;

	}

	public List<Product> filterProduct(List<Product> productList, double price) {
		/*
		 * Using streams filter data and collect it and putting in another list
		 */
		if (productList == null) return null;
		
		logger.debug("Filter the price {} greater than products ", price);

		List<Product> filterProducts = productList.stream().filter(product -> product.getPrice() >= price)
				.collect(Collectors.toList());

		return filterProducts;
	}

	public static List<Product> genarateTestData() {

		Product p1 = new Product("Samsung j7");
		Product p2 = new Product("Samsung j1");
		Product p3 = new Product("iPhone j7");
		Product p4 = new Product("iPad j7");

		List<Product> productList = new ArrayList<Product>();

		productList.add(p1);
		productList.add(p2);
		productList.add(p3);
		productList.add(p4);

		return productList;
	}

	public double calculateSum(List<Product> productList) 
	{
		if (productList == null) return 0.0;
		
		double totalPrice = productList.stream().map(p -> p.getPrice()).reduce(0.0, (sum, price) -> sum + price);

		logger.debug("totalPrice :: {}", totalPrice);

		return totalPrice;
	}

	public double calculateSum2(List<Product> productList) {
		
		if (productList == null) return 0.0;
		// More precise code
		double totalPrice = productList.stream().map(product -> product.getPrice()).reduce((double) 0.0f, Double::sum);
		// accumulating price, by referring method of Float class
		logger.debug("Double::sum :: Sum of all the product price List: {}", totalPrice);

		return totalPrice;
	}

	public double getMaximumValue(List<Product> productList) 
	{
		if (productList == null) return 0.0;
		// More precise code
		double maxPrice = productList.stream().map(product -> product.getPrice()).reduce((double) 0.0f, Double::max);
		// accumulating price, by referring method of Float class
		logger.debug("Double::max :: Maximum product price:: {}", maxPrice);
		return maxPrice;
	}

	public Optional<Double> getMinimumValue(List<Product> productList)
	{
		// More precise code
		if(productList == null) return null;
		
		Optional<Double> minPrice = productList.stream().map(product -> product.getPrice()).reduce(Double::min);
		// accumulating price, by referring method of Float class
		logger.debug("Double::min :: Minim product price:: {}", minPrice.get().doubleValue());
		return minPrice;
	}

	public double getTotalValue(List<Product> productList)
	{
		
		if (productList == null) return 0.0;
		
		double total = productList.stream().collect(Collectors.summingDouble(p -> p.getPrice()));
		logger.debug(" Using Collectors calculating summ:: {}", total);
		return total;
	}

	public Map<Integer, String> convertIntoMap(List<Product> productList) {

		Map<Integer, String> toMapProduct = productList.stream()
				.collect(Collectors.toMap(Product::getId, Product::getName));

		return toMapProduct;
	}

}
