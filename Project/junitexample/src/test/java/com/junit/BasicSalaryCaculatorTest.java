package com.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BasicSalaryCaculatorTest {

	private BasicSalaryCaculator basicSalaryCalculator;

	@BeforeEach
	void init() {
		basicSalaryCalculator = new BasicSalaryCaculator();
	}

	// Posstive Test
	@DisplayName("Possitive Test")
	@Test
	void testBasicSalaryWithValidSalary() {

		double basicSalary = 4000;
		basicSalaryCalculator.setBasicSalary(basicSalary);

		// to test social Insurance
		double expectedSocialInsurance = basicSalary * 0.25;
		assertEquals(expectedSocialInsurance, basicSalaryCalculator.getSocialInsurance());

		// to test gross
		double bonus = basicSalary * 0.1;
		assertEquals(bonus, basicSalaryCalculator.getAdditionalBonus());

		// to test gross
		double gross = basicSalary + expectedSocialInsurance + bonus;
		assertEquals(gross, basicSalaryCalculator.getGrossSalary());
	}

	@DisplayName("Invalid Test")
	@Test
	void testBasicSalaryWithInvalidSalary() {
		double basicSalary = -100;
		assertThrows(IllegalArgumentException.class, () -> {
			basicSalaryCalculator.setBasicSalary(basicSalary);
		});

	}
}
