package com.bala.examples.corejava.algorithems;

import java.util.regex.Pattern;

public class CharaterCheck {

	private static final Pattern[] inputRegexes = new Pattern[4];

	static {
		inputRegexes[0] = Pattern.compile(".*[A-Z].*");
		inputRegexes[1] = Pattern.compile(".*[a-z].*");
		inputRegexes[2] = Pattern.compile(".*\\d.*");
		inputRegexes[3] = Pattern.compile(".*[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?].*");
	}
	private static final String SINGLE_REGEX = "^(?=.*?\\p{Lu})(?=.*?\\p{Ll})(?=.*?\\d)"
			+ "(?=.*?[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?]).*$";
	private static final Pattern SINGLE_REGEX_PATTERN = Pattern.compile(SINGLE_REGEX);
	public CharaterCheck() {

	}

	public boolean isMatchingRegex(String input) {
		if (input == null) return false;
		
		boolean inputMatches = true;
		for (Pattern inputRegex : inputRegexes) {
			if (!inputRegex.matcher(input).matches()) {
				inputMatches = false;
			}
		}
		return inputMatches;
	}
	public boolean isMatchingWithSingleRegex(String input) {
		if (input == null) return false;
		
		return SINGLE_REGEX_PATTERN.matcher(input).matches();
	}
	public boolean checkString(String input) {
		String specialChars = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
		char currentCharacter;
		boolean numberPresent = false;
		boolean upperCasePresent = false;
		boolean lowerCasePresent = false;
		boolean specialCharacterPresent = false;
		
		if (input == null) return false;
		
		for (int i = 0; i < input.length(); i++) {
			currentCharacter = input.charAt(i);
			if (Character.isDigit(currentCharacter)) {
				numberPresent = true;
			} else if (Character.isUpperCase(currentCharacter)) {
				upperCasePresent = true;
			} else if (Character.isLowerCase(currentCharacter)) {
				lowerCasePresent = true;
			} else if (specialChars.contains(String.valueOf(currentCharacter))) {
				specialCharacterPresent = true;
			}
		}

		return numberPresent && upperCasePresent && lowerCasePresent && specialCharacterPresent;
	}

	public static void main(String[] args) {
		
		CharaterCheck characterCheck = new CharaterCheck();
		
		String input1 = "ABCabc123$%%##";
		System.out.printf("\nINPUT : %s contains CAPS LOWER AND NUMBER SPECIALS CHARS : %b", input1, characterCheck.checkString(input1));
		System.out.printf("\nINPUT : %s contains CAPS LOWER AND NUMBER SPECIALS CHARS : %b", input1, characterCheck.isMatchingRegex(input1));
		System.out.printf("\nINPUT : %s contains CAPS LOWER AND NUMBER SPECIALS CHARS : %b", input1, characterCheck.isMatchingWithSingleRegex(input1));
		
		String input2 = "ABCabc123";
		System.out.printf("\n\nINPUT : %s contains CAPS LOWER AND NUMBER SPECIALS CHARS : %b", input2, characterCheck.checkString(input2));
		System.out.printf("\nINPUT : %s contains CAPS LOWER AND NUMBER SPECIALS CHARS : %b", input2, characterCheck.isMatchingRegex(input2));
		System.out.printf("\nINPUT : %s contains CAPS LOWER AND NUMBER SPECIALS CHARS : %b", input2, characterCheck.isMatchingWithSingleRegex(input2));
		
	}
}
