package nl.endran.skeleton.kotlin.example;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassUsingOpenHardToMockTest {

        @Mocked
//    @Injectable
    HardToMockOpenClass hardToMockClass;

    private ClassUsingOpenHardToMock someClass;

    @Before
    public void setUp() {
        someClass = new ClassUsingOpenHardToMock();
    }

    @Test
    public void ShouldReturnTrue_WhenMethodUsingStaticIsCalled() {
        boolean value = someClass.callHardStaticMethodAndReturnParameter(true);

        assertThat(value).isTrue();
    }

    @Test
    public void ShouldReturnTrue_WhenMethodUsingFinalIsCalled() {
//        new Exception(){{
//            hardToMockClass.goodLuckMockingThisFinalMethod();
//        }};

//        HardToMockOpenClass anotherInstance = new HardToMockOpenClass();
        boolean value = someClass.callHardOpenMethodAndReturnParameter(hardToMockClass, true);

        assertThat(value).isTrue();
    }

    @Test
    public void ShouldReturnTrue_WhenMethodUsingNormalIsCalled() {
//        new Exception(){{
//            hardToMockClass.goodLuckMockingThisFinalMethod();
//        }};

        HardToMockOpenClass anotherInstance = new HardToMockOpenClass();
        boolean value = someClass.callHardMethodAndReturnParameter(anotherInstance, true);

        assertThat(value).isTrue();
    }

    @Test
    public void ShouldX_WhenY() {
        Map<String, String> map = someClass.getMap();
        assertThat(map.get("1")).isEqualTo("2");
    }

    @Test
    public void ShouldCallConstructor_WhenInvoked() {
        new Expectations(){{
            new HardToMockOpenClass();
        }};

        HardToMockOpenClass hardToMockOpenClass = someClass.willCallConstructor();
        assertThat(hardToMockOpenClass).isNotNull();

        new Verifications(){{
            new HardToMockOpenClass();
        }};
    }
}