package com.incubyte.vishal.tdd.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.incubyte.vishal.tdd.NegativeNumberException;
import com.incubyte.vishal.tdd.StringCalculator;

public class StringCalculatorTest {

	@Test
	public void isZeroForAnEmptyString() throws NegativeNumberException{
		verifyAdd(0, "");
	}

	@Test
	public void isJustTheNumberForAStringWithJustTheNumber() throws NegativeNumberException{
		verifyAdd(1, "1");
	}

	@Test
	public void sumsTheTwoNumbersForAStringOfCommaSeparatedNumbers() throws NegativeNumberException{
		verifyAdd(3, "1,2");
	}

	@Test
	public void sumsAnUnknownAmountOfCommaSeparatedNumbers() throws NegativeNumberException {
		verifyAdd(10, "1,2,3,4");
	}

	@Test
	public void canHandleNewLinesAsNumberDelimiter() throws NegativeNumberException {
		verifyAdd(10, "1\n2,3\n4");
	}

	@Test
	public void supportsDifferentDelimiters() throws NegativeNumberException {
		verifyAdd(10, "//[***]\n1***2***3***4");
	}
	@Test
	public void disallowNegativeNumbers() throws Exception {
		verifyAdd("Negatives not allowed [-2, -3]", "1,-2,-3");
	}

	private void verifyAdd(int expected, String stringOfNumbers) throws NegativeNumberException {
		int result = StringCalculator.add(stringOfNumbers);
		assertEquals(expected, result);
	}
	private void verifyAdd(String expected, String stringOfNumbers) throws NegativeNumberException{
		try {
		StringCalculator.add(stringOfNumbers);
		}
		catch(Exception ex) {
		assertEquals(expected, ex.getMessage());}
	}

}
