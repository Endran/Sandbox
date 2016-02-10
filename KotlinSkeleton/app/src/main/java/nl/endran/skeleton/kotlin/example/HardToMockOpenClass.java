package nl.endran.skeleton.kotlin.example;

import java.util.HashMap;
import java.util.Map;

public class HardToMockOpenClass {

    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("1", "2");
    }

    public static boolean goodLuckMockingThisStaticMethod(boolean parameter) {
        throw new RuntimeException("You oughta mock this static method out!");
    }

    public final boolean goodLuckMockingThisFinalMethod(boolean parameter) {
        throw new RuntimeException("You oughta mock this final method out!");
    }

    public boolean goodLuckMockingThisNormalMethod(boolean parameter) {
        throw new RuntimeException("You oughta mock this method out!");
    }

    public Map<String, String> getMap() {
        return map;
    }

    public static Map<String, String> getMapStatic() {
        return map;
    }
}
