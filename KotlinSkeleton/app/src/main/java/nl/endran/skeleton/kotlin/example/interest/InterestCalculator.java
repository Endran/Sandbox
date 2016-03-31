package nl.endran.skeleton.kotlin.example.interest;

public class InterestCalculator {

    public static final int MONTHS_PER_YEAR = 12;

public double getYearlyInterest(final double savings) {
    InterestManager interestManager = new InterestManager();
    double monthlyInterestPercentage = interestManager.getMonthlyInterestPercentage();

    double ratio = monthlyInterestPercentage / 100;
    double base = 1 + ratio / MONTHS_PER_YEAR;
    double power = Math.pow(base, (double) MONTHS_PER_YEAR);
    double interest = savings * (power - 1);

    return interest;
}
}
