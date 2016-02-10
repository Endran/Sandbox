package nl.endran.skeleton.kotlin.example;

import android.support.annotation.NonNull;

public class ClassUsingFinalHardToMockWrapper implements IClassUsingFinalHardToMock {

    @Override
    public boolean callHardStaticMethodAndReturnParameter(boolean parameter) {
        throw new RuntimeException("I surrender");
    }

    @Override
    public boolean callHardFinalMethodAndReturnParameter(HardToMockFinalClass hardToMockFinalClass, boolean parameter) {
        wrap(hardToMockFinalClass).goodLuckMockingThisFinalMethod(parameter);
        return parameter;
    }

    @Override
    public boolean callHardMethodAndReturnParameter(HardToMockFinalClass hardToMockFinalClass, boolean parameter) {
        wrap(hardToMockFinalClass).goodLuckMockingThisNormalMethod(parameter);
        return parameter;
    }

    @NonNull
    protected HardToMockFinalClassWrapper wrap(HardToMockFinalClass hardToMockFinalClass) {
        return new HardToMockFinalClassWrapper(hardToMockFinalClass);
    }
}
