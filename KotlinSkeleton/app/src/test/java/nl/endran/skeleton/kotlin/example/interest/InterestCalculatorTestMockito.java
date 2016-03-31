package nl.endran.skeleton.kotlin.example.interest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class InterestCalculatorTestMockito {

    @Mock
    private InterestManager interestManager;

    private InterestCalculator calculator;

    @Before
    public void setUp() {
        initMocks(this);
        calculator = new InterestCalculator();
    }

    @Test
    public void shouldCalculateCorrectAmountOfInterest() {
        when(interestManager.getMonthlyInterestPercentage()).thenReturn(5d);

        double yearlyInterest = calculator.getYearlyInterest( 5000);

        assertThat(yearlyInterest).isEqualTo(255.81, within(0.005)); // We want to ignore value's below 1 cent
    }
}
