package edu.westga.cs6242.patrickdeaninvestmentcalculator;

import org.junit.Test;

import edu.westga.cs6242.patrickdeaninvestmentcalculator.model.InvestmentCalculator;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class InvestmentCalculatorTests {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void investmentCalculator_CalculateIsCorrectWithTutorialNumbers() throws Exception {
        InvestmentCalculator i = new InvestmentCalculator(1000, .02, 5);
        assertEquals(5204.04, i.calculateFutureValueOfAnAnnuity(), 0.1);
    }

    @Test
    public void investmentCalculator_CalculateIsCorrectWithOddNumbers() throws Exception {
        InvestmentCalculator i = new InvestmentCalculator(1675, .10, 25);
        assertEquals(164731.32, i.calculateFutureValueOfAnAnnuity(), 0.1);
    }

    @Test
    public void investmentCalculator_CalculateIsCorrectWithNormalNumbers() throws Exception {
        InvestmentCalculator i = new InvestmentCalculator(300, .05, 36);
        assertEquals(28750.89, i.calculateFutureValueOfAnAnnuity(), 0.1);
    }
}