package com.bala.examples.corejava.streams;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bala.corejava.lamdaexp.beans.Product;

import junit.framework.Assert;
import mockit.Injectable;
import mockit.Mock;
import mockit.Mocked;
import mockit.internal.expectations.mocking.MockedType;


class StreamExampleTest {
	
	List<Product> mockProductList = genarateTestData();
	
	
	StreamExample streamExample = new StreamExample();
	
	public static List<Product> genarateTestData() {

		Product p1 = new Product("Samsung j7", 100.0);
		Product p2 = new Product("Samsung j1", 2000);
		Product p3 = new Product("iPhone j7", 1000.0f);
		Product p4 = new Product("iPad j7", 300.0f);

		List<Product> productList = new ArrayList<Product>();
		productList.add(p1);
		productList.add(p2);
		productList.add(p3);
		productList.add(p4);

		productList.stream().forEach(p -> p.description());

		return productList;
	}
	@BeforeEach
	void setUp() throws Exception {
		mockProductList = genarateTestData();
	}

	@Test
	void testFilterProduct() {
		Product p = new Product("test", 300.0);
		mockProductList.add(new Product("test", 300.0));
		//List<Product> filteredList = streamExample.filterProduct(mockProductList, 300);
		
		
		
	}

	@Test
	void testGenarateTestData() {
		fail("Not yet implemented");
	}

	@Test
	void testCalculateSum() {
		fail("Not yet implemented");
	}

	@Test
	void testCalculateSum2() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMaximumValue() {
		assertEquals(streamExample.getMaximumValue(mockProductList), 2000.0f);
	}

	@Test
	void testGetMinimumValue() {
		assertEquals(streamExample.getMaximumValue(mockProductList), 100.0f);
	}

	@Test
	void testGetTotalValue() {
		fail("Not yet implemented");
	}

	@Test
	void testConvertIntoMap() {
		fail("Not yet implemented");
	}

}
