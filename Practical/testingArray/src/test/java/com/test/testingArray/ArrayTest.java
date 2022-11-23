package com.test.testingArray;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayTest {

	private MaximumArray max;

	@BeforeEach
	void inint() {
		max = new MaximumArray();
	}

	@Test
	void test1() {
		int[] arr = { 1, 2, 3, 4, 5 };

		assertEquals(5, max.maxMin(arr));
	}

	@Test
	void test2() {
		int[] arr = { 1, 2, 3, 4, 5 };
		assertEquals(1, max.min(arr));
	}

	@Test
	void test3() {
		int[] arr = { -1, 2, 3, 4, 5 };
		assertEquals(2, max.min(arr));
	}

}
