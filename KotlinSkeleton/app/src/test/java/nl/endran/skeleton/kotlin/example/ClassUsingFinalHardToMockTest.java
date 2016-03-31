package nl.endran.skeleton.kotlin.example;

import android.content.Context;
import android.content.SharedPreferences;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import mockit.Delegate;
import mockit.Expectations;
import mockit.Mocked;
import nl.endran.skeleton.kotlin.BuildConfig;
import nl.endran.skeleton.kotlin.MyTestRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MyTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
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

    @Test
    public void DelegateExample(@Mocked final HardToMockFinalClass hardToMockClass) {
        new Expectations() {{
            hardToMockClass.goodLuckMockingThisNormalMethod(true);
            result = new Delegate<Boolean>() {
                public boolean delegate(boolean parameter) {
                    return !parameter;
                }
            };
        }};

        boolean value = someClass.callHardMethodAndReturnParameter(hardToMockClass, true);

        assertThat(value).isTrue();
    }


    @Test
    public void RobolectricAndDelegateExample(@Mocked final HardToMockFinalClass hardToMockClass) {
        new Expectations() {{
            hardToMockClass.goodLuckMockingThisNormalMethod(true);
            result = new Delegate<Boolean>() {
                public boolean delegate(boolean parameter) {
                    return !parameter;
                }
            };
        }};

        boolean value = someClass.callHardMethodAndReturnParameter(hardToMockClass, true);

        assertThat(value).isTrue();

        SharedPreferences sharedPreferences = RuntimeEnvironment.application.getSharedPreferences("testPreferences", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("KEY", "VALUE").apply();

        assertThat(sharedPreferences.getString("KEY", null)).isEqualTo("VALUE");
    }
}