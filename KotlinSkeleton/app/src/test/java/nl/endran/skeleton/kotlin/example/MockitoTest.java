package nl.endran.skeleton.kotlin.example;

import android.support.annotation.NonNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class MockitoTest {

    private IClassUsingFinalHardToMock someClass;

    @Mock
    private HardToMockFinalClassWrapper hardToMockClassMock;

    @Before
    public void setUp() {
        initMocks(this);
        someClass = new ClassUsingFinalHardToMockWrapper() {
            @NonNull
            @Override
            protected HardToMockFinalClassWrapper wrap(HardToMockFinalClass hardToMockFinalClass) {
                return hardToMockClassMock;
            }
        };
    }

    @Test
    public void ShouldReturnTrue_WhenMethodUsingStaticIsCalled() {
        boolean value = someClass.callHardStaticMethodAndReturnParameter(true);

        verify(hardToMockClassMock).goodLuckMockingThisStaticMethod(true);
        assertThat(value).isTrue();
    }

    @Test
    public void ShouldReturnTrue_WhenMethodUsingFinalIsCalled() {
        HardToMockFinalClass anotherInstance = new HardToMockFinalClass();

        boolean value = someClass.callHardFinalMethodAndReturnParameter(anotherInstance, true);

        verify(hardToMockClassMock).goodLuckMockingThisFinalMethod(true);
        assertThat(value).isTrue();
    }

    @Test
    public void ShouldReturnTrue_WhenMethodUsingNormalIsCalled() {
        HardToMockFinalClass anotherInstance = new HardToMockFinalClass();

        boolean value = someClass.callHardMethodAndReturnParameter(anotherInstance, true);

        verify(hardToMockClassMock).goodLuckMockingThisNormalMethod(true);
        assertThat(value).isTrue();
    }
}
