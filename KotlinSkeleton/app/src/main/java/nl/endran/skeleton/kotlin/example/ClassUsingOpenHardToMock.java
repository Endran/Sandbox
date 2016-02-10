package nl.endran.skeleton.kotlin.example;

import java.util.Map;

public class ClassUsingOpenHardToMock {

    public boolean callHardStaticMethodAndReturnParameter(boolean parameter) {
        HardToMockOpenClass.goodLuckMockingThisStaticMethod();
        return parameter;
    }

    public boolean callHardOpenMethodAndReturnParameter(HardToMockOpenClass hardToMockOpenClass, boolean parameter) {
        hardToMockOpenClass.goodLuckMockingThisFinalMethod();
        return parameter;
    }

    public boolean callHardMethodAndReturnParameter(HardToMockOpenClass hardToMockOpenClass, boolean parameter) {
        hardToMockOpenClass.goodLuckMockingThisNormalMethod();
        return parameter;
    }

    public  Map<String, String> getMap() {
        return HardToMockOpenClass.getMapStatic();
    }
}
