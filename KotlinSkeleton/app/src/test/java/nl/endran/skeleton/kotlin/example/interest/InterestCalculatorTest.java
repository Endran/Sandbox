package nl.endran.skeleton.kotlin.example.interest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import mockit.Verifications;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class InterestCalculatorTest {

    @Tested
    private InterestCalculator interestCalculator;

@Test
public void shouldCalculateCorrectAmountOfInterest(@Mocked final InterestManager interestManager) {
    new Expectations() {{
        new InterestManager();
        result = interestManager;
        interestManager.getMonthlyInterestPercentage();
        result = 5;
    }};

    double yearlyInterest = interestCalculator.getYearlyInterest( 5000);

    assertThat(yearlyInterest).isEqualTo(255.81, within(0.005)); // We want to ignore value's below 1 cent
}

    @Test
    public void shouldCallThreadSleep(@Mocked final Thread thread) throws InterruptedException {
        InterestManager interestManager = new InterestManager();

        interestManager.getMonthlyInterestPercentage();

        new Verifications() {{
            Thread.sleep(5000);
        }};
    }

    @Test
    public void shouldCaptureSomething(
            @Mocked final Thread thread,
            @Injectable final Thread.UncaughtExceptionHandler handler) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(handler);

        new Verifications() {{
            List<Thread.UncaughtExceptionHandler> handlerList = new ArrayList<>();
            Thread.setDefaultUncaughtExceptionHandler(withCapture(handlerList));
            assertThat(handlerList).containsExactly(handler);
        }};
    }
}
