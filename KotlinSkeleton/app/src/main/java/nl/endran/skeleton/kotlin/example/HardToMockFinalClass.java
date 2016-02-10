package nl.endran.skeleton.kotlin.example;

public final class HardToMockFinalClass {

    public static void goodLuckMockingThisStaticMethod() {
        throw new RuntimeException("You oughta mock this static method out!");
    }

    public final void goodLuckMockingThisFinalMethod() {
        throw new RuntimeException("You oughta mock this final method out!");
    }

    public void goodLuckMockingThisNormalMethod() {
        throw new RuntimeException("You oughta mock this method out!");
    }
}
