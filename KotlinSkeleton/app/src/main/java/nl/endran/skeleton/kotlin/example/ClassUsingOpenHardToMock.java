package nl.endran.skeleton.kotlin.example;

import java.util.Map;

public class ClassUsingOpenHardToMock {

    public boolean callHardStaticMethodAndReturnParameter(boolean parameter) {
        return HardToMockOpenClass.goodLuckMockingThisStaticMethod(parameter);
    }

    public boolean callHardOpenMethodAndReturnParameter(HardToMockOpenClass hardToMockOpenClass, boolean parameter) {
        return hardToMockOpenClass.goodLuckMockingThisFinalMethod(parameter);
    }

    public boolean callHardMethodAndReturnParameter(HardToMockOpenClass hardToMockOpenClass, boolean parameter) {
        return hardToMockOpenClass.goodLuckMockingThisNormalMethod(parameter);
    }

    public Map<String, String> getMap() {
        return HardToMockOpenClass.getMapStatic();
    }

    public HardToMockOpenClass willCallConstructor() {
        return new HardToMockOpenClass();
    }
}
