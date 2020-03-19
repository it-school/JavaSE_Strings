package com.itschool;

import java.util.Arrays;
import java.util.regex.Pattern;

public class HomeTask
{
	public static void main(String[] args)
	{
		String testString = "data 48 call 9 read13 blank0a 12a";
		System.out.println("Get only numbers from string: " + testString);

		System.out.println("Using RegExp:");
		String[] words = testString.split(" ");
		for (String word : words) {
			if (Pattern.compile("(^[0-9]+)").matcher(word.trim()).find() && !Pattern.compile("([\\D])").matcher(word.trim()).find()) {
				System.out.println("Number: " + word);
			}
		}

		System.out.println("\nUsing String processing by Character:");
		boolean isNumber;
		for (String word : words) {
			isNumber = true;
			for (char c : word.toCharArray()) {
				if (!Character.isDigit(c)) {
					System.out.println("Non number: " + word);
					isNumber = false;
					break;
				}
			}
			if (isNumber) { System.out.println("Number: " + word); }
		}


		testString = "abc cde def";
		System.out.println("\nRemove spaces and duplicate letters: " + testString);
		char c;
		int len = testString.length();
		for (int i = 0; i < len - 1; i++) {
			c = testString.charAt(i);
			for (int j = i + 1; j < len; j++) {
				if (testString.charAt(j) == ' ' || c == testString.charAt(j)) {
					testString = testString.substring(0, j) + testString.substring(j + 1, len);
					len--;
				}
			}
		}
		System.out.println("Result: " + testString);


		testString = "abc   cde  def     dchd dfghdh frghsh ";
		System.out.println("\nRemove multiple spaces in string");
		System.out.println("Before: " + testString);
		len = testString.length();
		for (int i = 0; i < len - 1; i++) {
			if (testString.charAt(i) == ' ' && testString.charAt(i + 1) == ' ') {
				testString = testString.substring(0, i) + testString.substring(i + 1, len);
				len--;
				i--;
			}
		}
		System.out.println("After: " + testString);


		String[] newWords = {
				"0abc   2cde  3degfhdfjdgtjf     4dchd 5dfghdh 6frghsh     ",
				"1abc   2cde  3degfhdfjdgtjf   4dchd 5dfghdh 6frghsh ",
				"2abc   2cde  3degfhdfjdgtjf 4dchd 5dfghdh 6frvxcbngfhmgfchmghsh ",
				"3abc   2cde  3degfhdfjdgtjfghdh 6frghsh "
		};
		System.out.println("\nFinding string with maximum length: " + Arrays.toString(newWords));
		int maxLen = 0;
		for (int i = 1; i < newWords.length; i++) {
			if (newWords[i].length() > newWords[maxLen].length()) {
				maxLen = i;
			}
		}
		System.out.println("Max: " + newWords[maxLen] + "\t, length = " + newWords[maxLen].length());


		int lowerCase = 0;
		int upperCase = 0;
		testString = "abc SD  SDFcde  def SDF dFGDDfgdfgD dchd dfghdh frghsh ";
		System.out.println("\nCalculate number of UpperCase and LowerCase letters: " + testString);
		for (char ch : testString.toCharArray()) {
			if (Character.isUpperCase(ch)) { upperCase++; }
			else if (Character.isLowerCase(ch)) { lowerCase++; }
		}
		System.out.println("Uppercase letters: " + upperCase + "\nLowercase letters: " + lowerCase);

		testString = "data 48 \ncall     9 read13   blank0a 12a";
		System.out.println("\nCalculate number of words: \n" + testString + "\nWords:");
		int cnt = 0;
		newWords = testString.split(" ");
		for (String w : newWords) {
			if (w.trim().length() > 0 && w.toCharArray()[0] == '\n') { w = w.substring(1); }
			if (w.trim().length() > 0) {
				System.out.println(w);
				cnt++;
			}
		}
		System.out.println("Words number: " + cnt);
	}
}

