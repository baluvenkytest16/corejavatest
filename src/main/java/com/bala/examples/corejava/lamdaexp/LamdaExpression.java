package com.bala.examples.corejava.lamdaexp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import com.bala.corejava.lamdaexp.beans.Product;
import com.bala.examples.corejava.common.Utils;

/*
 * Lamda expression
 * 1. Create the interface and interface should have only one method
 * 2. Create the method definition in interface
 * 3. assign 
 * 
 * 
 * */
interface Summation {
	public long addNumbers(long x, long y);

}

interface addOnPlus5 {
	public long addValueOnPlus5(long x);
}



public class LamdaExpression {

	List<Product> productList = genarateTestData();
	
	//static LineSeparator lineSpe = () -> System.out.println("\n--------- ****************** ----------\n");

	public void printValue(String value) {
		System.out.println("output value : " + value);
	}

	public static void main(String[] args) {

		LamdaExpression lamdaTest = new LamdaExpression();
		
		/*
		 * Add the implementation for inteface methods.
		 */

		/*
		 * lamda function without param
		 */

		

		/*
		 * Lamda function with 2 params
		 */

		Summation sum = (x, y) -> (x + y);

		/*
		 * Add the implementation for inteface methods.
		 */

		addOnPlus5 addPlus5 = (x) -> x + 5;

		/*
		 * Print values method
		 */
		lamdaTest.printValue("Summation using lamda :: " + sum.addNumbers(10, sum.addNumbers(10, 20)));

		

		lamdaTest.printValue("Add on5 method ::" + addPlus5.addValueOnPlus5(100));


		lamdaTest.testListIterator();

		
		//lamdaTest.testNormalThreads();

		
		//lamdaTest.testLamdaThread();


		lamdaTest.testComparator();
		
		lamdaTest.testFilterList("Samsung");
		lamdaTest.testFilterList("iphone");

	}

	private void testFilterList(String filterText) {
		Utils.printLineSeperator();
		Stream<Product> filterData = productList.stream().filter((product) -> product.getName().toLowerCase().contains(filterText.toLowerCase()));
		
		filterData.forEach(product -> product.description());
	}

	private void testListIterator() {
		
		Utils.printLineSeperator();
		
		List<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		list.add("test4");

		list.forEach((item) -> System.out.println("List Item : " + item));
	}

	public void testNormalThreads() {
		Utils.printLineSeperator();
		/*
		 * Thread creating without lamda
		 */
		System.out.println("Running without lamda:: ");
		Runnable noLamda = new Runnable() {

			@Override
			public void run() {
				productList.forEach((product) -> product.description());
			}
		};
		Thread t1 = new Thread(noLamda);
		t1.start();

	}

	public void testLamdaThread() {
		Utils.printLineSeperator();
		/*
		 * Thread creating with lamda
		 */
		System.out.println("With Lamda calling: ");
		Thread t2 = new Thread(() -> {
			productList.forEach((product) -> {
				product.description();
			});
		});
		t2.start();
	}

	public void testComparator() {
		Utils.printLineSeperator();
		Collections.sort(productList, (p1, p2) -> {
			return p1.getName().toLowerCase().compareTo(p2.getName().toLowerCase());
		});

		productList.forEach(product -> product.description());
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

		return productList;
	}
}
