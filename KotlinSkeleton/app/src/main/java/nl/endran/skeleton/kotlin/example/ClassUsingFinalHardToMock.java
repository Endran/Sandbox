package nl.endran.skeleton.kotlin.example;

public class ClassUsingFinalHardToMock {

    public boolean callHardStaticMethodAndReturnParameter(boolean parameter) {
        HardToMockFinalClass.goodLuckMockingThisStaticMethod();
        return parameter;
    }

    public boolean callHardFinalMethodAndReturnParameter(HardToMockFinalClass hardToMockFinalClass, boolean parameter) {
        hardToMockFinalClass.goodLuckMockingThisFinalMethod();
        return parameter;
    }

    public boolean callHardMethodAndReturnParameter(HardToMockFinalClass hardToMockFinalClass, boolean parameter) {
        hardToMockFinalClass.goodLuckMockingThisNormalMethod();
        return parameter;
    }
}
