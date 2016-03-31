package nl.endran.skeleton.kotlin.example

class KInterest() {

    val MONTHS_PER_YEAR = 12.0

    fun getYearlyInterest(calculator: KCalculator, savings: Double, monthlyPercentage: Int): Double {
        val ratio = monthlyPercentage / 100.0
        val base = 1 + ratio / MONTHS_PER_YEAR
        return savings * (calculator.power(base, MONTHS_PER_YEAR) - 1)
    }
}