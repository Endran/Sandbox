package nl.endran.skeleton.kotlin.example;

public final class HardToMockFinalClass {

    public static boolean goodLuckMockingThisStaticMethod(boolean parameter) {
        throw new RuntimeException("You oughta mock this static method out!");
    }

    public final boolean goodLuckMockingThisFinalMethod(boolean parameter) {
        throw new RuntimeException("You oughta mock this final method out!");
    }

    public boolean goodLuckMockingThisNormalMethod(boolean parameter) {
        throw new RuntimeException("You oughta mock this method out!");
    }
}
