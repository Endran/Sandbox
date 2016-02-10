package nl.endran.skeleton.kotlin.example;

import org.junit.Before;
import org.junit.Test;

import mockit.Mocked;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassUsingFinalHardToMockTest {

    private ClassUsingFinalHardToMock someClass;

    @Before
    public void setUp() {
        someClass = new ClassUsingFinalHardToMock();
    }

    @Test
    public void ShouldReturnTrue_WhenMethodUsingStaticIsCalled() {
        boolean value = someClass.callHardStaticMethodAndReturnParameter(true);

        assertThat(value).isTrue();
    }

    @Test
    public void ShouldReturnTrue_WhenMethodUsingFinalIsCalled(
            @Mocked HardToMockFinalClass hardToMockClass) {
//        new Exception(){{
//            hardToMockClass.goodLuckMockingThisFinalMethod();
//        }};

        HardToMockFinalClass anotherInstance = new HardToMockFinalClass();
        boolean value = someClass.callHardFinalMethodAndReturnParameter(anotherInstance, true);

        assertThat(value).isTrue();
    }

    @Test
    public void ShouldReturnTrue_WhenMethodUsingNormalIsCalled() {
//        new Exception(){{
//            hardToMockClass.goodLuckMockingThisFinalMethod();
//        }};

        HardToMockFinalClass anotherInstance = new HardToMockFinalClass();
        boolean value = someClass.callHardMethodAndReturnParameter(anotherInstance, true);

        assertThat(value).isTrue();
    }
}