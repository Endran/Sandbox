package nl.endran.skeleton.kotlin.example

import mockit.Mocked
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class ClassUsingFinalHardToMockKotlinTest {

    lateinit var someClass: ClassUsingFinalHardToMock

    @Before
    fun setUp() {
        someClass = ClassUsingFinalHardToMock()
    }

    @Test
    fun ShouldReturnTrue_WhenMethodUsingStaticIsCalled() {
        val value = someClass.callHardStaticMethodAndReturnParameter(true)

        assertThat(value).isTrue()
    }

    @Test
    fun ShouldReturnTrue_WhenMethodUsingFinalIsCalled(
            @Mocked hardToMockClass: HardToMockFinalClass) {
        //        new Exception(){{
        //            hardToMockClass.goodLuckMockingThisFinalMethod();
        //        }};

        val anotherInstance = HardToMockFinalClass()
        val value = someClass.callHardFinalMethodAndReturnParameter(anotherInstance, true)

        assertThat(value).isTrue()
    }

    @Test
    fun ShouldReturnTrue_WhenMethodUsingNormalIsCalled() {
        //        new Exception(){{
        //            hardToMockClass.goodLuckMockingThisFinalMethod();
        //        }};

        val anotherInstance = HardToMockFinalClass()
        val value = someClass.callHardMethodAndReturnParameter(anotherInstance, true)

        assertThat(value).isTrue()
    }
}