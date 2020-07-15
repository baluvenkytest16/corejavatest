package com.bala.corejava.lamdaexp;

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

	public void printValue(String value) {
		System.out.println("output value : " + value);
	}

	public static void main(String[] args) {

		LamdaExpression lamdaTest = new LamdaExpression();
		/*
		 * Add the implementation for inteface methods.
		 * */
		Summation sum = (x, y) -> (x + y);
		
		/*
		 * Add the implementation for inteface methods.
		 * */
		
		addOnPlus5 addPlus5 = (x) -> x + 5;

		/*
		 *  Print values method
		 *  */
		lamdaTest.printValue("Summation using lamda :: " + sum.addNumbers(10, sum.addNumbers(10, 20)));
		
		lamdaTest.printValue("Add on5 method ::" + addPlus5.addValueOnPlus5(100));

	}

}
