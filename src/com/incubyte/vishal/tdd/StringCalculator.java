package com.incubyte.vishal.tdd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class StringCalculator {

	public static int add(String numbersInput) throws NegativeNumberException{
		if (numbersInput.isEmpty())
			return 0;

		String[] numbers = extractNumbersFrom(numbersInput);

		return sum(numbers);
	}

	private static String[] extractNumbersFrom(String stringOfNumbers) {
		String delimiter = ",";
		if (hasCustomDelimiter(stringOfNumbers)) {
			String[] tokens = stringOfNumbers.split("\n", 2);
			delimiter = extract_delimiter_from(tokens[0]);
			stringOfNumbers = tokens[1];
		}
		return stringOfNumbers.replaceAll("\n", delimiter).split(delimiter);
	}

	private static boolean hasCustomDelimiter(String stringOfNumbers) {
		return stringOfNumbers.startsWith("//");
	}

	private static String extract_delimiter_from(String delimiterSection) {
		Pattern pattern = Pattern.compile("//\\[(.+)\\]");
		Matcher matcher = pattern.matcher(delimiterSection);
		matcher.matches();
		return Pattern.quote(matcher.group(1));
	}

	private static int sum(String[] numbers) throws NegativeNumberException {
		int sum = 0;
		boolean flag=false;
		List<Integer> nos=new ArrayList<Integer>();
		for (String i : numbers) {
			if(Integer.valueOf(i)<0) {
				flag=true;
				nos.add(Integer.valueOf(i));
			}
			sum += Integer.valueOf(i);
		}
		if(flag)
			throw new NegativeNumberException("Negatives not allowed " +nos);
		return sum;
	}

}
