package nl.endran.skeleton.kotlin.example.interest

import mockit.Tested
import org.junit.Test

class InterestCalculatorTestKt {

    @Tested
    private val interestCalculator: InterestCalculator? = null

    @Test
    fun ShouldX_WhenY() {
        val yearlyInterest = InterestCalculator().getYearlyInterest(10000.0)
//        assertThat(yearlyInterest).isEqualTo(255.81, within(0.005)) // We want to ignore value's below 1 cent

        assert(yearlyInterest == 1.0) {
            "yearlyInterest = ${yearlyInterest}"
        }
    }

    //    @Test
    //    fun shouldCalculateCorrectAmountOfInterest(@Mocked interestManager: InterestManager) {
    //        object : Expectations() {
    //            init {
    //                InterestManager()
    //                result = interestManager
    //                interestManager.monthlyInterestPercentage
    //                result = 5
    //            }
    //        }
    //
    //        val yearlyInterest = interestCalculator!!.getYearlyInterest(5000.0)
    //
    //        assertThat(yearlyInterest).isEqualTo(255.81, within(0.005)) // We want to ignore value's below 1 cent
    //    }
    //
    //    @Test
    //    @Throws(InterruptedException::class)
    //    fun shouldCallThreadSleep(@Mocked thread: Thread) {
    //        val interestManager = InterestManager()
    //
    //        interestManager.monthlyInterestPercentage
    //
    //        object : Verifications() {
    //            init {
    //                Thread.sleep(5000)
    //            }
    //        }
    //    }
    //
    //    @Test
    //    @Throws(InterruptedException::class)
    //    fun shouldCaptureSomething(
    //            @Mocked thread: Thread,
    //            @Injectable handler: Thread.UncaughtExceptionHandler) {
    //        Thread.setDefaultUncaughtExceptionHandler(handler)
    //
    //        object : Verifications() {
    //            init {
    //                val handlerList = ArrayList<Thread.UncaughtExceptionHandler>()
    //                Thread.setDefaultUncaughtExceptionHandler(withCapture(handlerList))
    //                assertThat(handlerList).containsExactly(handler)
    //            }
    //        }
    //    }
}
