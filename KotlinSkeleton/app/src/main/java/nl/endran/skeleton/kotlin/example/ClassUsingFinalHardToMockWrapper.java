package nl.endran.skeleton.kotlin.example;

import android.support.annotation.NonNull;

public class ClassUsingFinalHardToMockWrapper implements IClassUsingFinalHardToMock {

    private ClassUsingFinalHardToMockWrapper hardTo;

    @Override
    public boolean callHardStaticMethodAndReturnParameter(boolean parameter) {
        throw new RuntimeException("I surrender");
    }

    @Override
    public boolean callHardFinalMethodAndReturnParameter(HardToMockFinalClass hardToMockFinalClass, boolean parameter) {
        HardToMockFinalClassWrapper wrapper = wrap(hardToMockFinalClass);
        wrapper.goodLuckMockingThisFinalMethod();
        return parameter;
    }

    @Override
    public boolean callHardMethodAndReturnParameter(HardToMockFinalClass hardToMockFinalClass, boolean parameter) {
        HardToMockFinalClassWrapper wrapper = wrap(hardToMockFinalClass);
        wrapper.goodLuckMockingThisNormalMethod();
        return parameter;
    }

    @NonNull
    protected HardToMockFinalClassWrapper wrap(HardToMockFinalClass hardToMockFinalClass) {
        return new HardToMockFinalClassWrapper(hardToMockFinalClass);
    }
}
