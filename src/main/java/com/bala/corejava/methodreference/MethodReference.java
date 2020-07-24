package com.bala.corejava.methodreference;

import java.util.function.BiFunction;

interface SayHello {
	public void sayHello();
}

interface AddNumber {
	public int addNumbers(int x, int y);
}

class ArthematicAdd {
	public static int addNumber(int x, int y) {
		return x + y;
	}

	public static float addNumber(int x, float y) {
		return x + y;
	}

	public static float addNumber(float x, float y) {
		return x + y;
	}
}

public class MethodReference {

	// Normal Lamda function
	static SayHello sayHelloImpl = () -> System.out.println("Say Hello !!!!!");

	public MethodReference() {

	}

	public void sayHelloFromInstance() {
		System.out.println("Saying Hello !!! from sayHelloFromInstance");
	}

	public static void sayHelloFromStatic() {
		System.out.println("Saying Hello !!! from sayHelloFromStatic");
	}

	public void testMethodReference() {
		/*
		 * static method reference giving in Java8
		 */
		Thread thread = new Thread(sayHelloImpl::sayHello);
		thread.start();

		/*
		 * Assinging static method to interface method reference
		 */
		SayHello sayHelloReference = MethodReference::sayHelloFromStatic;

		sayHelloReference.sayHello(); // will call the static assing method ..NOT the implemented.

		SayHello sayHelloImpl = () -> System.out.println("Say Hello !!!!! re-assigning ");

		sayHelloImpl.sayHello();
	}

	public void testBIFunction() {

		BiFunction<Integer, Integer, Integer> adder = ArthematicAdd::addNumber;
		BiFunction<Integer, Float, Float> adder1 = ArthematicAdd::addNumber;
		BiFunction<Float, Float, Float> adder2 = ArthematicAdd::addNumber;

		int result = adder.apply(10, 20);

		System.out.println("BI Function result:: " + result);

		float result_f = adder1.apply(10, 20.3f);

		System.out.println("BI Function result:: " + result_f);

		result_f = adder2.apply(10.23f, 20.34f);

		System.out.println("BI Function result:: " + result_f);

	}

	public void testReferenceInstanceMethod() {

		MethodReference methodReference = new MethodReference();
		SayHello sayHello = methodReference::sayHelloFromInstance;
		System.out.println("Reference method with instance :: " + sayHello);

		SayHello sayHello1 = new MethodReference()::sayHelloFromInstance;
		System.out.println("REference method with instance and anonimous method :: " + sayHello1);
	}
}
