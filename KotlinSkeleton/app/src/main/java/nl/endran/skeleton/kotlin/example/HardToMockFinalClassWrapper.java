package nl.endran.skeleton.kotlin.example;

public class HardToMockFinalClassWrapper {
    private HardToMockFinalClass original;

    public HardToMockFinalClassWrapper(HardToMockFinalClass original) {
        this.original = original;
    }

    public void goodLuckMockingThisStaticMethod() {
        HardToMockFinalClass.goodLuckMockingThisStaticMethod();
    }

    public void goodLuckMockingThisFinalMethod() {
        original.goodLuckMockingThisFinalMethod();
    }

    public void goodLuckMockingThisNormalMethod() {
        original.goodLuckMockingThisNormalMethod();
    }
}
