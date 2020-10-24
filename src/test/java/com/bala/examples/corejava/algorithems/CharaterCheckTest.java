package com.bala.examples.corejava.algorithems;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CharaterCheckTest {

	CharaterCheck charaterCheck = new CharaterCheck();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsMatchingRegexWithValidString() {
		assertTrue(charaterCheck.isMatchingRegex("AasdflsdTE$12121"));
	}
	@Test
	public void testIsMatchingRegexWithNOTValidString() {
		assertFalse(charaterCheck.isMatchingRegex("$12121"));
	}
	@Test
	public void testIsMatchingRegexWithNULL() {
		assertFalse(charaterCheck.isMatchingRegex(null));
	}
	@Test
	public void testisMatchingWithSingleRegexWithValidString() {
		assertTrue(charaterCheck.isMatchingWithSingleRegex("AasdflsdTE$12121"));
	}
	@Test
	public void testisMatchingWithSingleRegexNOTValidString() {
		assertFalse(charaterCheck.isMatchingWithSingleRegex("$12121"));
	}
	@Test
	public void testisMatchingWithSingleRegexWithNULL() {
		assertFalse(charaterCheck.isMatchingWithSingleRegex(null));
	}
	@Test
	public void testCheckStringWithValidString() {
		assertTrue(charaterCheck.checkString("AasdflsdTE$12121"));
	}
	@Test
	public void testCheckStringNOTValidString() {
		assertFalse(charaterCheck.checkString("$12121"));
	}
	@Test
	public void testCheckStringWithNULL() {
		assertFalse(charaterCheck.checkString(null));
	}
}
