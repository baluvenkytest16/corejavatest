package com.bala.examples.corejava.algorithems;

import static org.junit.Assert.assertEquals;

import java.util.StringTokenizer;

import org.junit.Test;

public class WordCounter {

	public static void main(String[] args) {
		WordCounter countWordsInString = new WordCounter();
		String input = "test test qwerqw , asdfs asdfasdf";
		System.out.printf("\n input : %s \n Cont words: %d", input, countWordsInString.countWordsUsingRegex(input));
		System.out.printf("\n input : %s \n Cont words: %d", input, countWordsInString.countWordsManually(input));

	}

	static final int WORD = 0;
	static final int SEPARATOR = 1;

	public static int countWordsUsingRegex(String arg) {
		if (arg == null) {
			return 0;
		}
		final String[] words = arg.split("[\\pP\\s&&[^']]+");
		return words.length;
	}

	public static int countWordsUsingTokenizer(String arg) {
		if (arg == null) {
			return 0;
		}
		final StringTokenizer stringTokenizer = new StringTokenizer(arg);
		return stringTokenizer.countTokens();
	}

	public static int countWordsManually(String arg) {
		if (arg == null) {
			return 0;
		}
		int flag = SEPARATOR;
		int count = 0;
		int stringLength = arg.length();
		int characterCounter = 0;

		while (characterCounter < stringLength) {
			if (isAllowedInWord(arg.charAt(characterCounter)) && flag == SEPARATOR) {
				flag = WORD;
				count++;
			} else if (!isAllowedInWord(arg.charAt(characterCounter))) {
				flag = SEPARATOR;
			}
			characterCounter++;
		}
		return count;
	}

	private static boolean isAllowedInWord(char charAt) {
		return charAt == '\'' || Character.isLetter(charAt);
	}
	@Test
	public void testWordCount() {
		assertEquals(3, new StringTokenizer("three blind mice").countTokens());
		assertEquals(4, new StringTokenizer("see\thow\tthey\trun").countTokens());
		assertEquals(7, new StringTokenizer("the farmer's wife--she was from Albuquerque", " -").countTokens());
		assertEquals(10, new StringTokenizer("did,you,ever,see,such,a,sight,in,your,life", ",").countTokens());
		assertEquals(7, countWordsUsingRegex("the farmer's wife--she was from Albuquerque"));
		assertEquals(9, countWordsUsingRegex("no&one#should%ever-write-like,this;but:well"));
		assertEquals(9, countWordsManually("no&one#should%ever-write-like,this but   well"));
		assertEquals(7, countWordsManually("the farmer's wife--she was from Albuquerque"));
		
	}

}
