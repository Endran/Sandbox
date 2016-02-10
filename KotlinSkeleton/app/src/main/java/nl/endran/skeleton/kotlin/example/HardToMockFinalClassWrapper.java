package nl.endran.skeleton.kotlin.example;

public class HardToMockFinalClassWrapper {
    private HardToMockFinalClass original;

    public HardToMockFinalClassWrapper(HardToMockFinalClass original) {
        this.original = original;
    }

    public boolean goodLuckMockingThisStaticMethod(boolean parameter) {
        return HardToMockFinalClass.goodLuckMockingThisStaticMethod(parameter);
    }

    public boolean goodLuckMockingThisFinalMethod(boolean parameter) {
        return original.goodLuckMockingThisFinalMethod(parameter);
    }

    public boolean goodLuckMockingThisNormalMethod(boolean parameter) {
        return original.goodLuckMockingThisNormalMethod(parameter);
    }
}
