package nl.endran.skeleton.kotlin.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({HardToMockFinalClass.class})
public class PowerMockTest {

    private HardToMockFinalClass hardToMockClassMock;
    private ClassUsingFinalHardToMock someClass;

    @Before
    public void setUp() {
        mockStatic(HardToMockFinalClass.class);
        hardToMockClassMock = mock(HardToMockFinalClass.class);

        someClass = new ClassUsingFinalHardToMock();
    }

    @Test
    public void ShouldReturnTrue_WhenMethodUsingStaticIsCalled() {
        when(HardToMockFinalClass.goodLuckMockingThisStaticMethod(true)).thenReturn(true);

        boolean value = someClass.callHardStaticMethodAndReturnParameter(true);

        assertThat(value).isTrue();

        verifyStatic();
        HardToMockFinalClass.goodLuckMockingThisStaticMethod(true);
    }

    @Test
    public void ShouldReturnTrue_WhenMethodUsingFinalIsCalled() {
        when(hardToMockClassMock.goodLuckMockingThisFinalMethod(true)).thenReturn(true);

        boolean value = someClass.callHardFinalMethodAndReturnParameter(hardToMockClassMock, true);

        assertThat(value).isTrue();
    }

    @Test
    public void ShouldReturnTrue_WhenMethodUsingNormalIsCalled() {
        when(hardToMockClassMock.goodLuckMockingThisNormalMethod(true)).thenReturn(true);

        boolean value = someClass.callHardMethodAndReturnParameter(hardToMockClassMock, true);

        assertThat(value).isTrue();
    }
}
