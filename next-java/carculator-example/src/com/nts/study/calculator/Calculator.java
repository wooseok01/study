package com.nts.study.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
	private static final String[] SEPERATOR = { ",", ":" };
	private String validMatcher;
	private String seperatorMatcher;

	public Calculator() {
		setSeperatorMatcher();
		setValidMatcher();
	}

	public int add(String text) {
		int result = 0;

		for (String number : getNumbersFromText(text)) {
			try {
				if (isNegativeNumber(number)) {
					throw new RuntimeException("text contains negative number!");
				}

				result += Integer.parseInt(number);

			} catch (NumberFormatException numberFormatException) {
				continue;
			}
		}

		return result;
	}

	private boolean isNegativeNumber(String number) {
		if (Integer.parseInt(number) < 0) {
			return true;
		}

		return false;
	}

	private List<String> getNumbersFromText(String text) {
		List<String> numbers = new ArrayList<>();

		if (text == null || text.isEmpty()) {
			return numbers;
		}

		// 1. 유요한 문자열만 가지고 온다.
		text = text.replaceAll(validMatcher, "");

		// 2. 해당 문자열을 return한다.
		for (String index : text.split(seperatorMatcher)) {
			numbers.add(index);
		}

		return numbers;
	}

	private void setValidMatcher() {
		validMatcher = "[^([+-]?\\d*)";
		for (String seperator : SEPERATOR) {
			validMatcher += "|^" + seperator;
		}
		validMatcher += "|^-]";
	}

	private void setSeperatorMatcher() {
		seperatorMatcher = "[";
		for (int i = 0; i < SEPERATOR.length; i++) {
			if (i != SEPERATOR.length - 1) {
				seperatorMatcher += SEPERATOR[i] + "|";
				continue;
			}

			seperatorMatcher += SEPERATOR[i];
		}

		seperatorMatcher += "]";
	}
}
