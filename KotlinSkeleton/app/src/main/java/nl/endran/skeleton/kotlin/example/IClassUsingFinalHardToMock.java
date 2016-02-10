package nl.endran.skeleton.kotlin.example;

public interface IClassUsingFinalHardToMock {
    boolean callHardStaticMethodAndReturnParameter(boolean parameter);

    boolean callHardFinalMethodAndReturnParameter(HardToMockFinalClass hardToMockFinalClass, boolean parameter);

    boolean callHardMethodAndReturnParameter(HardToMockFinalClass hardToMockFinalClass, boolean parameter);
}
