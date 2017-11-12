package com.nts.study.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.nts.study.calculator.Calculator;

public class CalculratorTest {
	private Calculator calculator;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Before
	public void init() {
		calculator = new Calculator();
	}

	@Test
	public void addTest_빈문자열이거나비형식문자열() {
		assertEquals(calculator.add(""), 0);
		assertEquals(calculator.add("asdlcnasdnuiaweucai"), 0);
	}

	@Test
	public void addTest_성공() {
		assertEquals(calculator.add("12"), 12);

		assertEquals(calculator.add("3,2,3"), 8);
		assertEquals(calculator.add("3:2,3"), 8);
		assertEquals(calculator.add("asdfadfad!@#$3:2,3"), 8);
		assertEquals(calculator.add("3:asasdf2,,3"), 8);
	}

	@Test
	public void addTest_음수가포함된경우에러() {
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("text contains negative number!");
		
		calculator.add("asdfjadkfjnasdjfasdf,sadf,-1");
	}

}
