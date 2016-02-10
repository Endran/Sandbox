package nl.endran.skeleton.kotlin.example;

import org.junit.Before;
import org.junit.Test;

import mockit.Expectations;
import mockit.Mocked;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassUsingFinalHardToMockTest {

    private ClassUsingFinalHardToMock someClass;

    @Before
    public void setUp() {
        someClass = new ClassUsingFinalHardToMock();
    }

    @Test
    public void ShouldReturnTrue_WhenMethodUsingStaticIsCalled(@Mocked HardToMockFinalClass hardToMockFinalClass) throws Exception {
        new Expectations() {{
            HardToMockFinalClass.goodLuckMockingThisStaticMethod(true);
            result = true;
        }};

        boolean value = someClass.callHardStaticMethodAndReturnParameter(true);

//        assertThat(value).isTrue();

//        new Verifications() {{
//            HardToMockFinalClass.goodLuckMockingThisStaticMethod(true);
//        }};
    }

    @Test
    public void ShouldReturnTrue_WhenMethodUsingFinalIsCalled(
            @Mocked final HardToMockFinalClass hardToMockClass) {
        new Expectations() {{
            hardToMockClass.goodLuckMockingThisFinalMethod(true);
            result = true;
        }};

        boolean value = someClass.callHardFinalMethodAndReturnParameter(hardToMockClass, true);

        assertThat(value).isTrue();
    }

    @Test
    public void ShouldReturnTrue_WhenMethodUsingNormalIsCalled(
            @Mocked final HardToMockFinalClass hardToMockClass) {
        new Expectations() {{
            hardToMockClass.goodLuckMockingThisNormalMethod(true);
            result = true;
        }};

        boolean value = someClass.callHardMethodAndReturnParameter(hardToMockClass, true);

        assertThat(value).isTrue();
    }
}