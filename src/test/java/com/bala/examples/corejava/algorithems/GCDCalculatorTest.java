package com.bala.examples.corejava.algorithems;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GCDCalculatorTest {
	
	GCDCalculator gcdCalculator = new GCDCalculator();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGCDCalulatorPossitiveNumberWithLessThen1() {
		assertEquals(0, gcdCalculator.getGCDValueOfNumbers(1, 0));
		assertEquals(0, gcdCalculator.getGCDValueOfNumbers(0, 0));
		assertEquals(0, gcdCalculator.getGCDValueOfNumbers(-20, 8));
	}
	@Test
	void testGCDCalulatorPossitiveNumberWithGreaterThen0() {
		assertEquals(4, gcdCalculator.getGCDValueOfNumbers(20, 8));
	}
	@Test
	void testGCDCalulatorPossitiveNumberFirstnumberIsGreaterThanSecondNumber() {
		assertEquals(4, gcdCalculator.getGCDValueOfNumbers(20, 8));
	}
	@Test
	void testGCDCalulatorPossitiveNumberFirstnumberIsLessThanSecondNumber() {
		assertEquals(12, gcdCalculator.getGCDValueOfNumbers(60, 96));
	}
	
}
