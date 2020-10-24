package com.bala.examples.corejava.algorithems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GCDCalculator {

	/*
	 * In mathematics, the Euclidean algorithm, or Euclid's algorithm, 
	 * is an efficient method for computing the greatest common divisor (GCD) of two integers (numbers), 
	 * the largest number that divides them both without a remainder.
	 */
	public static void main(String[] args) throws IOException {
		List<String> numberList = new ArrayList<String>();
		//Enter data using BufferReader 
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
         
        // Reading data using readLine 
        String number1 = reader.readLine();
        // Reading data using readLine 
        String number2 = reader.readLine();
        reader.close();
        
        /*if(numbers.contains(" ")) {
        	numberList = Arrays.asList(numbers.split(numbers, Character.SPACE_SEPARATOR));
        }
        numberList.stream().mapToInt(num -> Integer.parseInt(num));*/
        
        /*
         * 60, 96 is 12 
         * 20, 8 is 4
         */
        GCDCalculator gcdCalculator = new GCDCalculator();
        System.out.println("GCD value :: "  + gcdCalculator.getGCDValueOfNumbers(Integer.parseInt(number1), Integer.parseInt(number2)));
	}
	public int getGCDValueOfNumbers(int number1, int number2) {
		
		if (number1 <1 || number2 < 1) return 1;
		
		int reminder = number1 > number2 ? number1%number2: number2 %number1;
		if( reminder == 0) {
			return number2;
		}
		return getGCDValueOfNumbers(number2, reminder);
		
		
	}
	
}
