package nl.endran.skeleton.kotlin.example;

public class ClassUsingFinalHardToMock implements IClassUsingFinalHardToMock {

    @Override
    public boolean callHardStaticMethodAndReturnParameter(boolean parameter) {
        return HardToMockFinalClass.goodLuckMockingThisStaticMethod(parameter);
    }


    @Override
    public boolean callHardFinalMethodAndReturnParameter(HardToMockFinalClass hardToMockFinalClass, boolean parameter) {
        return hardToMockFinalClass.goodLuckMockingThisFinalMethod(parameter);
    }

    public boolean callOpenHardFinalMethodAndReturnParameter(HardToMockOpenClass hardToMockOpenClass, boolean parameter) {
        return hardToMockOpenClass.goodLuckMockingThisFinalMethod(parameter);
    }


    @Override
    public boolean callHardMethodAndReturnParameter(HardToMockFinalClass hardToMockFinalClass, boolean parameter) {
        return hardToMockFinalClass.goodLuckMockingThisNormalMethod(parameter);
    }
}
