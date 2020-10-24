package com.bala.examples.corejava.streams;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	List<Product> mockProductList;
	
	
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
		List<Product> filteredList = streamExample.filterProduct(mockProductList, 300);
		
		assertNull(streamExample.filterProduct(null, 0.0));
		assertNotNull(streamExample.filterProduct(mockProductList, 0.0));
		assertTrue(filteredList.size() > 0);
		assertTrue(filteredList.contains(p));
		
		
	}

	@Test
	void testGenarateTestData() {
		List<Product> productList = StreamExample.genarateTestData();
		assertNotNull(productList);
		assertTrue(productList.size() > 0);
	}

	@Test
	void testCalculateSum() {
		assertEquals(0.0, streamExample.getTotalValue(null));
		assertEquals(3400.0, streamExample.getTotalValue(mockProductList));
	}

	@Test
	void testCalculateSum2() {
		assertEquals(0.0, streamExample.getTotalValue(null));
		assertEquals(3400.0, streamExample.getTotalValue(mockProductList));
	}

	@Test
	void testGetMaximumValue() {
		assertEquals(streamExample.getMaximumValue(mockProductList), 2000.0f);
	}

	@Test
	void testGetMinimumValue() {
		assertEquals(streamExample.getMinimumValue(null), null);
		assertEquals(streamExample.getMinimumValue(mockProductList).get().doubleValue(), 100.0f);
	}

	@Test
	void testGetTotalValue() {
		assertEquals(0.0, streamExample.getTotalValue(null));
		assertEquals(3400.0, streamExample.getTotalValue(mockProductList));
		
	}

	@Test
	void testConvertIntoMap() {
		Map<Integer, String> expected = new HashMap<Integer, String>();
		expected.put(1, "Samsung j7");
		expected.put(2, "Samsung j1");
		expected.put(3, "iPhone j7");
		expected.put(4, "iPad j7");
		
		Map<Integer, String> result = streamExample.convertIntoMap(mockProductList);
		
		assertEquals(expected.size(), result.size());
		assertTrue(result.containsValue(expected.get(2)));
		//assertTrue(result.containsKey(2) == expected.containsKey(2));
	}

}
