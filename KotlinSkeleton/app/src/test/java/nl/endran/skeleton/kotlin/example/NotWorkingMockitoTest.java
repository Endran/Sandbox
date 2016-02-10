package nl.endran.skeleton.kotlin.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.powermock.api.mockito.PowerMockito.when;

public class NotWorkingMockitoTest {

    //    @Mock
    private HardToMockFinalClass hardToMockClassMock;

    @Mock
    private HardToMockOpenClass openHardToMockClassMock;

    private ClassUsingFinalHardToMock someClass;

    @Before
    public void setUp() {
        initMocks(this);

        someClass = new ClassUsingFinalHardToMock();
    }

    @Test
    public void ShouldReturnTrue_WhenMethodUsingStaticIsCalled() {
        boolean value = someClass.callHardStaticMethodAndReturnParameter(true);

        assertThat(value).isTrue();
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

    @Test
    public void ShouldReturnTrue_WhenMethodUsingOpenFinalIsCalled() {
        when(openHardToMockClassMock.goodLuckMockingThisFinalMethod(true)).thenReturn(true);

        boolean value = someClass.callOpenHardFinalMethodAndReturnParameter(openHardToMockClassMock, true);

        assertThat(value).isTrue();
    }
}
