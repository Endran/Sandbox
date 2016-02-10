package nl.endran.skeleton.kotlin.example

import mockit.Mocked
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class ClassUsingOpenHardToMockKotlinTest {

    @Mocked
    lateinit internal var hardToMockClass: HardToMockOpenClass

    private var someClass: ClassUsingOpenHardToMock? = null

    @Before
    fun setUp() {
        someClass = ClassUsingOpenHardToMock()
    }

    @Test
    fun ShouldReturnTrue_WhenMethodUsingStaticIsCalled() {
        val value = someClass!!.callHardStaticMethodAndReturnParameter(true)

        assertThat(value).isTrue()
    }

    @Test
    fun ShouldReturnTrue_WhenMethodUsingFinalIsCalled() {
        //        new Exception(){{
        //            hardToMockClass.goodLuckMockingThisFinalMethod();
        //        }};

        //        HardToMockOpenClass anotherInstance = new HardToMockOpenClass();
        val value = someClass!!.callHardOpenMethodAndReturnParameter(hardToMockClass, true)

        assertThat(value).isTrue()
    }

    @Test
    fun ShouldReturnTrue_WhenMethodUsingNormalIsCalled() {
        //        new Exception(){{
        //            hardToMockClass.goodLuckMockingThisFinalMethod();
        //        }};

        val anotherInstance = HardToMockOpenClass()
        val value = someClass!!.callHardMethodAndReturnParameter(anotherInstance, true)

        assertThat(value).isTrue()
    }

    @Test
    fun ShouldX_WhenY() {
        val map = someClass!!.map
        assertThat(map["1"]).isEqualTo("2")
    }
}