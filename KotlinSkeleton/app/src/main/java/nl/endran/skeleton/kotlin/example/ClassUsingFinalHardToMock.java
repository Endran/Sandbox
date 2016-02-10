package nl.endran.skeleton.kotlin.example;

public class ClassUsingFinalHardToMock implements IClassUsingFinalHardToMock {

    @Override
    public boolean callHardStaticMethodAndReturnParameter(boolean parameter) {
        HardToMockFinalClass.goodLuckMockingThisStaticMethod();
        return parameter;
    }


    @Override
    public boolean callHardFinalMethodAndReturnParameter(HardToMockFinalClass hardToMockFinalClass, boolean parameter) {
        hardToMockFinalClass.goodLuckMockingThisFinalMethod();
        return parameter;
    }


    @Override
    public boolean callHardMethodAndReturnParameter(HardToMockFinalClass hardToMockFinalClass, boolean parameter) {
        hardToMockFinalClass.goodLuckMockingThisNormalMethod();
        return parameter;
    }
}
